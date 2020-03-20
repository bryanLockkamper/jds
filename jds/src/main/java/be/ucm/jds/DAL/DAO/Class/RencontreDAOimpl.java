package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.DAL.DAO.Interface.RencontreDAO;
import be.ucm.jds.DAL.Entity.RencontreDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RencontreDAOimpl {

    private RencontreDAO rencontreDAO;

    @Autowired
    public RencontreDAOimpl(RencontreDAO rencontreDAO) {
        this.rencontreDAO = rencontreDAO;
    }

    public List<RencontreDAL> findAll(){
        return (List<RencontreDAL>) rencontreDAO.findAll();
    }

    public RencontreDAL save(RencontreDAL rencontreDAL){
        return rencontreDAO.save(rencontreDAL);
    }

    public Boolean deleteById(Long id){
        try {
            rencontreDAO.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Boolean deleteByIdUtilisateur(Long idUtilisateur){
        try {
            rencontreDAO.deleteByUtilisateurCrea(idUtilisateur);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<RencontreDAL> findByTitre(String titre){
        return rencontreDAO.findByTitre(titre);
    }

    public List<RencontreDAL> findByDate(LocalDate date){
        return rencontreDAO.findByDate(date);
    }

    public List<RencontreDAL> findByTempDeJeu(Integer tempDeJeu){
        return rencontreDAO.findByTempDeJeu(tempDeJeu);
    }

    public List<RencontreDAL> findByNbrParticipantLimite(Integer nbrParticipantLimite){
        return rencontreDAO.findByNbrParticipantLimite(nbrParticipantLimite);
    }

    public List<RencontreDAL> findByUtilisateur(Long idUtilisateur){
        return rencontreDAO.findByUtilisateurCrea(idUtilisateur);
    }

    public List<RencontreDAL> findByUtlisateurList(Long idUtilisateurParticipants){
        return rencontreDAO.findByUtilisateurAffList(idUtilisateurParticipants);
    }

    public List<RencontreDAL> findByJeu(Long idJeu){
        return rencontreDAO.findByJeuList(idJeu);
    }

}
