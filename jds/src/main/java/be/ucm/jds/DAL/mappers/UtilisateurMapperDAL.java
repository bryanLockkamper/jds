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
}
