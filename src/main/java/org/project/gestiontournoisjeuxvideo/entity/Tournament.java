package org.project.gestiontournoisjeuxvideo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.project.gestiontournoisjeuxvideo.util.Format;
import org.project.gestiontournoisjeuxvideo.util.Rank;
import org.project.gestiontournoisjeuxvideo.validation.MyValid;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_tournament")
    private int id;
    @NotBlank(message = "La valeur ne doit pas être vide !")
    @NotNull(message = "Ce champ doit être rempli !")
    @MyValid(minLength = 3)
    private String name;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;


    private Format format;
    @NotNull(message = "Ce champ doit être rempli !")
    @MyValid(minLength = 3)
    private String rules;
    @NotNull(message = "Ce champ doit être rempli !")
    private LocalDateTime dateStart;
    @NotNull(message = "Ce champ doit être rempli !")
    private LocalDateTime dateEnd;
    @NotNull(message = "Ce champ doit être rempli !")
    @Min(value = 1, message = "Le nombre de participants doit être au moins 1")
    private int PlayerLimit;
    @NotBlank(message = "La valeur ne doit pas être vide !")
    @NotNull(message = "Ce champ doit être rempli !")
    @MyValid(minLength = 3)
    private String eligibilityCriteria;

    private Rank rank;

    @OneToMany(mappedBy = "tournament")
    private List<Match> brackets;

    @ManyToOne
    @JoinColumn(name = "id_statistic")
    private Statistic statistic;
}
