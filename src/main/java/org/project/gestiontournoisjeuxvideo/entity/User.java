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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_user")
    private int id;

    private String username;
    private String email;
    private String password;
    private String profilPic;
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Participation> participationsRecord;
}
