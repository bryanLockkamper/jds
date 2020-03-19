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

    private Jeu jeu;
    private JeuDAL jeuDAL;


    private GenreMapperDAL genreMapperDAL;

    @Autowired
    public JeuMapperDAL(GenreMapperDAL genreMapperDAL) {
        this.genreMapperDAL = genreMapperDAL;
    }

    public Jeu jeuDAL_To_Jeu (JeuDAL jeuDAL){
        this.jeuDAL = jeuDAL;

        List<Genre> genreList = new ArrayList<>();

        for (GenreDAL g : this.jeuDAL.getGenreList()) {
            genreList.add(genreMapperDAL.genreDAL_To_Genre(g));
        }

        this.jeu = new Jeu(this.jeuDAL.getId(),
                this.jeuDAL.getTitre(),
                this.jeuDAL.getDescr(),
                this.jeuDAL.getNbrJoueurMin(),
                this.jeuDAL.getNbrJoueurMax(),
                genreList,
                this.jeuDAL.getMaisonEdition(),
                this.jeuDAL.getAgeMin());

        return this.jeu;
    }

    public static JeuDAL jeu_To_JeuDAL (Jeu jeu){

        List<GenreDAL> genreDALList = new ArrayList<>();

        for (Genre g : jeu.getGenre()) {
            genreDALList.add(GenreMapperDAL.genre_To_GenreDAL(g));
        }

        JeuDAL jeuDAL = new JeuDAL(jeu.getId(),
                jeu.getTitre(),
                jeu.getDesc(),
                jeu.getNbrJoueursMin(),
                jeu.getNbrJoueursMax(),
                genreDALList,
                jeu.getMaisonEdition(),
                jeu.getAgeMin());

        return jeuDAL;
    }

}
