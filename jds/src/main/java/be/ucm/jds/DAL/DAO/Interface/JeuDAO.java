package be.ucm.jds.DAL.DAO.Interface;


import be.ucm.jds.DAL.Entity.JeuDAL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JeuDAO extends JpaRepository<JeuDAL, Long> {

    Optional<JeuDAL> findByTitre(String titre);

    List<JeuDAL> findByNbrJoueurMin(Integer nbr);

    List<JeuDAL> findByNbrJoueurMax(Integer nbr);

    List<JeuDAL> findByNbrJoueurMinAndNbrJoueurMax(Integer nbrMin,Integer nbrMax);

    List<JeuDAL> findByMaisonEdition(String maisonEdition);

    List<JeuDAL> findByAgeMin(Integer ageMin);

    List<JeuDAL> findByGenreList(String genre);

    List<JeuDAL> findByGenreList(String... genre);
}
