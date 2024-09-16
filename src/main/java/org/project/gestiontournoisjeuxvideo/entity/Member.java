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

@Table(name ="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_member")
    private int id;

    private String username;

    @Column(unique = true)
    private String email;
    private String password;
    private String profilPic;
    private Role role;

    @OneToMany(mappedBy = "member")
    private List<Participation> participationsRecord;
}
