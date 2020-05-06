package be.ucm.jds.BL.Entity;

import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import be.ucm.jds.DAL.mappers.GroupeMapperDAL;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UtilisateurDTOInfo {

    private String pseudo;
    private String firstname;
    private String lastname;
    private Long id;
    private String mail;
    private List<Groupe> groupes;

    public UtilisateurDTOInfo() {
    }

    public UtilisateurDTOInfo(UtilisateurDAL utilisateurDAL) {
        this.pseudo = utilisateurDAL.getPseudo();
        this.firstname = utilisateurDAL.getPrenom();
        this.lastname = utilisateurDAL.getNom();
        this.mail = utilisateurDAL.getEmail();
        this.id = utilisateurDAL.getId();
        this.groupes = utilisateurDAL.getGroupes().stream().map(GroupeMapperDAL::groupeDAL_To_Groupe).collect(Collectors.toList());
    }
}
