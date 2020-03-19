package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.GenreDAL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenreDAO extends JpaRepository<GenreDAL, Long> {

    Optional<GenreDAL> findByTitre(String titre);
}
