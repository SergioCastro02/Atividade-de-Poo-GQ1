package data;

import business.entity.Video;
import business.exceptions.VideoAlreadyFinishedException;
import business.exceptions.VideoAlreadyPausedException;
import business.exceptions.VideoAlreadyPlayingException;
import business.exceptions.VideoNotFoundException;
import business.interfaces.GetVideo;

public interface IRepositoryVideo extends GetVideo {

    boolean createMovie(String name, int temp, String genre,int year, String nameCast);

    boolean createSerie(String name, String genre,int year, String nameCast);

    void showInformationsVideoSpecified(String name);

    void showInformationsVideo();

    Video find(String name);

    boolean pause(String name) throws VideoNotFoundException, VideoAlreadyPausedException;

    boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException;

    void advance(String name) throws VideoAlreadyFinishedException, VideoNotFoundException;

    void back(String name) throws VideoAlreadyFinishedException, VideoAlreadyFinishedException;

}
