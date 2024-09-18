package org.project.gestiontournoisjeuxvideo.repository;


import org.project.gestiontournoisjeuxvideo.entity.Participation;
import org.project.gestiontournoisjeuxvideo.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Integer> {
    List<Participation> findByTournament(Tournament tournament);
}

