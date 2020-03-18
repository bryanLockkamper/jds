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
    private String num;
    private int codePostale;
    private String ville;
    private List<Photo> photos;
}
