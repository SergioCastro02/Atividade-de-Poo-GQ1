package data;

import business.entity.Video;
import business.exceptions.*;
import business.interfaces.GetVideo;

public interface IRepositoryVideo extends GetVideo {

    boolean createMovie(String name, int temp, String genre,int year, String nameCast);

    boolean createSerie(String name, String genre,int year, String nameCast);

    void showInformationsVideoSpecified(String name);

    void showInformationsVideo();

    Video find(String name);

    boolean pause(String name) throws VideoNotFoundException, VideoAlreadyPausedException;

    boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException, EpisodeNotFoundException, ListOfEpisodesEmptyException;

    void advance(String name) throws VideoAlreadyFinishedException, VideoNotFoundException, EpisodeCantAdvanceException;

    void back(String name) throws VideoAlreadyFinishedException, VideoAlreadyFinishedException;

}
