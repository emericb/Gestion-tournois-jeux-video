package org.project.gestiontournoisjeuxvideo.controller;

import jakarta.servlet.http.HttpSession;
import org.project.gestiontournoisjeuxvideo.service.LoginService;
import org.project.gestiontournoisjeuxvideo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;
    private final UserService userService;
    private final HttpSession httpSession;

    @Autowired
    public LoginController(HttpSession httpSession, LoginService loginService, UserService userService) {
        this.loginService = loginService;
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @RequestMapping("/login")
    public String login(Model model) {
        if (loginService.isLogged()) {
            model.addAttribute("user", userService.getByEmail((String) httpSession.getAttribute("email")));
            return "user";
        }
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        if (loginService.login(email, password)) {
            model.addAttribute("user", userService.getByEmail((String) httpSession.getAttribute("email")));
            return "user";
        }
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        loginService.logout();
        return "redirect:/login";
    }

    @RequestMapping("/password_Recovery")
    public String PasswordRecovery() {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }
        return "password_Recovery";
    }

    @PostMapping("/password_Recovery")
    public String login(@RequestParam("email") String email, Model model) {
            model.addAttribute("user", userService.getByEmail((String) httpSession.getAttribute("email")));
            return "user";
    }
}


