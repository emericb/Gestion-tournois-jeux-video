package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.Game;
import org.project.gestiontournoisjeuxvideo.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAll(){
        return gameRepository.findAll();
    }

    public Game getById(int id){
        return gameRepository.findById(id).orElse(null);
    }

    public Game save(Game game){
        return gameRepository.save(game);
    }

    public void delete(Game game){
        gameRepository.delete(game);
    }

}
