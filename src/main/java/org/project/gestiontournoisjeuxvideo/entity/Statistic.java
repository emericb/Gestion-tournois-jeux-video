package org.project.gestiontournoisjeuxvideo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name ="statistic")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_statistic")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_member")
    private Member member;

    private int wins;
    private int losses;
    private double ratio;

    @OneToMany(mappedBy = "statistic")
    private List<Tournament> tournamentHistory;
}