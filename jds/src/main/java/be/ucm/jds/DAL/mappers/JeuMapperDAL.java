package be.ucm.jds.DAL.mappers;

import be.ucm.jds.BL.Entity.Genre;
import be.ucm.jds.BL.Entity.Jeu;
import be.ucm.jds.DAL.Entity.GenreDAL;
import be.ucm.jds.DAL.Entity.JeuDAL;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class JeuMapperDAL {

    private Jeu jeu;
    private JeuDAL jeuDAL;

    @Autowired
    private GenreMapperDAL genreMapperDAL;

    public Jeu jeuDAL_To_Jeu (JeuDAL jeuDAL){
        this.jeuDAL = jeuDAL;

        List<Genre> genreList = new ArrayList<>();

        for (GenreDAL g : this.jeuDAL.getGenreList_jeu()) {
            genreList.add(genreMapperDAL.genreDAL_To_Genre(g));
        }

        this.jeu = new Jeu(this.jeuDAL.getId_jeu(),
                this.jeuDAL.getTitre_jeu(),
                this.jeuDAL.getDescr_jeu(),
                this.jeuDAL.getNbrJoueurMin_jeu(),
                this.jeuDAL.getNbrJoueurMax_jeu(),
                genreList,
                this.jeuDAL.getMaisonEdition_jeu(),
                this.jeuDAL.getAgeMin_jeu());

        return this.jeu;
    }

    public JeuDAL jeu_To_JeuDAL (Jeu jeu){
        this.jeu = jeu;

        List<GenreDAL> genreDALList = new ArrayList<>();

        for (Genre g : this.jeu.getGenre()) {
            genreDALList.add(genreMapperDAL.genre_To_GenreDAL(g));
        }

        this.jeuDAL = new JeuDAL(this.jeu.getId(),
                this.jeu.getTitre(),
                this.jeu.getDesc(),
                this.jeu.getNbrJoueursMin(),
                this.jeu.getNbrJoueursMax(),
                genreDALList,
                this.jeu.getMaisonEdition(),
                this.jeu.getAgeMin());

        return this.jeuDAL;
    }

}
