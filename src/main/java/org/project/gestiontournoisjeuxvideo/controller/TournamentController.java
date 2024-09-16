package org.project.gestiontournoisjeuxvideo.controller;

import jakarta.servlet.http.HttpSession;
import org.project.gestiontournoisjeuxvideo.entity.Member;
import org.project.gestiontournoisjeuxvideo.entity.Tournament;
import org.project.gestiontournoisjeuxvideo.service.*;
import org.project.gestiontournoisjeuxvideo.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TournamentController {

    private final MemberService memberService;
    private final ParticipationService participationService;
    private final TournamentService tournamentService;
    private final MatchService matchService;
    private final LoginService loginService;

    private HttpSession httpSession;

    @Autowired
    public TournamentController(HttpSession httpSession, LoginService loginService, MemberService memberService, ParticipationService participationService, TournamentService tournamentService, MatchService matchService) {
        this.memberService = memberService;
        this.participationService = participationService;
        this.tournamentService = tournamentService;
        this.matchService = matchService;
        this.loginService = loginService;
        this.httpSession = httpSession;
    }

    @RequestMapping("/tournament")
    public String member(Model model) {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        model.addAttribute("tournaments", tournamentService.getAll());
        model.addAttribute("member", memberService.getByEmail((String) httpSession.getAttribute("email")));
        model.addAttribute("tournament", new Tournament());
        return "tournament";
    }

    @RequestMapping("/tournament-registration")
    public String registration(Model model) {
        model.addAttribute("tournament", new Tournament());
        return "tournament-registration";
    }

    @PostMapping("/tournament-registration")
    public String inscriptionPost(@ModelAttribute("tournament") Tournament tournament) {

        return "redirect:/tournament";
    }
}

}
