package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.DAO.Interface.AdresseDAO;
import be.ucm.jds.DAL.Entity.AdresseDAL;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdresseDAOimpl {

    private AdresseDAO adresseDAO;

    @Autowired
    public AdresseDAOimpl(AdresseDAO adresseDAO) {
        this.adresseDAO = adresseDAO;
    }

    public List<AdresseDAL> all(){
        return adresseDAO.findAll();
    }

    public Boolean deleteById(Long idAdresse){
        try {
            adresseDAO.deleteById(idAdresse);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public AdresseDAL save(AdresseDAL adresse){
        return adresseDAO.save(adresse);
    }

    public Optional<AdresseDAL> findById(Long idAdresse){
        return adresseDAO.findById(idAdresse);
    }

    public List<AdresseDAL> findByVille(String ville){
        return adresseDAO.findByVille(ville);
    }

    public List<AdresseDAL> findByRue(String rue){
        return adresseDAO.findByRue(rue);
    }

    public List<AdresseDAL> findByCodePostal(Integer codePostal){
        return adresseDAO.findBycodePostal(codePostal);
    }

    public Optional<AdresseDAL> findByPhoto(Long idPhoto){
        return adresseDAO.findById(idPhoto);
    }

    public List<AdresseDAL> findByVilleAndRue(String ville,String rue){
        return adresseDAO.findByVilleAndRue(ville,rue);
    }

    public List<AdresseDAL> findByVilleAndCodePostal(String ville,Integer codePostale){
        return adresseDAO.findByVilleAndCodePostal(ville,codePostale);
    }

    public List<AdresseDAL> findByRueAndCodePostal(String rue,Integer codePostale){
        return adresseDAO.findByRueAndCodePostal(rue,codePostale);
    }

    public Optional<AdresseDAL> findByRueAndNumero(String rue,String numero){
        return adresseDAO.findByRueAndNumero(rue,numero);
    }

    public Optional<AdresseDAL> findByVilleAndRueAndNumero(String ville,String rue,String numero){
        return adresseDAO.findByVilleAndRueAndNumero(ville,rue,numero);
    }

    public Optional<AdresseDAL> findByVilleAndRueAndCodePostalAndNumero(String ville,String rue,Integer codePostal,String numero){
        return adresseDAO.findByVilleAndRueAndCodePostalAndNumero(ville,rue,codePostal,numero);
    }
}
