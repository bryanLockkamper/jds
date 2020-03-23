package be.ucm.jds.DAL.DAO.Class;

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

    //recherche

    public List<UtilisateurDAL> findAll(){
        return utilisateurDAO.findAll();
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

    public List<UtilisateurDAL> findByJeuId(JeuDAL jeuDALList){
        return utilisateurDAO.findByJeuPreferes(jeuDALList);
    }

    public List<UtilisateurDAL> findByRencontreAffId(RencontreDAL rencontreDALList){
        return utilisateurDAO.findByRencontreAffList(rencontreDALList);
    }

    public Optional<UtilisateurDAL> findByRencontreCreaList(RencontreDAL rencontreDALList){
        return utilisateurDAO.findByRencontreCreaList(rencontreDALList);
    }

    public List<UtilisateurDAL> findByPseudoAndNom(String pseudo,String nom){
        return utilisateurDAO.findByPseudoAndNom(pseudo,nom);
    }

    public List<UtilisateurDAL> findByPseudoAndNumero(String pseudo,String numTel){
        return utilisateurDAO.findByPseudoAndNumero( pseudo, numTel);
    }

    public List<UtilisateurDAL> findByPseudoAndPrenom(String pseudo,String prenom){
        return utilisateurDAO.findByPseudoAndPrenom( pseudo, prenom);
    }

    public List<UtilisateurDAL> findByNomAndPrenom(String nom, String prenom){
        return utilisateurDAO.findByNomAndPrenom( nom,  prenom);
    }

    public List<UtilisateurDAL> findByNomAndNumero(String nom, String numTel){
        return utilisateurDAO.findByNomAndNumero( nom,  numTel);
    }

    public List<UtilisateurDAL> findByPrenomAndNumero(String prenom, String numTel){
        return utilisateurDAO.findByPrenomAndNumero( prenom,  numTel);
    }

    //mise a jour

    public UtilisateurDAL save(UtilisateurDAL utilisateurDAL){
        return utilisateurDAO.save(utilisateurDAL);
    }

    public void updatePseudo(Long id,String pseudo) {
        utilisateurDAO.savePseudo(pseudo, id);
    }

    public void saveJeuPreferes(Long idUtilisateur,List<JeuDAL> jeuDALList){
        utilisateurDAO.saveJeuPreferes(idUtilisateur,jeuDALList);
    }

    //delete util ou données

    public Boolean deleteId(Long id){
        try {
            utilisateurDAO.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
