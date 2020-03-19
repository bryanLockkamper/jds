package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.BL.Entity.Photo;
import be.ucm.jds.DAL.DAO.Interface.AdresseDAO;
import be.ucm.jds.DAL.Entity.Adresse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdresseDAOimpl {

    private AdresseDAO adresseDAO;

    @Autowired
    public AdresseDAOimpl(AdresseDAO adresseDAO) {
        this.adresseDAO = adresseDAO;
    }

    public List<Adresse> all(){
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

    public Adresse save(Adresse adresse){
        return adresseDAO.save(adresse);
    }

    public Optional<Adresse> findById(Long idAdresse){
        return adresseDAO.findById(idAdresse);
    }

    public List<Adresse> findByVille(String ville){
        return adresseDAO.findByVille(ville);
    }

    public List<Adresse> findByRue(String rue){
        return adresseDAO.findByRue(rue);
    }

    public List<Adresse> findByCodePostal(Integer codePostal){
        return adresseDAO.findBycodePostale(codePostal);
    }

    public Optional<Adresse> findByPhoto(Long idPhoto){
        return adresseDAO.findById(idPhoto);
    }

    public List<Adresse> findByVilleAndRue(String ville,String rue){
        return adresseDAO.findByVilleAndRue(ville,rue);
    }

    public List<Adresse> findByVilleAndCodePostal(String ville,Integer codePostale){
        return adresseDAO.findByVilleAndCodePostal(ville,codePostale);
    }

    public List<Adresse> findByRueAndCodePostal(String rue,Integer codePostale){
        return adresseDAO.findByRueAndCodePostal(rue,codePostale);
    }

    public Optional<Adresse> findByRueAndNumero(String rue,String numero){
        return adresseDAO.findByRueAndNumero(rue,numero);
    }

    public Optional<Adresse> findByVilleAndRueAndNumero(String ville,String rue,String numero){
        return adresseDAO.findByVilleAndRueAndNumero(ville,rue,numero);
    }

    public Optional<Adresse> findByVilleAndRueAndCodePostalAndNumero(String ville,String rue,Integer codePostal,String numero){
        return adresseDAO.findByVilleAndRueAndCodePostalAndNumero(ville,rue,codePostal,numero);
    }
}
