package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.DAL.DAO.Interface.UtilisateurDAO;
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

    public Optional<UtilisateurDAL> findByNumTel(String numTel){
        return utilisateurDAO.findByNumTel(numTel);
    }

    public List<UtilisateurDAL> findByJeuId(Long jeuId){
        return utilisateurDAO.findByJeuId(jeuId);
    }

    public List<UtilisateurDAL> findByRencontreAffId(Long rencontreId){
        return utilisateurDAO.findByRencontreAffId(rencontreId);
    }

    public Optional<UtilisateurDAL> findByRencontreCreaId(Long rencontreId){
        return utilisateurDAO.findByRencontreCreaId(rencontreId);
    }
}
