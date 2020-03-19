package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Genre;
import be.ucm.jds.DAL.Entity.GenreDAL;
import org.springframework.stereotype.Service;

@Service
public class GenreMapperDAL {

    public static Genre genreDAL_To_Genre(GenreDAL genreDAL){

        Genre genre = new Genre(genreDAL.getId(),
                genreDAL.getTitre(),
                genreDAL.getDescription());

        return genre;
    }

    public static GenreDAL genre_To_GenreDAL(Genre genre){

        GenreDAL genreDAL = new GenreDAL(genre.getId(),
                genre.getTitre(),
                genre.getDesc());

        return genreDAL;
    }
}
