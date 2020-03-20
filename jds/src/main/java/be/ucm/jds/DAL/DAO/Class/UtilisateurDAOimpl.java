package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.BL.Entity.Utilisateur;
import be.ucm.jds.DAL.DAO.Interface.UtilisateurDAO;
import be.ucm.jds.DAL.Entity.JeuDAL;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurDAOimpl {

    private UtilisateurDAO utilisateurDAO;

    @Autowired
    public UtilisateurDAOimpl(UtilisateurDAO utilisateurDAO) {
        this.utilisateurDAO = utilisateurDAO;
    }

    public List<UtilisateurDAL> findAll(){
        return utilisateurDAO.findAll();
    }

    public UtilisateurDAL save(UtilisateurDAL utilisateurDAL){
        return utilisateurDAO.save(utilisateurDAL);
    }

    public Boolean deleteId(Long id){
        try {
            utilisateurDAO.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<UtilisateurDAL> findByEmail(String email){
        return utilisateurDAO.findByEmail(email);
    }

    public List<UtilisateurDAL> findByPseudo(String pseudo){
        return utilisateurDAO.findByPseudo(pseudo);
    }

    public List<UtilisateurDAL> findByNom(String nom){
        return utilisateurDAO.findByNom(nom);
    }

    public List<UtilisateurDAL> findByPrenom(String prenom){
        return utilisateurDAO.findByPrenom(prenom);
    }

    public void deleteById(Long id) {
        utilisateurDAO.deleteById(id);
    }

    public Optional<UtilisateurDAL> findById(Long id) {
        return utilisateurDAO.findById(id);
    }

    public Optional<UtilisateurDAL> findByNumTel(String numTel){
        return utilisateurDAO.findByNumero(numTel);
    }

    public List<UtilisateurDAL> findByJeuId(List<JeuDAL> jeuDALList){
        return utilisateurDAO.findByJeuPreferes(jeuDALList);
    }

    public List<UtilisateurDAL> findByRencontreAffId(List<RencontreDAL> rencontreDALList){
        return utilisateurDAO.findByRencontreAffList(rencontreDALList);
    }

    public Optional<UtilisateurDAL> findByRencontreCreaList(List<RencontreDAL> rencontreDALList){
        return utilisateurDAO.findByRencontreCreaList(rencontreDALList);
    }
}
