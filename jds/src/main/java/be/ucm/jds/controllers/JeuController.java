package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Jeu;
import be.ucm.jds.DAL.DAO.Interface.JeuDAO;
import be.ucm.jds.DAL.mappers.JeuMapperDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        jeuDAO.save(JeuMapperDAL.jeu_To_JeuDAL(jeu));
    }

    @PostMapping("/modifierJeu")
    public void modifierJeu(@RequestBody Jeu jeu) {
        if (jeu.getId() != null)
            jeuDAO.save(JeuMapperDAL.jeu_To_JeuDAL(jeu));
    }

    @PostMapping("/supprimerJeu")
    public void supprimerJeu(@RequestBody Long id) {
        jeuDAO.deleteById(id);
    }

    @GetMapping("jeu/{id}")
    public Jeu getJeu(@PathVariable Long id) {
        return JeuMapperDAL.jeuDAL_To_Jeu(Objects.requireNonNull(jeuDAO.findById(id).orElse(null)));
    }

    @GetMapping("jeux")
    public List<Jeu> getAllJeu() {
        return jeuDAO.findAll()
                .stream()
                .map(JeuMapperDAL::jeuDAL_To_Jeu)
                .collect(Collectors.toList())
                ;
    }
}
