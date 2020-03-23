package be.ucm.jds.controllers;

import be.ucm.jds.BL.Entity.Genre;
import be.ucm.jds.DAL.DAO.Class.GenreDAOimpl;
import be.ucm.jds.DAL.DAO.Interface.GenreDAO;
import be.ucm.jds.DAL.mappers.GenreMapperDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class GenreController {
    GenreDAOimpl genreDAO;

    @Autowired
    public GenreController(GenreDAOimpl genreDAO) {
        this.genreDAO = genreDAO;
    }

    @PostMapping("/creerGenre")
    public boolean creerGenre(@RequestBody Genre genre) {
        if (!genreDAO.findByTitre(genre.getTitre()).isPresent()) {
            genreDAO.save(GenreMapperDAL.genre_To_GenreDAL(genre));
            return true;
        }
        return false;
    }

    @PostMapping("/modifierGenre")
    public boolean modifierGenre(@RequestBody Genre genre) {
        if (genre.getId() != null) {
            genreDAO.save(GenreMapperDAL.genre_To_GenreDAL(genre));
            return true;
        }
        return false;
    }

    @PostMapping("/supprimerGenre")
    public void supprimerGenre(@RequestBody Long id) {
        genreDAO.deleteById(id);
    }

    @GetMapping("genre/{id}")
    public Genre getGenre(@PathVariable Long id) {
        return GenreMapperDAL.genreDAL_To_Genre(Objects.requireNonNull(genreDAO.findById(id).orElse(null)));
    }

    @GetMapping("genres")
    public List<Genre> getAllGenre() {
        return genreDAO.findAll()
                .stream()
                .map(GenreMapperDAL::genreDAL_To_Genre)
                .collect(Collectors.toList())
                ;
    }
}
