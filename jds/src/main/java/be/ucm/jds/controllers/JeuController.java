package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Jeu;
import be.ucm.jds.DAL.DAO.Class.JeuDAOimpl;
import be.ucm.jds.DAL.DAO.Interface.JeuDAO;
import be.ucm.jds.DAL.Entity.JeuDAL;
import be.ucm.jds.DAL.mappers.JeuMapperDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class JeuController {

    JeuDAO jeuDAO;

    @Autowired
    public JeuController(JeuDAO jeuDAO) {
        this.jeuDAO = jeuDAO;
    }

    @PostMapping("/creerJeu")
    public void creerJeu(@RequestBody Jeu jeu) {
        JeuMapperDAL jeuMapperDAL = new JeuMapperDAL();
        JeuDAL jeuDAL = jeuDAO.save(jeuMapperDAL.jeu_To_JeuDAL(jeu));
        System.out.println(jeuDAL);
    }

    @PostMapping("/modifierJeu")
    public void modifierJeu(@RequestBody Jeu jeu) {
        //jeuDAL.save(jeu);
        System.out.println(jeu);
    }

    @PostMapping("/supprimerJeu")
    public void supprimerJeu(@RequestBody Long id) {
        //jeuDAL.save(jeu);
        System.out.println(id);
    }
}
