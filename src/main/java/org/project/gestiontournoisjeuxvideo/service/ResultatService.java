package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.Result;
import org.project.gestiontournoisjeuxvideo.repository.ResultatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultatService {
    private ResultatRepository resultatRepository;

    public ResultatService(ResultatRepository resultatRepository) {
        this.resultatRepository = resultatRepository;
    }

    public List<Result> getAll() {
        return resultatRepository.findAll();
    }

    public Result getById(int id) {
        return resultatRepository.findById(id).orElse(null);
    }

    public Result save(Result result) {
        return resultatRepository.save(result);
    }

    public void delete(Result result) {
        resultatRepository.delete(result);
    }
}