package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Adresse;
import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.Entity.AdresseDAL;
import be.ucm.jds.DAL.Entity.PhotoDAL;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoMapperDAL {

    private Photo photo;
    private PhotoDAL photoDAL;

    private AdresseMapperDAL adresseMapperDAL;
    private RencontreMapperDAL rencontreMapperDAL;

    @Autowired
    public PhotoMapperDAL(AdresseMapperDAL adresseMapperDAL , RencontreMapperDAL rencontreMapperDAL) {
        this.rencontreMapperDAL = rencontreMapperDAL;
        this.adresseMapperDAL = adresseMapperDAL;
    }

    public Photo photoDAL_To_Photo(PhotoDAL photoDAL){

        this.photoDAL = photoDAL;

        this.photo = new Photo(this.photoDAL.getId(),
                this.photoDAL.getLien(),
                adresseMapperDAL.adresseDAL_To_Adresse(this.photoDAL.getAdresse()),
                rencontreMapperDAL.rencontreDal_To_Rencontre(this.photoDAL.getRencontre()));

        return this.photo;
    }

    public PhotoDAL photo_To_PhotoDAL(Photo photo){

        this.photo = photo;

        RencontreDAL rencontreDAL = new RencontreDAL();

        this.photoDAL = new PhotoDAL(this.photo.getId(),
                this.photo.getLien(),
                adresseMapperDAL.adresse_To_AdresseDAL(this.photo.getAdresse()),
                rencontreDAL);

        return this.photoDAL;
    }
}
