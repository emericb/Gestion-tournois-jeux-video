package org.project.gestiontournoisjeuxvideo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.gestiontournoisjeuxvideo.util.Format;
import org.project.gestiontournoisjeuxvideo.util.GameName;
import org.project.gestiontournoisjeuxvideo.util.GameType;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name ="tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_team")
    private int id;
    private String name;
    private GameName gameName;
    private GameType gameType;
    private Format format;
    private String rules;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private int PlayerLimit;

}
