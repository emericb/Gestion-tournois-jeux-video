package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.User;
import org.project.gestiontournoisjeuxvideo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<User> getAll(){
        return memberRepository.findAll();
    }

    public User getById(int id){
        return memberRepository.findById(id).orElse(null);
    }

    public User save(User user){
        return memberRepository.save(user);
    }

    public void delete(User user){
        memberRepository.delete(user);
    }

    public User getByEmail(String email){
        return memberRepository.findByEmail(email);
    }
}

