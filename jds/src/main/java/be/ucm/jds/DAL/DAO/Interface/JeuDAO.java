package be.ucm.jds.DAL.DAO.Interface;


import be.ucm.jds.DAL.Entity.JeuDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JeuDAO extends JpaRepository<JeuDAL, Long> {

    Optional<JeuDAL> findByTitre(String titre);

    List<JeuDAL> findByNbrJoueurMin(Integer nbr);

    List<JeuDAL> findByNbrJoueurMax(Integer nbr);

    List<JeuDAL> findByNbrJoueurMinAndNbrJoueurMax(Integer nbrMin,Integer nbrMax);

    List<JeuDAL> findByMaisonEdition(String maisonEdition);

    List<JeuDAL> findByAgeMin(Integer ageMin);

    List<JeuDAL> findByGenres(String genre);

    List<JeuDAL> findByGenres(String... genre);
}
