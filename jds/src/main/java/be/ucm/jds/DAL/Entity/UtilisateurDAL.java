package be.ucm.jds.DAL.Entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Setter
@Getter
@Entity(name = "Utilisateur")
public class UtilisateurDAL implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String pseudo;
    @Column(nullable = false)
    private LocalDate dateNaissance;
    private String genre;
    private String nom;
    private String prenom;
    private String description;
    private String numero;

    @OneToOne(cascade = CascadeType.ALL)
    private PhotoDAL photo;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private List<JeuDAL> jeuPreferes;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<AdresseDAL> adresseList;

    @ManyToMany(mappedBy = "utilisateurAffList")
    private List<RencontreDAL> rencontreAffList;

    @ManyToMany(mappedBy = "utilisateurDALList", fetch = FetchType.EAGER)
    private List<RoleDAL> roles;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private List<GroupeDAL> groupes;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
