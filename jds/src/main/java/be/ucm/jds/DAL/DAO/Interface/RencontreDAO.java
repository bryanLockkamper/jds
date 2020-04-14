package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.RencontreDAL;
import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RencontreDAO extends JpaRepository<RencontreDAL, Long> {

    List<RencontreDAL> findByTitre(String titre);

    List<RencontreDAL> findByDate(LocalDate date);

    List<RencontreDAL> findByTempsDeJeu(Integer tempDeJeu);

    List<RencontreDAL> findByNbrParticipantLimite(Integer nbrParticipantLimite);

    List<RencontreDAL> findByUtilisateurAffList(Long utilisateurAffListId);

    List<RencontreDAL> findByUtilisateurCrea(Long utilisateurCrea);

    List<RencontreDAL> findByJeuList(Long idJeu);

    void deleteByUtilisateurCrea(Long utilisateurCrea);
}
