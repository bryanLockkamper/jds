package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Adresse;
import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.Entity.AdresseDAL;
import be.ucm.jds.DAL.Entity.PhotoDAL;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class AdresseMapperDAL {

    public static Adresse adresseDAL_To_Adresse(AdresseDAL adresseDAL) {
        return new ModelMapper().map(adresseDAL, Adresse.class);
    }

    public static AdresseDAL adresse_To_AdresseDAL(Adresse adresse) {
        return new ModelMapper().map(adresse, AdresseDAL.class);
    }
}
