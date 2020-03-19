package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Adresse;
import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.Entity.AdresseDAL;
import be.ucm.jds.DAL.Entity.PhotoDAL;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdresseMapperOfPhotoDAL {

    private Adresse adresse;
    private AdresseDAL adresseDAL;

    public Adresse adresseDAL_To_Adresse(AdresseDAL adresseDAL) {

        this.adresseDAL = adresseDAL;

        this.adresse = new Adresse(this.adresseDAL.getId(),
                this.adresseDAL.getRue(),
                this.adresseDAL.getNumero(),
                this.adresseDAL.getCodePostal(),
                this.adresseDAL.getVille(),
                null);

        return this.adresse;
    }

    public AdresseDAL adresse_To_AdresseDAL(Adresse adresse) {

        this.adresse = adresse;

        List<UtilisateurDAL> utilisateurDALListList = new ArrayList<>();
        RencontreDAL rencontreDAL = new RencontreDAL();

        this.adresseDAL = new AdresseDAL(this.adresse.getId(),
                this.adresse.getRue(),
                this.adresse.getNum(),
                this.adresse.getCodePostale(),
                this.adresse.getVille(),
                utilisateurDALListList,
                null,
                rencontreDAL);

        return this.adresseDAL;
    }
}
