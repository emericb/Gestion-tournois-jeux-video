//package org.project.gestiontournoisjeuxvideo.controller;
//
//import org.project.gestiontournoisjeuxvideo.entity.Statistic;
//import org.project.gestiontournoisjeuxvideo.service.StatisticService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//public class StatisticController {
//
//    @PostMapping
//    public ResponseEntity<Statistic> createStatistic(@RequestBody Statistic statistic) {
//        Statistic createdStatistic = statisticService.save(statistic);
//        return ResponseEntity.ok(createdStatistic);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Statistic> getStatistic(@PathVariable Long id) {
//        Optional<Statistic> statistic = statisticService.getById(id);
//        return statistic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping
//    public ResponseEntity<Iterable<Statistic>> getAllStatistics() {
//        Iterable<Statistic> statistics = statisticService.getAll();
//        return ResponseEntity.ok(statistics);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteStatistic(@PathVariable Long id) {
//        statisticService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//}