package org.project.gestiontournoisjeuxvideo.repository;

import org.project.gestiontournoisjeuxvideo.entity.Match;
import org.project.gestiontournoisjeuxvideo.entity.Participation;
import org.project.gestiontournoisjeuxvideo.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    List<Match> findByTournament(Tournament tournament);
}
