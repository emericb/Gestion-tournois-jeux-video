package org.project.gestiontournoisjeuxvideo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.gestiontournoisjeuxvideo.util.Status;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_match")
    private int id;
    private String name;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private Status status;
}
