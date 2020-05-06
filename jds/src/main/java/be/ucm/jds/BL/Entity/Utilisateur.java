package be.ucm.jds.BL.Entity;

import lombok.*;
import sun.java2d.windows.GDIRenderer;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    private Long id;
    private String pseudo;
    private String email;
    private LocalDate dateNaissance;
    private String genre;
    private List<Jeu> jeuPreferes;
    private String nom;
    private String prenom;
    private String description;
    private String numero;
    private List<Adresse> adresseList;
    private Photo photo;
    private List<Role> roles;
    private List<Groupe> groupes;
}
