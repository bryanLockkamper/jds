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

    List<UtilisateurDAL> findByPseudoAndNom(String pseudo,String nom);

    List<UtilisateurDAL> findByPseudoAndNumero(String pseudo,String numTel);

    List<UtilisateurDAL> findByPseudoAndPrenom(String pseudo,String prenom);

    List<UtilisateurDAL> findByNomAndPrenom(String nom, String prenom);

    List<UtilisateurDAL> findByNomAndNumero(String nom, String numTel);

    List<UtilisateurDAL> findByPrenomAndNumero(String prenom, String numTel);

    List<UtilisateurDAL> findByPseudoAndNomAndNumero(String pseudo, String nom, String numTel);

    List<UtilisateurDAL> findByPseudoAndNomAndPrenom(String pseudo, String nom, String prenom);

    List<UtilisateurDAL> findByNumeroAndNomAndPrenom(String numTel, String nom,String prenom);

    List<UtilisateurDAL> findByNumeroAndNomAndPrenomAndPseudo(String numTel, String nom,String prenom,String pseudo);

    List<UtilisateurDAL> findByRoles(String role);

    //mise a jour

    @Modifying
    @Query("UPDATE Utilisateur SET pseudo = :pseudo WHERE id = :idUtilisateur ")
    void savePseudo(Long idUtilisateur,String pseudo);

    @Modifying
    @Query("UPDATE Utilisateur SET nom = :nom WHERE id = :idUtilisateur ")
    void saveNom(Long idUtilisateur,String nom);

    @Modifying
    @Query("UPDATE Utilisateur SET prenom = :prenom WHERE id = :idUtilisateur ")
    void savePrenom(Long idUtilisateur,String prenom);

    @Modifying
    @Query("UPDATE Utilisateur SET numero = :numero WHERE id = :idUtilisateur ")
    void saveNumero(Long idUtilisateur,String numero);

    @Modifying
    @Query("UPDATE Utilisateur SET password = :mdp WHERE id = :idUtilisateur ")
    void saveMdp(Long idUtilisateur,String mdp);

    @Modifying
    @Query("UPDATE Utilisateur SET description = :description WHERE id = :idUtilisateur ")
    void saveDescription(Long idUtilisateur,String description);

    @Modifying
    @Query("UPDATE Utilisateur SET genre = :genre WHERE id = :idUtilisateur ")
    void saveGenre(Long idUtilisateur,String genre);

    @Modifying
    @Query("UPDATE Utilisateur SET dateNaissance = :dateNaissance WHERE id = :idUtilisateur ")
    void saveDateNaissance(Long idUtilisateur,String dateNaissance);

    @Modifying
    @Query("UPDATE Utilisateur SET email = :email WHERE id = :idUtilisateur ")
    void saveEmail(Long idUtilisateur,String email);

    @Modifying
    @Query("UPDATE Utilisateur SET jeuPreferes = :jeuDALList WHERE id = :idUtilisateur ")
    void saveJeuPreferes(Long idUtilisateur,List<JeuDAL> jeuDALList);
}
