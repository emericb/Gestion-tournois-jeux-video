package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.Notification;
import org.project.gestiontournoisjeuxvideo.entity.Resultat;
import org.project.gestiontournoisjeuxvideo.repository.NotificationRepository;
import org.project.gestiontournoisjeuxvideo.repository.ResultatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatService {
    private ResultatRepository resultatRepository;

    public ResultatService(ResultatRepository resultatRepository) {
        this.resultatRepository = resultatRepository;
    }

    public List<Resultat> getAll() {
        return resultatRepository.findAll();
    }

    public Resultat getById(int id) {
        return resultatRepository.findById(id).orElse(null);
    }

    public Resultat save(Resultat resultat) {
        return resultatRepository.save(resultat);
    }

    public void delete(Resultat resultat) {
        resultatRepository.delete(resultat);
    }
}