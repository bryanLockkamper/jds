package be.ucm.jds.BL.Entity;

import lombok.*;

import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Adresse {
    private Long id;
    private String rue;
    private String numero;
    private int codePostal;
    private String ville;
    private List<Photo> photos;
}
