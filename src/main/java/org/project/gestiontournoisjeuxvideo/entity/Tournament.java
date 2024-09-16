package org.project.gestiontournoisjeuxvideo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.gestiontournoisjeuxvideo.util.Format;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_tournament")
    private int id;
    private String name;
    private Game game;
    private Format format;
    private String rules;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private int PlayerLimit;
    private String eligibilityCriteria;

    @OneToMany(mappedBy = "tournament")
    private List<Match> brackets;
}
