package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoDAO extends JpaRepository<Photo, Long> {
}
