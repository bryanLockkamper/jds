package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.Genre;
import be.ucm.jds.DAL.Entity.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JeuDAO extends JpaRepository<Jeu, Long> {

    Optional<Jeu> findByTitre(String titre);

    List<Jeu> findByNbrJoueurMin(Integer nbr);

    List<Jeu> findByNbrJoueurMax(Integer nbr);

    List<Jeu> findByNbrJoueurMinAndMax(Integer nbrMin,Integer nbrMax);

    List<Jeu> findByMaisonEdition(String maisonEdition);

    List<Jeu> findByAgeMin(Integer ageMin);

    List<Jeu> findByGenre(String genre);

    List<Jeu> findByGenres(String... genre);
}
