package org.project.gestiontournoisjeuxvideo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.gestiontournoisjeuxvideo.util.Status;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "participation")
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participation")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_member")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "id_tournament")
    private Tournament tournament;

    private Date registrationDate;
    private Status status;
}
