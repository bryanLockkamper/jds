package be.ucm.jds.DAL.Entity;

import be.ucm.jds.BL.Entity.Rencontre;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity(name = "Photo")
public class PhotoDAL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_photo;

    private String lien_photo;

    @ManyToMany
    private List<AdresseDAL> adresseList_photo;

    @OneToOne
    private RencontreDAL rencontre_photo;
}
