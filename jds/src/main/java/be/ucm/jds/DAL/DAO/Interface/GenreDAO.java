package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.GenreDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreDAO extends CrudRepository<GenreDAL, Long> {

    Optional<GenreDAL> findByTitre(String titre);
}
