package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.Entity.AdresseDAL;
import be.ucm.jds.DAL.Entity.AdresseDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdresseDAO extends CrudRepository<AdresseDAL, Long> {

    List<AdresseDAL> findByVille(String ville);

    List<AdresseDAL> findBycodePostal(Integer codePostal);

    List<AdresseDAL> findByRue(String rue);

    Optional<AdresseDAL> findById(Long id);

    Optional<AdresseDAL> findByPhotos(Long idPhoto);

    List<AdresseDAL> findByVilleAndRue(String ville,String rue);

    List<AdresseDAL> findByVilleAndCodePostal(String ville,Integer codePostal);

    List<AdresseDAL> findByRueAndCodePostal(String rue,Integer codePostal);

    Optional<AdresseDAL> findByRueAndNumero(String rue,String numero);

    Optional<AdresseDAL> findByVilleAndRueAndNumero(String ville,String rue,String numero);

    Optional<AdresseDAL> findByVilleAndRueAndCodePostalAndNumero(String ville,String rue,Integer codePostal,String numero);
}