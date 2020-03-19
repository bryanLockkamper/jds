package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.PhotoDAL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhotoDAO extends JpaRepository<PhotoDAL, Long> {

    Optional<PhotoDAL> findByLien(String lien);

    Optional<PhotoDAL> findByAdresseId(Long adresseId);

    Optional<PhotoDAL> findByRencontreId(Long rencontreId);
}
