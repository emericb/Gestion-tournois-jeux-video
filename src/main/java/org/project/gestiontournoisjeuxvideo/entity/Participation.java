package org.project.gestiontournoisjeuxvideo.entity;

import jakarta.persistence.*;
import org.project.gestiontournoisjeuxvideo.util.Status;

import java.util.Date;

@Entity
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    private Date registrationDate;
    private Status status;
}
