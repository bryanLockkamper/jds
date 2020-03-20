package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Jeu;
import be.ucm.jds.DAL.Entity.JeuDAL;
import org.modelmapper.ModelMapper;

public class JeuMapperDAL {

    public static Jeu jeuDAL_To_Jeu (JeuDAL jeuDAL){
        return new ModelMapper().map(jeuDAL, Jeu.class);
    }

    public static JeuDAL jeu_To_JeuDAL (Jeu jeu) {
        return new ModelMapper().map(jeu, JeuDAL.class);
    }
}
