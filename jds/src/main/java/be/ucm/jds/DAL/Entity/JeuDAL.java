package be.ucm.jds.DAL.Entity;

import be.ucm.jds.BL.Entity.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "Jeu")
public class JeuDAL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;
    private String description;

    @Column(nullable = false)
    private Integer nbrJoueurMin;
    private Integer nbrJoueurMax;

    private String maisonEdition;
    private Integer ageMin;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<GenreDAL> genres;

    @ManyToMany(mappedBy = "jeuList")
    private List<RencontreDAL> rencontreList;

    @ManyToMany(mappedBy = "jeuPreferes")
    private List<UtilisateurDAL> utilisateurList;


    public JeuDAL(Long id, String titre, String desc, int nbrJoueursMin, int nbrJoueursMax, List<GenreDAL> genreDAL, String maisonEdition, int ageMin) {
        this.id = id;
        this.titre = titre;
        this.description = desc;
        this.nbrJoueurMin = nbrJoueursMin;
        this.nbrJoueurMax = nbrJoueursMax;
        this.maisonEdition = maisonEdition;
        this.ageMin = ageMin;
        this.genres = genreDAL;
    }
}
