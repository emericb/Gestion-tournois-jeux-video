package org.project.gestiontournoisjeuxvideo.repository;

import org.project.gestiontournoisjeuxvideo.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
