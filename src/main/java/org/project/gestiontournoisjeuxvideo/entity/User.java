package org.project.gestiontournoisjeuxvideo.entity;


import jakarta.persistence.*;
import lombok.*;
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
    private String email;
    private String password;
    private String profilPic;
    private String preference;
    private Role role;
    protected

    @OneToMany(mappedBy = "user")
    private List<Participation> participationsRecord;
}
