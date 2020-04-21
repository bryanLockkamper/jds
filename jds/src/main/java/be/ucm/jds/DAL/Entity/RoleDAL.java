package be.ucm.jds.DAL.Entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity(name = "Role")
public class RoleDAL implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany
    private List<UtilisateurDAL> utilisateurDALList;

    @Override
    public String getAuthority() {
        return nom;
    }
}
