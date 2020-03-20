package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.DAL.Entity.PhotoDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhotoDAO extends CrudRepository<PhotoDAL, Long> {

    Optional<PhotoDAL> findByLien(String lien);

    Optional<PhotoDAL> findByAdresseId(Long adresseId);

    Optional<PhotoDAL> findByRencontreId(Long rencontreId);
}
