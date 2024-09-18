package org.project.gestiontournoisjeuxvideo.controller;

import jakarta.servlet.http.HttpSession;
import org.project.gestiontournoisjeuxvideo.entity.Match;
import org.project.gestiontournoisjeuxvideo.entity.Tournament;
import org.project.gestiontournoisjeuxvideo.entity.User;
import org.project.gestiontournoisjeuxvideo.service.*;
import org.project.gestiontournoisjeuxvideo.util.Role;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MatchController {

    private final MatchService matchService;
    private final LoginService loginService;
    private final UserService userService;
    private final HttpSession httpSession;
    private final TournamentService tournamentService;

    public MatchController(MatchService matchService, TournamentService tournamentService, LoginService loginService, UserService userService, HttpSession httpSession) {
        this.matchService = matchService;
        this.tournamentService = tournamentService;
        this.loginService = loginService;
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @RequestMapping("/match/{id_tournament}")
    public String match(Model model, @PathVariable int id_tournament) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        User user = userService.getByEmail((String) httpSession.getAttribute("email"));
        Tournament tournament = tournamentService.getById(id_tournament);

        model.addAttribute("tournament", tournament);
        model.addAttribute("matchs", matchService.getMatchesByTournois(tournament));
        model.addAttribute("isAdmin", user.getRole() == Role.ADMIN);
        model.addAttribute("match", new Match());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("userlog", httpSession.getAttribute("user"));
        return "match";
    }

    @PostMapping("/match/{id_tournament}")
    public String createMatch(@ModelAttribute("match") Match match, @PathVariable int id_tournament, Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        Tournament tournament = tournamentService.getById(id_tournament);
        match.setTournament(tournament);

        try {
            matchService.save(match);
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errorMessage", "Erreur lors de l'enregistrement du match.");
            return "match";
        }

        return "redirect:/match/" + id_tournament;
    }
}
