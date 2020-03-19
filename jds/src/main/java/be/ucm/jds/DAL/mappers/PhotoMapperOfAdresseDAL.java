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
public class PhotoMapperOfAdresseDAL {

    private Photo photo;
    private PhotoDAL photoDAL;

    public Photo photoDAL_To_Photo(PhotoDAL photoDAL){

        this.photoDAL = photoDAL;

        this.photo = new Photo(this.photoDAL.getId(),
                this.photoDAL.getLien(),
                null
                );

        return this.photo;
    }

    public PhotoDAL photo_To_PhotoDAL(Photo photo){

        this.photo = photo;

        RencontreDAL rencontreDAL = new RencontreDAL();

        this.photoDAL = new PhotoDAL(this.photo.getId(),
                this.photo.getLien(),
                null,
                rencontreDAL);

        return this.photoDAL;
    }
}
