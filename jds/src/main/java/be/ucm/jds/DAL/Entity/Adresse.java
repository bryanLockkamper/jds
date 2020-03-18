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
@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_adresse;

    private String rue_adresse;
    private String numero_adresse;
    private Integer codePostal_adresse;
    private String ville_adresse;

    @ManyToMany
    private List<Utilisateur> utilisateurList_adresse;

    @ManyToMany(mappedBy = "adresseList_photo")
    private List<Photo> photoList_adresse;

    @OneToOne
    private Rencontre rencontre_adresse;
}
