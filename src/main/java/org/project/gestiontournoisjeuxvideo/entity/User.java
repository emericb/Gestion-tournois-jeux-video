package org.project.gestiontournoisjeuxvideo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.project.gestiontournoisjeuxvideo.util.Rank;
import org.project.gestiontournoisjeuxvideo.util.Role;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_member")
    private int id;

    private String username;

    @Column(unique = true)
    @NotBlank(message = "email est a remplir")
    private String email;
    @NotBlank(message = "password est a remplir")
    private String password;
    private String profilPic;
    private String preference;
    private Role role;
    private Rank rank;


    @OneToMany(mappedBy = "user")
    private List<Participation> participationsRecord;
}
