package org.project.gestiontournoisjeuxvideo.controller;

import jakarta.servlet.http.HttpSession;
import org.project.gestiontournoisjeuxvideo.service.LoginService;
import org.project.gestiontournoisjeuxvideo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;
    private final MemberService memberService;
    private final HttpSession httpSession;

    @Autowired
    public LoginController(HttpSession httpSession, LoginService loginService, MemberService memberService) {
        this.loginService = loginService;
        this.memberService = memberService;
        this.httpSession = httpSession;
    }

    @RequestMapping("/login")
    public String login(Model model) {
        if (loginService.isLogged()) {
            model.addAttribute("user", memberService.getByEmail((String) httpSession.getAttribute("email")));
            return "member";
        }
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        if (loginService.login(email, password)) {
            model.addAttribute("user", memberService.getByEmail((String) httpSession.getAttribute("email")));
            return "member";
        }
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        loginService.logout();
        return "redirect:/login";
    }
}


