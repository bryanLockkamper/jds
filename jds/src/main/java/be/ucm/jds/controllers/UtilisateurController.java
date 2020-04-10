package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Jeu;
import be.ucm.jds.BL.Entity.Utilisateur;
import be.ucm.jds.BL.Entity.UtilisateurRegister;
import be.ucm.jds.DAL.DAO.Class.UtilisateurDAOimpl;
import be.ucm.jds.DAL.Entity.JeuDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import be.ucm.jds.DAL.mappers.UtilisateurMapperDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class UtilisateurController {

    UtilisateurDAOimpl utilisateurDAO;

    @Autowired
    public UtilisateurController(UtilisateurDAOimpl utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }

    @PostMapping("/creerUtilisateur")
    public void creerUtilisateur(@RequestBody UtilisateurRegister utilisateur) {
        UtilisateurDAL utilisateurDAL = UtilisateurMapperDAL.utilisateurRegister_To_UtilisateurDAL(utilisateur);
        utilisateurDAO.save(utilisateurDAL);
    }

    @PostMapping("/modifierUtilisateur")
    public void modifierUtilisateur(@RequestBody Utilisateur utilisateur) {
        if (utilisateur.getId() != null){
            //utilisateurDAO.save(UtilisateurMapperDAL.utilisateurRegister_To_UtilisateurDAL(utilisateur));
        }
    }

    @PostMapping("/supprimerUtilisateur")
    public void supprimerUtilisateur(@RequestBody Long id) {
        utilisateurDAO.deleteById(id);
    }

    @GetMapping("utilisateur/{id}")
    public Utilisateur getUtilisateur(@PathVariable Long id) {
        return UtilisateurMapperDAL.utilisateurDAL_To_Utilisateur(Objects.requireNonNull(utilisateurDAO.findById(id).orElse(null)));
    }

    @GetMapping("utilisateurs")
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurDAO.findAll()
                .stream()
                .map(UtilisateurMapperDAL::utilisateurDAL_To_Utilisateur)
                .collect(Collectors.toList())
                ;
    }

    @PostMapping("addJeuPrefere")
    public void addJeuPref(@RequestBody Jeu jeu) {
        List<JeuDAL> jeus = new ArrayList<>();
        utilisateurDAO.saveJeuPreferes(1L, jeus);
    }

    @PostMapping("removeJeuPrefere")
    public void removeJeuPref(@RequestBody Long id) {

    }

    @PostMapping("addAdresse")
    public void addAdresse(@RequestBody Jeu jeu) {

    }

    @PostMapping("removeAdresse")
    public void removeAdresse(@RequestBody Long id) {

    }

    @PostMapping("updatePseudo")
    public void updatePseudo(@RequestBody Utilisateur utilisateur) {
        utilisateurDAO.updatePseudo(utilisateur.getId(), utilisateur.getPseudo());
    }
}
