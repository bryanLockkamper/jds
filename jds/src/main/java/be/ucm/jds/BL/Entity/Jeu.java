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
    private String desc;
    private int nbrJoueursMin;
    private int nbrJoueursMax;
    private List<Genre> genre;
    private String maisonEdition;
    private int ageMin;
}
