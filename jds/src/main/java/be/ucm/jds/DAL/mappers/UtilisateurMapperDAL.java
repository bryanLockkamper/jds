package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.*;
import be.ucm.jds.DAL.Entity.*;
import org.modelmapper.ModelMapper;

public class UtilisateurMapperDAL {
    public static Utilisateur utilisateurDAL_To_Utilisateur(UtilisateurDAL utilisateurDAL) {
        return new ModelMapper().map(utilisateurDAL, Utilisateur.class);
    }

    public static UtilisateurDAL utilisateur_To_UtilisateurDAL(Utilisateur utilisateur) {
        return new ModelMapper().map(utilisateur, UtilisateurDAL.class);
    }

    public static UtilisateurDAL utilisateurRegister_To_UtilisateurDAL(UtilisateurRegister utilisateur) {
        return new ModelMapper().map(utilisateur, UtilisateurDAL.class);
    }
    public static  UtilisateurDAL utilisateur_to_utilisateurDAL_upDate(Utilisateur utilisateur,UtilisateurDAL utilisateurDAL){
        utilisateurDAL.setEmail(utilisateur.getEmail());
        utilisateurDAL.setPseudo(utilisateur.getPseudo());
        if(utilisateur.getPhoto() != null) utilisateurDAL.setPhoto(PhotoMapperDAL.photo_To_PhotoDAL(utilisateur.getPhoto()));
        utilisateurDAL.setDateNaissance(utilisateur.getDateNaissance());
        utilisateurDAL.setGenre(utilisateur.getGenre());
        utilisateurDAL.setNom(utilisateur.getNom());
        utilisateurDAL.setPrenom(utilisateur.getPrenom());
        utilisateurDAL.setNumero(utilisateur.getNumero());
        utilisateurDAL.setDescription(utilisateur.getDescription());
        return utilisateurDAL;
    }
}
