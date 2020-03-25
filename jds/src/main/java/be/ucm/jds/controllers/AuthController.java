package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Jeu;
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
        //jeuDAL.save(jeu);
        //chercher user dans la db et puis le stocker dans le LocalStorage
        System.out.println(utilisateur);
        UtilisateurDAL utilisateurDAL = utilisateurDAOimpl.findByEmail(utilisateur.getEmail());
        return ResponseEntity.ok(UtilisateurMapperDAL.utilisateurDAL_To_Utilisateur(utilisateurDAL));
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
    public void inscription(@RequestBody UtilisateurRegister utilisateur) {

        utilisateurDAOimpl.save(UtilisateurMapperDAL.utilisateurRegister_To_UtilisateurDAL(utilisateur));
    }
}
