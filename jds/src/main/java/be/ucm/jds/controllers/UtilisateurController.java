package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.*;
import be.ucm.jds.DAL.DAO.Class.RoleDAOimpl;
import be.ucm.jds.DAL.DAO.Class.UtilisateurDAOimpl;
import be.ucm.jds.DAL.Entity.JeuDAL;
import be.ucm.jds.DAL.Entity.RoleDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import be.ucm.jds.DAL.mappers.UtilisateurMapperDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class UtilisateurController {

    UtilisateurDAOimpl utilisateurDAO;
    RoleDAOimpl roleDAO;

    @Autowired
    public UtilisateurController(UtilisateurDAOimpl utilisateurDAO, RoleDAOimpl roleDAO) {
        this.utilisateurDAO = utilisateurDAO;
        this.roleDAO = roleDAO;
    }

    @PostMapping("/creerUtilisateur")
    public void creerUtilisateur(@RequestBody UtilisateurRegister utilisateur) {
        Long roleId = 2L;
        UtilisateurDAL utilisateurDAL = UtilisateurMapperDAL.utilisateurRegister_To_UtilisateurDAL(utilisateur);
        Optional<RoleDAL> roles = roleDAO.findById(roleId);
        List<RoleDAL> roleDALList = new ArrayList<>();
        roleDALList.add(roles.orElse(null));
        utilisateurDAL.setRoles(roleDALList);
        utilisateurDAO.save(utilisateurDAL);
    }

    @PostMapping("/modifierUtilisateur")
    public void modifierUtilisateur(@RequestBody Utilisateur utilisateur) {
        System.out.println(utilisateur.toString());
        System.out.println(utilisateur.getId().toString());
        UtilisateurDAL utilisateurDAL = utilisateurDAO.findById(utilisateur.getId()).orElse(null);
        if (utilisateurDAL != null){
            utilisateurDAO.save( UtilisateurMapperDAL.utilisateur_to_utilisateurDAL_upDate(utilisateur,utilisateurDAL) );
        }else {
            System.out.println("no");
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

    @GetMapping("utilisateur/{id}/groupes")
    public List<Groupe> getGroupesUtilisateur(@PathVariable Long id) {
        return UtilisateurMapperDAL.utilisateurDAL_To_Utilisateur(Objects.requireNonNull(utilisateurDAO.findById(id).orElse(null))).getGroupes();
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

    @GetMapping("utilisateurRoles")
    public List<Utilisateur> getUtilisateurRole(@RequestBody String  role){
        return utilisateurDAO.findByRole(role).stream()
                .map(UtilisateurMapperDAL::utilisateurDAL_To_Utilisateur)
                .collect(Collectors.toList());
    }
}
