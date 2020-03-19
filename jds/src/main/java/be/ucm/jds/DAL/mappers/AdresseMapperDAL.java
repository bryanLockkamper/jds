package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Adresse;
import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.Entity.AdresseDAL;
import be.ucm.jds.DAL.Entity.PhotoDAL;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AdresseMapperDAL {

    private Adresse adresse;
    private AdresseDAL adresseDAL;

    @Autowired
    private PhotoMapperDAL photoMapperDAL;

    public Adresse adresseDAL_To_Adresse(AdresseDAL adresseDAL) {

        this.adresseDAL = adresseDAL;

        List<Photo> photoList = new ArrayList<>();

        for (PhotoDAL p : this.adresseDAL.getPhotoList()) {
            photoList.add(photoMapperDAL.photoDAL_To_Photo(p));
        }

        this.adresse = new Adresse(this.adresseDAL.getId(),
                this.adresseDAL.getRue(),
                this.adresseDAL.getNumero(),
                this.adresseDAL.getCodePostal(),
                this.adresseDAL.getVille(),
                photoList);

        return this.adresse;
    }

    public AdresseDAL adresse_To_AdresseDAL(Adresse adresse) {

        this.adresse = adresse;

        List<PhotoDAL> photoDALList = new ArrayList<>();
        List<UtilisateurDAL> utilisateurDALListList = new ArrayList<>();
        RencontreDAL rencontreDAL = new RencontreDAL();

        for (Photo p : this.adresse.getPhotos()) {
            photoDALList.add(photoMapperDAL.photo_To_PhotoDAL(p));
        }

        this.adresseDAL = new AdresseDAL(this.adresse.getId(),
                this.adresse.getRue(),
                this.adresse.getNum(),
                this.adresse.getCodePostale(),
                this.adresse.getVille(),
                utilisateurDALListList,
                photoDALList,
                rencontreDAL);

        return this.adresseDAL;
    }
}
