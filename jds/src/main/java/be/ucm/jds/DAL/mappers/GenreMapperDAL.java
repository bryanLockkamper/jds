package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Genre;
import be.ucm.jds.DAL.Entity.GenreDAL;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

public class GenreMapperDAL {

    public static Genre genreDAL_To_Genre(GenreDAL genreDAL){
        return new ModelMapper().map(genreDAL, Genre.class);
    }

    public static GenreDAL genre_To_GenreDAL(Genre genre){
        return new ModelMapper().map(genre, GenreDAL.class);
    }
}
