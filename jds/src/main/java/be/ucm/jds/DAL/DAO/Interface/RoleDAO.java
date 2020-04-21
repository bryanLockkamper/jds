package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.RoleDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.Optional;

@Transactional
@Repository
public interface RoleDAO extends JpaRepository<RoleDAL, Long> {

    Optional<RoleDAL> findById(Long id);
}
