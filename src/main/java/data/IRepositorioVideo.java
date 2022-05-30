package data;

import basico.exception.VideoAlreadyPausedException;
import basico.exception.VideoAlreadyPlayingException;
import basico.exception.VideoNotFoundException;
import basico.video.GetVideo;
import basico.video.Video;

public interface IRepositorioVideo extends GetVideo {

    boolean createMovie(String name, double temp, String genre,int year, String nameCast);

    boolean createSerie(String name, String genre,int year, String nameCast);

    void showInformationsVideoSpecified(String name);

    void showInformationsVideo();

    Video find(String name);

    boolean pause(String name) throws VideoAlreadyPausedException, VideoNotFoundException;

    boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException;

}
