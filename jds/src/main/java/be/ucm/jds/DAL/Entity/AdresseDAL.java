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

    @ManyToMany(mappedBy = "adresseList")
    private List<UtilisateurDAL> utilisateurList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PhotoDAL> photos;

    @OneToOne
    private RencontreDAL rencontre;
}
