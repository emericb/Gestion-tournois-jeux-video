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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final ParticipationService participationService;
    private final TournamentService tournamentService;
    private final MatchService matchService;
    private final LoginService loginService;

    private HttpSession httpSession;
    private String location = "src/main/resources/static/images";



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
        return "redirect:/user";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User updatedUser, Model model) {
        User existingUser = userService.getById(updatedUser.getId());

        if (!existingUser.getEmail().equals(updatedUser.getEmail())) {
            if (userService.emailExists(updatedUser.getEmail())) {
                model.addAttribute("error", "L'email est déjà utilisé.");
                return "user";
            }
        }

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setPreference(updatedUser.getPreference());

        userService.save(existingUser);
        return "redirect:/user";
    }

    @PostMapping("/upload")
    public String postForm(@RequestParam("image") MultipartFile image, @RequestParam("id") int id) throws IOException {
        if (!loginService.isLogged()) {
            return "redirect:/login";
        }

        User user = userService.getById(id);

        Path destinationFile = Paths.get(location).resolve(image.getOriginalFilename()).toAbsolutePath();
        InputStream inputStream = image.getInputStream();

        Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);

        user.setProfilPic(image.getOriginalFilename());
        userService.save(user);

        return "redirect:/user";
    }



}
