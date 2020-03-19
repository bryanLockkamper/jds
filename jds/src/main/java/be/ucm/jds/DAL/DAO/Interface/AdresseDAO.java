package be.ucm.jds.DAL.DAO.Interface;

import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.Entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdresseDAO extends JpaRepository<Adresse, Long> {

    List<Adresse> findByVille(String ville);

    List<Adresse> findBycodePostale(Integer codePostale);

    List<Adresse> findByRue(String rue);

    Optional<Adresse> findById(Long id);

    Optional<Adresse> findByPhoto(Long idPhoto);

    List<Adresse> findByVilleAndRue(String ville,String rue);

    List<Adresse> findByVilleAndCodePostal(String ville,Integer codePostale);

    List<Adresse> findByRueAndCodePostal(String rue,Integer codePostale);

    Optional<Adresse> findByRueAndNumero(String rue,String numero);

    Optional<Adresse> findByVilleAndRueAndNumero(String ville,String rue,String numero);

    Optional<Adresse> findByVilleAndRueAndCodePostalAndNumero(String ville,String rue,Integer codePostal,String numero);
}