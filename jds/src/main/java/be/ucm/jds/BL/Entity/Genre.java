package be.ucm.jds.BL.Entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    private Long id;

    private String titre;

    private String desc;

}
