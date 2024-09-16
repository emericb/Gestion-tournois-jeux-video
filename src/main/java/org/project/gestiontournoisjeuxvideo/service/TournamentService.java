package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.Tournament;
import org.project.gestiontournoisjeuxvideo.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    private TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public List<Tournament> getAll(){
        return tournamentRepository.findAll();
    }

    public Tournament getById(int id){
        return tournamentRepository.findById(id).orElse(null);
    }

    public Tournament save(Tournament tournament){
        return tournamentRepository.save(tournament);
    }

    public void delete(Tournament tournament){
        tournamentRepository.delete(tournament);
    }
}
