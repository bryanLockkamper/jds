package be.ucm.jds.DAL.DAO.Class;

import be.ucm.jds.DAL.DAO.Interface.GenreDAO;
import be.ucm.jds.DAL.Entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class GenreDAOimpl {

    private GenreDAO genreDAO;

    @Autowired
    public GenreDAOimpl(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    public Optional<Genre> findbyId(Long id){
        return genreDAO.findById(id);
    }

    public List<Genre> findAll(){
        return genreDAO.findAll();
    }

    public Genre save(Genre genre){
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

    public Optional<Genre> findByTitre(String titre){
        return genreDAO.findByTitre(titre);
    }
}
