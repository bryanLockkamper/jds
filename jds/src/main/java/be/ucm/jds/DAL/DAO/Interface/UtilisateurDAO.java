package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.UtilisateurDAL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDAO extends JpaRepository<UtilisateurDAL, Long> {
}
