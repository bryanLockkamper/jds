package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Utilisateur;
import be.ucm.jds.DAL.DAO.Interface.UtilisateurDAO;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import be.ucm.jds.DAL.mappers.UtilisateurMapperDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class UtilisateurController {

    UtilisateurDAO utilisateurDAO;

    @Autowired
    public UtilisateurController(UtilisateurDAO utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }

    @PostMapping("/creerUtilisateur")
    public void creerUtilisateur(@RequestBody Utilisateur utilisateur) {
        UtilisateurDAL utilisateurDAL = UtilisateurMapperDAL.utilisateur_To_UtilisateurDAL(utilisateur);
        utilisateurDAO.save(utilisateurDAL);
    }

    @PostMapping("/modifierUtilisateur")
    public void modifierUtilisateur(@RequestBody Utilisateur utilisateur) {
        if (utilisateur.getId() != null)
            utilisateurDAO.save(UtilisateurMapperDAL.utilisateur_To_UtilisateurDAL(utilisateur));
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
}
