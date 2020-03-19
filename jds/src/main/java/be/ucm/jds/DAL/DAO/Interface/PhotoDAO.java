package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.PhotoDAL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoDAO extends JpaRepository<PhotoDAL, Long> {
}
