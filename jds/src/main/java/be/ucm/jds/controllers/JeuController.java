package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Jeu;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class JeuController {

    @PostMapping("/creerJeu")
    public void creerJeu(@RequestBody Jeu jeu) {
        //jeuDAL.save(jeu);
        System.out.println(jeu);
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
