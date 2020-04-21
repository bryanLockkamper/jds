package be.ucm.jds.BL.Entity;

import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import lombok.Data;

@Data
public class UtilisateurDTOInfo {

    private String pseudo;
    private String firstname;
    private String lastname;
    private Long id;
    private String mail;

    public UtilisateurDTOInfo() {
    }

    public UtilisateurDTOInfo(UtilisateurDAL utilisateurDAL) {
        this.pseudo = utilisateurDAL.getPseudo();
        this.firstname = utilisateurDAL.getPrenom();
        this.lastname = utilisateurDAL.getNom();
        this.mail = utilisateurDAL.getEmail();
        this.id = utilisateurDAL.getId();
    }
}
