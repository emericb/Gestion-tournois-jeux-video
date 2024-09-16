package org.project.gestiontournoisjeuxvideo.repository;

import org.project.gestiontournoisjeuxvideo.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
}
