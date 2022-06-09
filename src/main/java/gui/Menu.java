//Singleton
package gui;

import business.exceptions.*;
import business.exceptions.VideoAlreadyPausedException;
import gui.movie.GUIMovie;
import gui.serie.GUISerie;

public class Menu{

    static GUIMovie guiMovie;
    static GUISerie guiSerie;

    static Menu menu;

    private Menu(){
        guiSerie = new GUISerie();
        guiMovie = new GUIMovie();
    }

    public static Menu getMenu(){
        if(menu == null){
            menu = new Menu();
        }
        return menu;
    }

    public static void exibirMenuSerie() throws CantCreateSerieException{
        guiSerie.menuSerie();
    }

    public static void exibirMenuMovie() throws VideoAlreadyPausedException, VideoAlreadyPlayingException, CantCreateMovieException {
        guiMovie.menuMovie();
    }

}