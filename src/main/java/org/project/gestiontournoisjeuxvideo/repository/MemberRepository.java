package org.project.gestiontournoisjeuxvideo.repository;

import org.project.gestiontournoisjeuxvideo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByEmail(String email);
}
