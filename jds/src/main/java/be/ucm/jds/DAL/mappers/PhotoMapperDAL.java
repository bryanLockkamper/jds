package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Adresse;
import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.Entity.AdresseDAL;
import be.ucm.jds.DAL.Entity.PhotoDAL;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PhotoMapperDAL {

    private Photo photo;
    private PhotoDAL photoDAL;

    @Autowired
    private AdresseMapperDAL adresseMapperDAL;

    public Photo photoDAL_To_Photo(PhotoDAL photoDAL){

        this.photoDAL = photoDAL;

        List<Adresse> adresseList = new ArrayList<>();

        for (AdresseDAL a : this.photoDAL.getAdresseList()) {
            adresseList.add(adresseMapperDAL.adresseDAL_To_Adresse(a));
        }

        this.photo = new Photo(this.photoDAL.getId(),
                this.photoDAL.getLien(),
                adresseList
                );

        return this.photo;
    }

    public PhotoDAL photo_To_PhotoDAL(Photo photo){

        this.photo = photo;

        RencontreDAL rencontreDAL = new RencontreDAL();

        List<AdresseDAL> adresseDALList = new ArrayList<>();

        for (Adresse a : this.photo.getAdresseList()) {
            adresseDALList.add(adresseMapperDAL.adresse_To_AdresseDAL(a));
        }

        this.photoDAL = new PhotoDAL(this.photo.getId(),
                this.photo.getLien(),
                adresseDALList,
                rencontreDAL);

        return this.photoDAL;
    }
}
