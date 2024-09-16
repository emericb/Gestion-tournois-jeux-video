package org.project.gestiontournoisjeuxvideo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_message")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_sender")
    private Member sender;

    @ManyToOne
    @JoinColumn(name = "id_recipient")
    private Member recipient;

    private String content;
    private Date sendDate;
    private boolean read;
}