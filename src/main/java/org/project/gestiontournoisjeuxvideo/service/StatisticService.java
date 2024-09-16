package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.Resultat;
import org.project.gestiontournoisjeuxvideo.entity.Statistic;
import org.project.gestiontournoisjeuxvideo.repository.StatisticRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    private StatisticRepository statisticRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public List<Statistic> getAll() {
        return statisticRepository.findAll();
    }

    public Statistic getById(int id) {
        return statisticRepository.findById(id).orElse(null);
    }

    public Statistic save(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    public void delete(Statistic statistic) {
        statisticRepository.delete(statistic);
    }
}
