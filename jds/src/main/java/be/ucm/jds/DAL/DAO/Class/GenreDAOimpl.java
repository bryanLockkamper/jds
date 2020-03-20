package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.DAL.DAO.Interface.GenreDAO;
import be.ucm.jds.DAL.Entity.GenreDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreDAOimpl{

    private GenreDAO genreDAO;

    @Autowired
    public GenreDAOimpl(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    public Optional<GenreDAL> findbyId(Long id){
        return genreDAO.findById(id);
    }

    public List<GenreDAL> findAll(){
        return genreDAO.findAll();
    }

    public GenreDAL save(GenreDAL genre){
        return genreDAO.save(genre);
    }

    public Boolean deleteById(Long id){
        try {
            genreDAO.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Optional<GenreDAL> findByTitre(String titre){
        return genreDAO.findByTitre(titre);
    }

    public Optional<GenreDAL> findById(Long id) {
        return genreDAO.findById(id);
    }
}
