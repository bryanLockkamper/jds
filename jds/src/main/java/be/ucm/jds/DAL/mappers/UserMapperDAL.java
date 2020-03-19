package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.*;
import be.ucm.jds.DAL.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserMapperDAL {

    private Utilisateur utilisateur;
    private UtilisateurDAL utilisateurDAL;

    @Autowired
    private JeuMapperDAL jeuMapperDAL;
    @Autowired
    private AdresseMapperDAL adresseMapperDAL;
    @Autowired
    private PhotoMapperDAL photoMapperDAL;
    @Autowired
    private RencontreMapperDAL rencontreMapperDAL;

    public Utilisateur utilisateurDal_To_Utilisateur(UtilisateurDAL utilisateurDAL) {

        this.utilisateurDAL = utilisateurDAL;

        List<Jeu> jeuList = new ArrayList<>();
        List<Adresse> adresseList = new ArrayList<>();
        Photo photo = new Photo();
        List<Rencontre> rencontreList = new ArrayList<>();

        for (JeuDAL j : this.utilisateurDAL.getJeuList()) {
            jeuList.add(jeuMapperDAL.jeuDAL_To_Jeu(j));
        }

        for (AdresseDAL a : this.utilisateurDAL.getAdresseList()) {
            adresseList.add(adresseMapperDAL.adresseDAL_To_Adresse(a));
        }

        for (RencontreDAL r : this.utilisateurDAL.getRencontreList()) {
            rencontreList.add(rencontreMapperDAL.rencontreDal_To_Rencontre(r));
        }

        utilisateur = new Utilisateur(this.utilisateurDAL.getId(),
                this.utilisateurDAL.getPseudo(),
                this.utilisateurDAL.getDateNaiss(),
                this.utilisateurDAL.getGenre(),
                jeuList,
                this.utilisateurDAL.getNom(),
                this.utilisateurDAL.getPrenom(),
                this.utilisateurDAL.getDescr(),
                this.utilisateurDAL.getNumTel(),
                adresseList,
                photo,
                rencontreList);

        return utilisateur;
    }

    public UtilisateurDAL Utilisateur_To_UtilisateurDAL(Utilisateur utilisateur) {

        this.utilisateur =utilisateur;

        List<JeuDAL> jeuList = new ArrayList<>();
        List<AdresseDAL> adresseList = new ArrayList<>();
        PhotoDAL photo = new PhotoDAL();
        List<RencontreDAL> rencontreList = new ArrayList<>();

        for (Jeu j : this.utilisateur.getJeuPreferes()) {
            jeuList.add(jeuMapperDAL.jeu_To_JeuDAL(j));
        }

        for (Adresse a : this.utilisateur.getAdresseList()) {
            adresseList.add(adresseMapperDAL.adresse_To_AdresseDAL(a));
        }

        for (Rencontre r : this.utilisateur.getRencontreList()) {
            rencontreList.add(rencontreMapperDAL.rencontre_To_RencontreDAL(r));
        }

        utilisateurDAL = new UtilisateurDAL(this.utilisateur.getId(),
                this.utilisateur.getPseudo(),
                this.utilisateur.getDate(),
                this.utilisateur.getGenre(),
                jeuList,
                this.utilisateur.getNom(),
                this.utilisateur.getPrenom(),
                this.utilisateur.getDesc(),
                this.utilisateur.getTelephone(),
                adresseList,
                photo,
                rencontreList);

        return utilisateurDAL;
    }
}
