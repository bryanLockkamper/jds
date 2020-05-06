package be.ucm.jds.DAL.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity(name = "Groupe")
public class GroupeDAL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "groupes")
    private List<UtilisateurDAL> utilisateurDALList;

    @OneToMany(mappedBy = "groupeCrea")
    private List<RencontreDAL> rencontreCreaList;
}
