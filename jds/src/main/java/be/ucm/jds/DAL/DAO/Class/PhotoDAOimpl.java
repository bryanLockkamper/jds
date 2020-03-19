package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.DAL.DAO.Interface.PhotoDAO;
import be.ucm.jds.DAL.Entity.PhotoDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoDAOimpl {

    PhotoDAO photoDAO;

    @Autowired
    public PhotoDAOimpl(PhotoDAO photoDAO) {
        this.photoDAO = photoDAO;
    }

    public List<PhotoDAL> findAll(){
        return photoDAO.findAll();
    }

    public PhotoDAL save(PhotoDAL photoDAL){
        return photoDAO.save(photoDAL);
    }

    public Boolean deleteById(Long id){
        try {
            photoDAO.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Optional<PhotoDAL> findByLien(String lien){
        return photoDAO.findByLien(lien);
    }

    public Optional<PhotoDAL> findByAdresseId(Long adresseId){
        return photoDAO.findByAdresseId(adresseId);
    }

    public Optional<PhotoDAL> findByRencontreId(Long rencontreId){
        return photoDAO.findByRencontreId(rencontreId);
    }
}
