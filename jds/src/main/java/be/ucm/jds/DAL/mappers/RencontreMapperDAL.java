package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.*;
import be.ucm.jds.DAL.Entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class RencontreMapperDAL {
    public static Rencontre rencontreDal_To_Rencontre(RencontreDAL rencontreDAL) {
        return new ModelMapper().map(rencontreDAL, Rencontre.class);
    }

    public static RencontreDAL rencontre_To_RencontreDAL(Rencontre rencontre) {
        return new ModelMapper().map(rencontre, RencontreDAL.class);
    }
}
