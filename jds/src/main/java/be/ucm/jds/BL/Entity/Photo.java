package be.ucm.jds.BL.Entity;

import lombok.*;

import javax.persistence.Lob;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
    private Long id;
    private String lien;
}
