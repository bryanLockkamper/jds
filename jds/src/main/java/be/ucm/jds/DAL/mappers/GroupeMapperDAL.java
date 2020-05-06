package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Genre;
import be.ucm.jds.BL.Entity.Groupe;
import be.ucm.jds.DAL.Entity.GenreDAL;
import be.ucm.jds.DAL.Entity.GroupeDAL;
import org.modelmapper.ModelMapper;

public class GroupeMapperDAL {

    public static Groupe groupeDAL_To_Groupe(GroupeDAL groupeDAL){
        return new ModelMapper().map(groupeDAL, Groupe.class);
    }

    public static GroupeDAL groupe_To_GroupeDAL(Groupe groupe){
        return new ModelMapper().map(groupe, GroupeDAL.class);
    }
}
