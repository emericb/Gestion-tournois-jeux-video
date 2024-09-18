package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.Notification;
import org.project.gestiontournoisjeuxvideo.entity.Participation;
import org.project.gestiontournoisjeuxvideo.entity.Tournament;
import org.project.gestiontournoisjeuxvideo.repository.NotificationRepository;
import org.project.gestiontournoisjeuxvideo.repository.ParticipationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationService {
    private ParticipationRepository participationRepository;

    public ParticipationService(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }


    public List<Participation> getAll() {
        return participationRepository.findAll();
    }

    public Participation getById(int id) {
        return participationRepository.findById(id).orElse(null);
    }

    public Participation save(Participation participation) {
        return participationRepository.save(participation);
    }

    public void delete(Participation participation) {
        participationRepository.delete(participation);
    }

    public List<Participation> findByTournament(Tournament tournament) {
        return participationRepository.findByTournament(tournament);
    }
}
