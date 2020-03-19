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
    private Long id;

    private String titre;
    private String description;

    @ManyToMany(mappedBy = "genreList")
    private List<JeuDAL> jeuList;

    public GenreDAL(Long id, String titre, String desc) {
        this.id = id;
        this.titre = titre;
        this.description = desc;
        this.jeuList = new ArrayList<>();
    }
}
