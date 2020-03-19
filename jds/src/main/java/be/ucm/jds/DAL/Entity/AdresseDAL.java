package be.ucm.jds.DAL.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity(name = "Adresse")
public class AdresseDAL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rue;
    private String numero;
    private Integer codePostal;
    private String ville;

    @ManyToMany
    private List<UtilisateurDAL> utilisateurList;

    @ManyToMany(mappedBy = "adresseList")
    private List<PhotoDAL> photoList;

    @OneToOne
    private RencontreDAL rencontre;
}
