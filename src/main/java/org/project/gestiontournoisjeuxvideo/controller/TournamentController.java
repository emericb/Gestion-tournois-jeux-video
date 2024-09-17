package org.project.gestiontournoisjeuxvideo.controller;

import jakarta.servlet.http.HttpSession;
import org.project.gestiontournoisjeuxvideo.entity.Tournament;
import org.project.gestiontournoisjeuxvideo.entity.User;
import org.project.gestiontournoisjeuxvideo.service.*;
import org.project.gestiontournoisjeuxvideo.util.Format;
import org.project.gestiontournoisjeuxvideo.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TournamentController {

    private final UserService userService;
    private final ParticipationService participationService;
    private final TournamentService tournamentService;
    private final MatchService matchService;
    private final LoginService loginService;

    private HttpSession httpSession;

    @Autowired
    public TournamentController(HttpSession httpSession, LoginService loginService, UserService userService, ParticipationService participationService, TournamentService tournamentService, MatchService matchService) {
        this.userService = userService;
        this.participationService = participationService;
        this.tournamentService = tournamentService;
        this.matchService = matchService;
        this.loginService = loginService;
        this.httpSession = httpSession;
    }

    @RequestMapping("/tournament")
    public String tournament(Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        User user = userService.getByEmail((String) httpSession.getAttribute("email"));
        model.addAttribute("tournaments", tournamentService.getAll());
        model.addAttribute("tournament", new Tournament());
        model.addAttribute("isAdmin", user.getRole() == Role.ADMIN);
        return "tournament";
    }

    @RequestMapping("/tournament-registration")
    public String registration(Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        User user = userService.getByEmail((String) httpSession.getAttribute("email"));
        if (user.getRole() != Role.ADMIN) {
            return "redirect:/tournament";
        }

        model.addAttribute("tournament", new Tournament());
        model.addAttribute("isAdmin", user.getRole() == Role.ADMIN);
        return "tournament-registration";
    }

    @PostMapping("/tournament-registration")
    public String inscriptionPost(@ModelAttribute("tournament") Tournament tournament) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        User user = userService.getByEmail((String) httpSession.getAttribute("email"));
        if (user.getRole() != Role.ADMIN) {
            return "redirect:/tournament";
        }

        tournamentService.save(tournament);
        return "redirect:/tournament";
    }
}


