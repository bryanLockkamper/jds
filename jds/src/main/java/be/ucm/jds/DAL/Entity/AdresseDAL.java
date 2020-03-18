package be.ucm.jds.DAL.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity(name = "Adresse")
public class AdresseDAL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_adresse;

    private String rue_adresse;
    private String numero_adresse;
    private Integer codePostal_adresse;
    private String ville_adresse;

    @ManyToMany
    private List<UtilisateurDAL> utilisateurList_adresse;

    @ManyToMany(mappedBy = "adresseList_photo")
    private List<PhotoDAL> photoList_adresse;

    @OneToOne
    private RencontreDAL rencontre_adresse;
}
