package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.GroupeDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeDAO extends JpaRepository<GroupeDAL, Long> {
}
