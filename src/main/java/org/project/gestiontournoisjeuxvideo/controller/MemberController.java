package org.project.gestiontournoisjeuxvideo.controller;


import jakarta.servlet.http.HttpSession;
import org.project.gestiontournoisjeuxvideo.entity.User;
import org.project.gestiontournoisjeuxvideo.service.*;
import org.project.gestiontournoisjeuxvideo.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    private final MemberService memberService;
    private final ParticipationService participationService;
    private final TournamentService tournamentService;
    private final MatchService matchService;
    private final LoginService loginService;

    private HttpSession httpSession;



    @Autowired
    public MemberController(HttpSession httpSession, LoginService loginService, MemberService memberService, ParticipationService participationService, TournamentService tournamentService, MatchService matchService) {
        this.memberService = memberService;
        this.participationService = participationService;
        this.tournamentService = tournamentService;
        this.matchService = matchService;
        this.loginService = loginService;
        this.httpSession = httpSession;
    }

    @RequestMapping("/member")
    public String member(Model model) {
        if (loginService.isLogged()) {
            String email = (String) httpSession.getAttribute("email");
            model.addAttribute("member", memberService.getByEmail(email));
            return "member";
        }
        return "login";
    }

    @RequestMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("member", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String inscriptionPost(@ModelAttribute("member") User user) {
        user.setRole(Role.USER);
        memberService.save(user);
        return "redirect:/member";
    }
}
