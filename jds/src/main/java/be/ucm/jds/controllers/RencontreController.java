package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Rencontre;
import be.ucm.jds.DAL.DAO.Class.RencontreDAOimpl;
import be.ucm.jds.DAL.DAO.Class.UtilisateurDAOimpl;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import be.ucm.jds.DAL.mappers.RencontreMapperDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class RencontreController {
    RencontreDAOimpl rencontreDAOimpl;
    UtilisateurDAOimpl utilisateurDAOimpl;

    @Autowired
    public RencontreController(RencontreDAOimpl rencontreDAOimpl, UtilisateurDAOimpl utilisateurDAOimpl) {
        this.rencontreDAOimpl = rencontreDAOimpl;
        this.utilisateurDAOimpl = utilisateurDAOimpl;
    }

    @PostMapping("/creerRencontre")
    public void creerRencontre(@RequestBody Rencontre rencontre) {
        RencontreDAL rencontreDAL = RencontreMapperDAL.rencontre_To_RencontreDAL(rencontre);
        rencontreDAOimpl.save(rencontreDAL);
    }

    @PostMapping("/modifierRencontre")
    public void modifierRencontre(@RequestBody Rencontre rencontre) {
        if (rencontre.getId() != null)
            rencontreDAOimpl.save(RencontreMapperDAL.rencontre_To_RencontreDAL(rencontre));
    }

    @PostMapping("/supprimerRencontre")
    public void supprimerRencontre(@RequestBody Long id) {
        rencontreDAOimpl.deleteById(id);
    }

    @GetMapping("rencontre/{id}")
    public Rencontre getRencontre(@PathVariable Long id) {
        return rencontreDAOimpl.findById(id);
    }

    @GetMapping("rencontres")
    public List<Rencontre> getAllRencontre() {
        return rencontreDAOimpl.findAll()
                .stream()
                .map(RencontreMapperDAL::rencontreDal_To_Rencontre)
                .collect(Collectors.toList());
    }

    @GetMapping("actualRencontres")
    public List<Rencontre> getActualRencontre() {
        return rencontreDAOimpl.findAll()
                .stream()
                .filter(rencontre -> rencontre.getDate().isAfter(LocalDateTime.now()))
                .map(RencontreMapperDAL::rencontreDal_To_Rencontre)
                .collect(Collectors.toList());
    }
}
