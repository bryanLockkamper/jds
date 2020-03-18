package be.ucm.jds.DAL.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity(name = "Genre")
public class GenreDAL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_genre;

    private String titre_genre;
    private String description_jeu;

    @ManyToMany(mappedBy = "genreList_jeu")
    private List<JeuDAL> jeuList_genre;

    public GenreDAL(Long id, String titre, String desc) {
        this.id_genre = id;
        this.titre_genre = titre;
        this.description_jeu = desc;
        this.jeuList_genre = new ArrayList<>();
    }
}
