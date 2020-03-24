package be.ucm.jds.BL.Entity;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurRegister {

    private Long id;
    private String pseudo;
    private String password;
    private String confirmpassword;
    private String email;
    private LocalDate dateNaissance;
    private String genre;
    private String nom;
    private String prenom;
    private String description;
    private String numero;
    private List<Adresse> adresse;

}
