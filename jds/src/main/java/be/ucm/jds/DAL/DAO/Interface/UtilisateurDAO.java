package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.JeuDAL;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UtilisateurDAO extends JpaRepository<UtilisateurDAL, Long> {

    //recherche

    Optional<UtilisateurDAL> findByEmail(String email);

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

    List<UtilisateurDAL> findByRoles(String role);
    //mise a jour

    @Modifying
    @Query("UPDATE Utilisateur SET jeuPreferes = :jeuDALList WHERE id = :id")
    void saveJeuPreferes(List<JeuDAL> jeuDALList, Long id);

    @Modifying
    @Query("update Utilisateur set pseudo = :pseudo WHERE id = :id")
    void savePseudo(String pseudo, Long id);
}
