package business.interfaces;

import business.exceptions.VideoAlreadyPausedException;
import business.exceptions.VideoAlreadyPlayingException;
import business.exceptions.VideoNotFoundException;
import business.entity.Video;

public interface IFacadeVideo {

    boolean createMovie(String name, double temp, String genre, int year, String nameCast);

    void showInformationsVideoSpecified(String name);

    boolean createSerie(String name, String genre, int year, String nameCast);

    Video find(String name);

    void showInformationsVideo();

    boolean pause(String name) throws VideoAlreadyPausedException, VideoNotFoundException;

    boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException;

    int getVideos();
}
