package org.project.gestiontournoisjeuxvideo.entity;

import jakarta.persistence.*;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name ="notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_notification")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_member")
    private User user;

    private String type;
    private String message;
    private Date sendDate;
    private boolean isRead;
}