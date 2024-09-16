package org.project.gestiontournoisjeuxvideo.entity;


import jakarta.persistence.*;
import lombok.*;
import org.project.gestiontournoisjeuxvideo.util.GameType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_user")
    private int id;

    private String firstname;
    private String lastname;
    private String pseudo;
    private int age;
    private String email;
    private String password;
    private String phone;
    private GameType gameType;
    private boolean isAdmin;
    private String profilPic;
}
