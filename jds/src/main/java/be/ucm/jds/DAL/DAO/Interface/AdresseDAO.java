package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.Entity.AdresseDAL;
import be.ucm.jds.DAL.Entity.AdresseDAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdresseDAO extends JpaRepository<AdresseDAL, Long> {

    List<AdresseDAL> findByVille(String ville);

    List<AdresseDAL> findBycodePostale(Integer codePostale);

    List<AdresseDAL> findByRue(String rue);

    Optional<AdresseDAL> findById(Long id);

    Optional<AdresseDAL> findByPhoto(Long idPhoto);

    List<AdresseDAL> findByVilleAndRue(String ville,String rue);

    List<AdresseDAL> findByVilleAndCodePostal(String ville,Integer codePostale);

    List<AdresseDAL> findByRueAndCodePostal(String rue,Integer codePostale);

    Optional<AdresseDAL> findByRueAndNumero(String rue,String numero);

    Optional<AdresseDAL> findByVilleAndRueAndNumero(String ville,String rue,String numero);

    Optional<AdresseDAL> findByVilleAndRueAndCodePostalAndNumero(String ville,String rue,Integer codePostal,String numero);
}