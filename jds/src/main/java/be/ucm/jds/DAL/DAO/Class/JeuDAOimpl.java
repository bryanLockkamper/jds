package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.DAL.DAO.Interface.JeuDAO;
import be.ucm.jds.DAL.Entity.Jeu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class JeuDAOimpl {

    private JeuDAO jeuDAO;

    @Autowired
    public JeuDAOimpl(JeuDAO jeuDAO) {
        this.jeuDAO = jeuDAO;
    }

    public Optional<Jeu> findByTitre(String titre){
        return findByTitre(titre);
    }

    public List<Jeu> findByNbrJoueurMin(Integer nbr){
        return findByNbrJoueurMin(nbr);
    }

    public List<Jeu> findByNbrJoueurMax(Integer nbr){
        return findByNbrJoueurMax(nbr);
    }

    public List<Jeu> findByNbrJoueurMinAndMax(Integer nbrMin,Integer nbrMax){
        return findByNbrJoueurMinAndMax(nbrMin,nbrMax);
    }

    public List<Jeu> findByMaisonEdition(String maisonEdition){
        return findByMaisonEdition(maisonEdition);
    }

    public List<Jeu> findByAgeMin(Integer ageMin){
        return findByAgeMin(ageMin);
    }

    public List<Jeu> findByGenre(String genre){
        return findByGenre(genre);
    }

    public List<Jeu> findByGenres(String... genre){
        return findByGenres(genre);
    }


}
