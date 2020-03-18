package be.ucm.jds.DAL.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Jeu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_jeu;

    @Column(nullable = false)
    private String titre_jeu;
    private String descr_jeu;

    @Column(nullable = false)
    private Integer nbrJoueurMin_jeu;
    private Integer nbrJoueurMax_jeu;

    private String maisonEdition_jeu;
    private Integer ageMin_jeu;

    @ManyToMany
    private List<Genre> genreList_jeu;

    @ManyToMany(mappedBy = "jeuList_rencontre")
    private List<Rencontre> rencontreList_jeu;

    @ManyToMany
    private List<Utilisateur> utilisateurList_jeu;


}
