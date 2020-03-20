package be.ucm.jds.BL.Entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Jeu {

    private Long id;
    private String titre;
    private String description;
    private int nbrJoueurMin;
    private int nbrJoueurMax;
    private List<Genre> genres;
    private String maisonEdition;
    private int ageMin;
}
