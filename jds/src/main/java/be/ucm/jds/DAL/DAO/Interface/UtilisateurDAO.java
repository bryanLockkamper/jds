package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.JeuDAL;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UtilisateurDAO extends JpaRepository<UtilisateurDAL, Long> {

    List<UtilisateurDAL> findByEmail(String email);

    List<UtilisateurDAL> findByPseudo(String pseudo);

    List<UtilisateurDAL> findByNom(String nom);

    List<UtilisateurDAL> findByPrenom(String prenom);

    Optional<UtilisateurDAL> findByNumero(String numTel);

    List<UtilisateurDAL> findByJeuPreferes(JeuDAL jeuDAL);

    List<UtilisateurDAL> findByRencontreAffList(RencontreDAL rencontreDAL);

    Optional<UtilisateurDAL> findByRencontreCreaList(RencontreDAL rencontreDAL);

    @Query("update Utilisateur set rencontreCreaList = :rencontreDALS where id = 1")
    RencontreDAL addRencontreCrea(List<RencontreDAL> rencontreDALS);
}
