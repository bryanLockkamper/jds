package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Genre;
import be.ucm.jds.DAL.Entity.GenreDAL;
import org.springframework.stereotype.Service;

@Service
public class GenreMapperDAL {

    private Genre genre;
    private GenreDAL genreDAL;

    public Genre genreDAL_To_Genre(GenreDAL genreDAL){

        this.genreDAL = genreDAL;

        this.genre = new Genre(this.genreDAL.getId(),
                this.genreDAL.getTitre(),
                this.genreDAL.getDescription());

        return this.genre;
    }

    public static GenreDAL genre_To_GenreDAL(Genre genre){

        GenreDAL genreDAL = new GenreDAL(genre.getId(),
                genre.getTitre(),
                genre.getDesc());

        return genreDAL;
    }
}
