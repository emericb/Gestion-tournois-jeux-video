package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.Member;
import org.project.gestiontournoisjeuxvideo.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAll(){
        return memberRepository.findAll();
    }

    public Member getById(int id){
        return memberRepository.findById(id).orElse(null);
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }

    public void delete(Member member){
        memberRepository.delete(member);
    }

    public Member getByEmail(String email){
        return memberRepository.findByEmail(email);
    }
}

