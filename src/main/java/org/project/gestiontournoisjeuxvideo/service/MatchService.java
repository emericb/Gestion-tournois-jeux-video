package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.Match;
import org.project.gestiontournoisjeuxvideo.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAll(){
        return matchRepository.findAll();
    }

    public Match getById(int id){
        return matchRepository.findById(id).orElse(null);
    }

    public Match save(Match match){
        return matchRepository.save(match);
    }

    public void delete(Match match){
        matchRepository.delete(match);
    }
}
