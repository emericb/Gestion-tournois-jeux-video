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

@Table(name ="match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_match")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_tournament")
    private Tournament tournament;

    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;

    @ManyToOne
    @JoinColumn(name = "id_player1")
    private Member player1;

    @ManyToOne
    @JoinColumn(name = "id_player2")
    private Member player2;

    private int scorePlayer1;
    private int scorePlayer2;
    private Status status;
    private boolean isResultConfirmed;
}
