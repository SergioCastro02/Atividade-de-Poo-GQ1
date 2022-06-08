package business.interfaces;


import business.entity.Video;
import business.exceptions.VideoAlreadyFinishedException;
import business.exceptions.VideoAlreadyPausedException;
import business.exceptions.VideoAlreadyPlayingException;
import business.exceptions.VideoNotFoundException;

public interface IFacadeVideo {

    boolean createMovie(String name, int temp, String genre, int year, String nameCast);

    void showInformationsVideoSpecified(String name);

    boolean createSerie(String name, String genre, int year, String nameCast);

    Video find(String name);

    void showInformationsVideo();

    boolean pause(String name) throws VideoAlreadyPausedException, VideoNotFoundException;

    boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException;

    void advance(String name) throws VideoAlreadyFinishedException, VideoNotFoundException;

    void back(String name) throws VideoAlreadyFinishedException, VideoNotFoundException;

    int getVideos();
}
