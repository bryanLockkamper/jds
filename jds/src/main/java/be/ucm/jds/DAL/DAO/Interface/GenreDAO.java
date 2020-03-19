package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GenreDAO extends JpaRepository<Genre, Long> {

    Optional<Genre> findByTitre(String titre);
}
