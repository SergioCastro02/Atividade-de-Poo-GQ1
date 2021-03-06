package business.interfaces;


import business.entity.Video;
import business.exceptions.*;

public interface IFacadeVideo {

    boolean createMovie(String name, int temp, String genre, int year, String nameCast) throws CantCreateMovieException;

    void showInformationsVideoSpecified(String name);

    boolean createSerie(String name, String genre, int year, String nameCast) throws CantCreateSerieException;

    Video find(String name);

    void showInformationsVideo();

    boolean pause(String name) throws VideoAlreadyPausedException, VideoNotFoundException, ListOfEpisodesEmptyException, EpisodeNotFoundException;

    boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException, EpisodeNotFoundException, ListOfEpisodesEmptyException, EpisodeCantAdvanceException;

    void advance(String name) throws VideoAlreadyFinishedException, VideoNotFoundException, EpisodeCantAdvanceException, ListOfEpisodesEmptyException, EpisodeNotFoundException;

    void back(String name) throws VideoAlreadyFinishedException, VideoNotFoundException, ListOfEpisodesEmptyException, EpisodeNotFoundException;

    int getVideos();
}
