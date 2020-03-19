package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.RencontreDAL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RencontreDAO extends JpaRepository<RencontreDAL, Long> {

    List<RencontreDAL> findByTitre(String titre);

    List<RencontreDAL> findByDate(LocalDate date);

    List<RencontreDAL> findByTempDeJeu(Integer tempDeJeu);

    List<RencontreDAL> findByNbrParticipantLimite(Integer nbrParticipantLimite);

    List<RencontreDAL> findByUtilisateur(Long idUtilisateur);

    List<RencontreDAL> findByUtlisateurList(Long idUtilisateurParticipants);

    List<RencontreDAL> findByJeu(Long idJeu);

    void deleteByIdUtilisateur(Long idUtilisateur);
}
