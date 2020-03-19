package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Long> {
}
