package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.BL.Entity.Utilisateur;
import be.ucm.jds.DAL.DAO.Interface.UtilisateurDAO;
import be.ucm.jds.DAL.Entity.JeuDAL;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    public List<UtilisateurDAL> findByPseudoAndNomAndNumero(String pseudo, String nom, String numTel){
        return utilisateurDAO.findByPseudoAndNomAndNumero( pseudo,  nom,  numTel);
    }

    public List<UtilisateurDAL> findByPseudoAndNomAndPrenom(String pseudo, String nom, String prenom){
        return utilisateurDAO.findByPseudoAndNomAndPrenom( pseudo,  nom,  prenom);
    }

    public List<UtilisateurDAL> findByNumeroAndNomAndPrenom(String numTel, String nom,String prenom){
        return utilisateurDAO.findByNumeroAndNomAndPrenom( numTel,  nom, prenom);
    }

    public List<UtilisateurDAL> findByNumeroAndNomAndPrenomAndPseudo(String numTel, String nom,String prenom,String pseudo){
        return utilisateurDAO.findByNumeroAndNomAndPrenomAndPseudo( numTel,  nom, prenom, pseudo);
    }

    //mise a jour

    public UtilisateurDAL save(UtilisateurDAL utilisateurDAL){
        return utilisateurDAO.save(utilisateurDAL);
    }

    public void savePseudo(Long idUtilisateur,String pseudo) {
        utilisateurDAO.savePseudo(idUtilisateur,pseudo);
    }

    public void saveNom(Long idUtilisateur,String nom){
        utilisateurDAO.saveNom( idUtilisateur, nom);
    }

    public void savePrenom(Long idUtilisateur,String prenom){
        utilisateurDAO.savePrenom( idUtilisateur, prenom);
    }

    public void saveNumero(Long idUtilisateur,String numero){
        utilisateurDAO.saveNumero( idUtilisateur, numero);
    }

    public void saveMdp(Long idUtilisateur,String mdp){
        utilisateurDAO.saveMdp( idUtilisateur, mdp);
    }

    public void saveDescription(Long idUtilisateur,String description){
        utilisateurDAO.saveDescription( idUtilisateur, description);
    }

    public void saveGenre(Long idUtilisateur,String genre){
        utilisateurDAO.saveGenre( idUtilisateur, genre);
    }

    public void saveDateNaissance(Long idUtilisateur,String dateNaissance){
        utilisateurDAO.saveDateNaissance( idUtilisateur, dateNaissance);
    }

    public void saveEmail(Long idUtilisateur,String email){
        utilisateurDAO.saveEmail( idUtilisateur, email);
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

    public void updatePseudo(Long id,String pseudo) {         utilisateurDAO.savePseudo(id, pseudo);     }
}
