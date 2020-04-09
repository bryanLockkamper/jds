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
    private Long id;

    @Lob
    @Column(length = 100000)
    private String lien;

    @ManyToOne
    private AdresseDAL adresse;

    @OneToOne
    private RencontreDAL rencontre;
}
