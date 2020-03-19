package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Genre;
import be.ucm.jds.BL.Entity.Jeu;
import be.ucm.jds.DAL.Entity.GenreDAL;
import be.ucm.jds.DAL.Entity.JeuDAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JeuMapperDAL {

    public static Jeu jeuDAL_To_Jeu (JeuDAL jeuDAL){

        List<Genre> genreList = new ArrayList<>();

        for (GenreDAL g : jeuDAL.getGenreList()) {
            genreList.add(GenreMapperDAL.genreDAL_To_Genre(g));
        }

        return new Jeu(jeuDAL.getId(),
                jeuDAL.getTitre(),
                jeuDAL.getDescr(),
                jeuDAL.getNbrJoueurMin(),
                jeuDAL.getNbrJoueurMax(),
                genreList,
                jeuDAL.getMaisonEdition(),
                jeuDAL.getAgeMin());
    }

    public static JeuDAL jeu_To_JeuDAL (Jeu jeu){

        List<GenreDAL> genreDALList = new ArrayList<>();

        for (Genre g : jeu.getGenre()) {
            genreDALList.add(GenreMapperDAL.genre_To_GenreDAL(g));
        }

        return new JeuDAL(jeu.getId(),
                jeu.getTitre(),
                jeu.getDesc(),
                jeu.getNbrJoueursMin(),
                jeu.getNbrJoueursMax(),
                genreDALList,
                jeu.getMaisonEdition(),
                jeu.getAgeMin());
    }

}
