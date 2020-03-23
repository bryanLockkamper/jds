package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.JeuDAL;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurDAO extends JpaRepository<UtilisateurDAL, Long> {

    //recherche

    List<UtilisateurDAL> findByEmail(String email);

    List<UtilisateurDAL> findByPseudo(String pseudo);

    List<UtilisateurDAL> findByNom(String nom);

    List<UtilisateurDAL> findByPrenom(String prenom);

    Optional<UtilisateurDAL> findByNumero(String numTel);

    List<UtilisateurDAL> findByJeuPreferes(JeuDAL jeuDAL);

    List<UtilisateurDAL> findByRencontreAffList(RencontreDAL rencontreDAL);

    Optional<UtilisateurDAL> findByRencontreCreaList(RencontreDAL rencontreDAL);

    List<UtilisateurDAL> findByPseudoAndNom(String pseudo,String nom);

    List<UtilisateurDAL> findByPseudoAndNumero(String pseudo,String numTel);

    List<UtilisateurDAL> findByPseudoAndPrenom(String pseudo,String prenom);

    List<UtilisateurDAL> findByNomAndPrenom(String nom, String prenom);

    List<UtilisateurDAL> findByNomAndNumero(String nom, String numTel);

    List<UtilisateurDAL> findByPrenomAndNumero(String prenom, String numTel);

    //mise a jour

    @Transactional
    @Modifying
    @Query("UPDATE Utilisateur SET pseudo = :pseudo WHERE id = :idUtilisateur ")
    void savePseudo(Long idUtilisateur,String pseudo);

    @Transactional
    @Modifying
    @Query("UPDATE Utilisateur SET jeuPreferes = :jeuDALList WHERE id = :idUtilisateur ")
    void saveJeuPreferes(Long idUtilisateur,List<JeuDAL> jeuDALList);
}
