package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.*;
import be.ucm.jds.DAL.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class RencontreMapperDAL {

    private Rencontre rencontre;
    private RencontreDAL rencontreDAL;

    @Autowired
    private UserMapperDAL userMapperDAL;
    @Autowired
    private JeuMapperDAL jeuMapperDAL;

    public Rencontre rencontreDal_To_Rencontre(RencontreDAL rencontreDAL) {

        this.rencontreDAL = rencontreDAL;

        Adresse adresse = new Adresse();
        Photo photo = new Photo();
        Utilisateur utilisateur = new Utilisateur();

        List<Utilisateur> utilisateurList = new ArrayList<>();
        List<Jeu> jeuList = new ArrayList<>();

        for (UtilisateurDAL u : this.rencontreDAL.getUtilisateurList()) {
            utilisateurList.add(userMapperDAL.utilisateurDal_To_Utilisateur(u));
        }

        for (JeuDAL j : this.rencontreDAL.getJeuList()) {
            jeuList.add(jeuMapperDAL.jeuDAL_To_Jeu(j));
        }

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
                jeuList);

        return rencontre;
    }

    public RencontreDAL rencontre_To_RencontreDAL(Rencontre rencontre) {

        this.rencontre = rencontre;

        AdresseDAL adresse = new AdresseDAL();
        PhotoDAL photo = new PhotoDAL();
        UtilisateurDAL utilisateur = new UtilisateurDAL();

        List<UtilisateurDAL> utilisateurList = new ArrayList<>();
        List<JeuDAL> jeuList = new ArrayList<>();

        for (Utilisateur u : this.rencontre.getUtilisateursParticipants()) {
            utilisateurList.add(userMapperDAL.Utilisateur_To_UtilisateurDAL(u));
        }

        for (Jeu j : this.rencontre.getJeuList()) {
            jeuList.add(jeuMapperDAL.jeu_To_JeuDAL(j));
        }

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
                jeuList);

        return this.rencontreDAL;
    }
}
