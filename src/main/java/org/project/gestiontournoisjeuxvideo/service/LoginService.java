package org.project.gestiontournoisjeuxvideo.service;

import jakarta.servlet.http.HttpSession;
import org.project.gestiontournoisjeuxvideo.entity.User;
import org.project.gestiontournoisjeuxvideo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private HttpSession httpSession;
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                httpSession.setAttribute("login", "OK");
                httpSession.setAttribute("email", user.getEmail());
                httpSession.setAttribute("role", user.getRole());
                httpSession.setAttribute("user", user);
                return true;
            }
        }
        return false;
    }


    public void logout() {
        httpSession.removeAttribute("login");
        httpSession.removeAttribute("email");
        httpSession.removeAttribute("role");
        httpSession.removeAttribute("user");
    }

    public boolean isLogged() {
        try {
            String verif = (String) httpSession.getAttribute("login");
            return verif.equals("OK");
        } catch (Exception e) {
            return false;
        }
    }
}
