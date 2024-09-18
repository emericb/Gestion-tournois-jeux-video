package org.project.gestiontournoisjeuxvideo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.project.gestiontournoisjeuxvideo.util.Rank;
import org.project.gestiontournoisjeuxvideo.util.Role;
import org.project.gestiontournoisjeuxvideo.validation.MyValid;

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

    @Column(unique = true)
    @NotNull(message = "Ce champ doit être rempli !")
    private String username;

    @Column(unique = true)
    @NotNull(message = "Ce champ doit être rempli !")
    private String email;

    //@NotBlank(message = "La valeur ne doit pas être vide !")
    @NotNull(message = "Ce champ doit être rempli !")
    @MyValid(minLength = 8)
    @Size(max = 25, message = "Maximum 25 caractères svp !")
    private String password;

    private String profilPic;
    private String preference;
    private Role role;
    private Rank rank;


    @OneToMany(mappedBy = "user")
    private List<Participation> participationRecord;
}

