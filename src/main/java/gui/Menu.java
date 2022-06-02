//Singleton
package gui;

import basico.exception.VideoAlreadyPausedException;
import basico.exception.VideoAlreadyPlayingException;
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

    public static void exibirMenuSerie() throws VideoAlreadyPlayingException, VideoAlreadyPausedException {
        guiMovie.menuMovie();
    }

    public static void exibirMenuMovie(){
        guiSerie.menuSerie();
    }

}