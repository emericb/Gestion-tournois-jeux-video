package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.Match;
import org.project.gestiontournoisjeuxvideo.entity.Team;
import org.project.gestiontournoisjeuxvideo.repository.MatchRepository;
import org.project.gestiontournoisjeuxvideo.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAll(){
        return teamRepository.findAll();
    }

    public Team getById(int id){
        return teamRepository.findById(id).orElse(null);
    }

    public Team save(Team team){
        return teamRepository.save(team);
    }

    public void delete(Team team){
        teamRepository.delete(team);
    }
}

