package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Utilisateur;
import be.ucm.jds.BL.Entity.UtilisateurLogin;
import be.ucm.jds.BL.Entity.UtilisateurRegister;
import be.ucm.jds.DAL.DAO.Class.UtilisateurDAOimpl;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import be.ucm.jds.DAL.mappers.UtilisateurMapperDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@CrossOrigin
@RestController
public class AuthController {
    private UtilisateurDAOimpl utilisateurDAOimpl;

    @Autowired
    public AuthController(UtilisateurDAOimpl utilisateurDAOimpl) {
        this.utilisateurDAOimpl= utilisateurDAOimpl;
    }

    @PostMapping("/seConnecter")
    public ResponseEntity<Utilisateur> seConnecter(@RequestBody UtilisateurLogin utilisateur) {
        UtilisateurDAL utilisateurDAL = utilisateurDAOimpl.findByEmail(utilisateur.getEmail());
        if (utilisateurDAL != null) {

            if (verifierMdp(utilisateur.getPassword()))
                return ResponseEntity.ok(UtilisateurMapperDAL.utilisateurDAL_To_Utilisateur(utilisateurDAL));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/seDeconnecter")
    public void seDeconnecter(@RequestBody Utilisateur utilisateur) {
        //jeuDAL.save(jeu);
        System.out.println(utilisateur);
    }

    @PostMapping("/rafraichirToken")
    public void rafraichirToken(@RequestBody Long id) {
        //jeuDAL.save(jeu);
        System.out.println(id);
    }

    @PostMapping("/inscription")
    public ResponseEntity<Utilisateur> inscription(@RequestBody UtilisateurRegister utilisateur) {
        if (utilisateurDAOimpl.findByEmail(utilisateur.getEmail()) == null
                && utilisateur.getPassword().equals(utilisateur.getConfirmpassword())
                && LocalDate.now().minusYears(18).isAfter(utilisateur.getDateNaissance())) {

            if (verifierMdp(utilisateur.getPassword()))
                return ResponseEntity.ok(UtilisateurMapperDAL.utilisateurDAL_To_Utilisateur(utilisateurDAOimpl.save(UtilisateurMapperDAL.utilisateurRegister_To_UtilisateurDAL(utilisateur))));


        }
        return ResponseEntity.notFound().build();
    }

    private boolean verifierMdp(String mdp) {
        boolean containsMajuscule = false;
        boolean containsNumber = false;
        for (int i = 0; i < mdp.length() & (!containsMajuscule | !containsNumber); i++) {
            char c = mdp.charAt(i);
            if (c > 'A' & c < 'Z')
                containsMajuscule = true;

            if (c > '0' & c < '9')
                containsNumber = true;
        }
        return containsMajuscule & containsNumber & mdp.length() >= 8;
    }
}
