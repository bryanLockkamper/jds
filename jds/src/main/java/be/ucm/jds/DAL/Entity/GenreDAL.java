package be.ucm.jds.DAL.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

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
}
