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
public class UserController {
    private final UserService userService;
    private final ParticipationService participationService;
    private final TournamentService tournamentService;
    private final MatchService matchService;
    private final LoginService loginService;

    private HttpSession httpSession;



    @Autowired
    public UserController(HttpSession httpSession, LoginService loginService, UserService userService, ParticipationService participationService, TournamentService tournamentService, MatchService matchService) {
        this.userService = userService;
        this.participationService = participationService;
        this.tournamentService = tournamentService;
        this.matchService = matchService;
        this.loginService = loginService;
        this.httpSession = httpSession;
    }

    @RequestMapping("/user")
    public String user(Model model) {
        if (loginService.isLogged()) {
            String email = (String) httpSession.getAttribute("email");
            model.addAttribute("user", userService.getByEmail(email));
            return "user";
        }
        return "login";
    }

    @RequestMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String inscriptionPost(@ModelAttribute("user") User user) {
        user.setRole(Role.USER);
        userService.save(user);
        return "redirect:/registration";
    }
}
