package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.DAL.DAO.Interface.JeuDAO;
import be.ucm.jds.DAL.Entity.JeuDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JeuDAOimpl {

    private JeuDAO jeuDAO;

    @Autowired
    public JeuDAOimpl(JeuDAO jeuDAO) {
        this.jeuDAO = jeuDAO;
    }

    public Optional<JeuDAL> findByTitre(String titre){
        return jeuDAO.findByTitre(titre);
    }

    public List<JeuDAL> findByNbrJoueurMin(Integer nbr){
        return jeuDAO.findByNbrJoueurMin(nbr);
    }

    public List<JeuDAL> findByNbrJoueurMax(Integer nbr){
        return jeuDAO.findByNbrJoueurMax(nbr);
    }

    public List<JeuDAL> findByNbrJoueurMinAndMax(Integer nbrMin,Integer nbrMax){
        return jeuDAO.findByNbrJoueurMinAndNbrJoueurMax(nbrMin,nbrMax);
    }

    public List<JeuDAL> findByMaisonEdition(String maisonEdition){
        return jeuDAO.findByMaisonEdition(maisonEdition);
    }

    public List<JeuDAL> findByAgeMin(Integer ageMin){
        return jeuDAO.findByAgeMin(ageMin);
    }

    public List<JeuDAL> findByGenre(String genre){
        return jeuDAO.findByGenres(genre);
    }

    public List<JeuDAL> findByGenres(String... genre){
        return jeuDAO.findByGenres(genre);
    }


}
