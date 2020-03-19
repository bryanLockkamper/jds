package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Genre;
import be.ucm.jds.DAL.Entity.GenreDAL;

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

    public GenreDAL genre_To_GenreDAL(Genre genre){

        this.genre = genre;

        this.genreDAL = new GenreDAL(this.genre.getId(),
                this.genre.getTitre(),
                this.genre.getDesc());

        return this.genreDAL;
    }
}
