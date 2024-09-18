package org.project.gestiontournoisjeuxvideo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ContactController {

    private final HttpSession httpSession;

    public ContactController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @RequestMapping("/contact")

    public String contact(Model model) {
        model.addAttribute("userlog", httpSession.getAttribute("user"));
        return "contact";
    }

}

