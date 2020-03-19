package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.Rencontre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RencontreDAO extends JpaRepository<Rencontre, Long> {
}
