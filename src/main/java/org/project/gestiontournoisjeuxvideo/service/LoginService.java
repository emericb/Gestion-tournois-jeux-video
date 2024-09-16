package org.project.gestiontournoisjeuxvideo.service;

import jakarta.servlet.http.HttpSession;
import org.project.gestiontournoisjeuxvideo.entity.Member;
import org.project.gestiontournoisjeuxvideo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private HttpSession httpSession;
    private final MemberRepository memberRepository;

    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean login(String email, String password) {
        Member member = memberRepository.findByEmail(email);
        if (member != null) {
            if (member.getPassword().equals(password)) {
                httpSession.setAttribute("login", "OK");
                httpSession.setAttribute("email", member.getEmail());
                httpSession.setAttribute("role", member.getRole());
                return true;
            }
        }
        return false;
    }


    public void logout() {
        httpSession.removeAttribute("login");
        httpSession.removeAttribute("email");
        httpSession.removeAttribute("role");
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
