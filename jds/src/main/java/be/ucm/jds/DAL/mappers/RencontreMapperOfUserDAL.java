package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.*;
import be.ucm.jds.DAL.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RencontreMapperOfUserDAL {

    private Rencontre rencontre;
    private RencontreDAL rencontreDAL;

    private JeuMapperDAL jeuMapperDAL;

    @Autowired
    public RencontreMapperOfUserDAL(JeuMapperDAL jeuMapperDAL) {
        this.jeuMapperDAL = jeuMapperDAL;
    }

    public Rencontre rencontreDal_To_Rencontre(RencontreDAL rencontreDAL) {

        this.rencontreDAL = rencontreDAL;

        Adresse adresse = new Adresse();
        Photo photo = new Photo();
        Utilisateur utilisateur = new Utilisateur();

        List<Utilisateur> utilisateurList = new ArrayList<>();

        this.rencontre = new Rencontre(this.rencontreDAL.getId(),
                        this.rencontreDAL.getTitre(),
                        this.rencontreDAL.getDate(),
                        this.rencontreDAL.getTempDeJeu(),
                        this.rencontreDAL.getNbrParticipantLimite(),
                        adresse,
                this.rencontreDAL.getDescr(),
                utilisateur,
                utilisateurList,
                photo,
                null);

        return rencontre;
    }

    public RencontreDAL rencontre_To_RencontreDAL(Rencontre rencontre) {

        this.rencontre = rencontre;

        AdresseDAL adresse = new AdresseDAL();
        PhotoDAL photo = new PhotoDAL();
        UtilisateurDAL utilisateur = new UtilisateurDAL();

        List<UtilisateurDAL> utilisateurList = new ArrayList<>();

        this.rencontreDAL = new RencontreDAL(this.rencontre.getId(),
                this.rencontre.getTitre(),
                this.rencontre.getDate(),
                this.rencontre.getTempDeJeu(),
                this.rencontre.getNbrParticipantsLimite(),
                this.rencontre.getDesc(),
                photo,
                adresse,
                utilisateur,
                utilisateurList,
                null);

        return this.rencontreDAL;
    }
}
