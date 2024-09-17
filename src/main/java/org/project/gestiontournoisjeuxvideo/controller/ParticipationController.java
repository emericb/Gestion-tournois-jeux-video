package org.project.gestiontournoisjeuxvideo.controller;

import jakarta.servlet.http.HttpSession;
import org.project.gestiontournoisjeuxvideo.entity.Participation;
import org.project.gestiontournoisjeuxvideo.entity.Tournament;
import org.project.gestiontournoisjeuxvideo.entity.User;
import org.project.gestiontournoisjeuxvideo.service.LoginService;
import org.project.gestiontournoisjeuxvideo.service.ParticipationService;
import org.project.gestiontournoisjeuxvideo.service.TournamentService;
import org.project.gestiontournoisjeuxvideo.service.UserService;
import org.project.gestiontournoisjeuxvideo.util.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParticipationController {

    private final LoginService loginService;
    private final UserService userService;
    private final HttpSession httpSession;
    private final ParticipationService participationService;
    private final TournamentService tournamentService;

    public ParticipationController(TournamentService tournamentService, ParticipationService participationService, LoginService loginService, UserService userService, HttpSession httpSession) {
        this.loginService = loginService;
        this.userService = userService;
        this.httpSession = httpSession;
        this.participationService = participationService;
        this.tournamentService = tournamentService;
    }

    @RequestMapping("/participation/{id_tournament}")
    public String participation(Model model, @PathVariable int id_tournament) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        User user = userService.getByEmail((String) httpSession.getAttribute("email"));
        model.addAttribute("tournament",tournamentService.getById(id_tournament));
        model.addAttribute("user", user);
        return "tournament";
    }

    @RequestMapping("/participation-registration/{id_tournament}")
    public String registration(Model model, @PathVariable int id_tournament) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        User user = userService.getByEmail((String) httpSession.getAttribute("email"));
        model.addAttribute("tournament",tournamentService.getById(id_tournament));
        model.addAttribute("user", user);
        model.addAttribute("participation", new Participation());

        if(user.getRank() != tournamentService.getById(id_tournament).getRank()) {
            return "redirect:/participation/"+id_tournament;
        }

        return "participation-registration";
    }

    @PostMapping("/participation-registration")
    public String inscriptionPost(@ModelAttribute("participation") Participation participation) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        User user = userService.getByEmail((String) httpSession.getAttribute("email"));


        participationService.save(participation);
        return "redirect:/tournament";
    }
}
