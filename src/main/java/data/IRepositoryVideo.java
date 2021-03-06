package data;

import business.entity.Video;
import business.exceptions.*;
import business.interfaces.GetVideo;

public interface IRepositoryVideo extends GetVideo {

    boolean createMovie(String name, int temp, String genre,int year, String nameCast) throws CantCreateMovieException;

    boolean createSerie(String name, String genre,int year, String nameCast) throws CantCreateSerieException;

    void showInformationsVideoSpecified(String name);

    void showInformationsVideo();

    Video find(String name);

    boolean pause(String name) throws VideoNotFoundException, VideoAlreadyPausedException, ListOfEpisodesEmptyException, EpisodeNotFoundException;

    boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException, EpisodeNotFoundException, ListOfEpisodesEmptyException;

    void advance(String name) throws VideoAlreadyFinishedException, VideoNotFoundException, ListOfEpisodesEmptyException, EpisodeNotFoundException;

    void back(String name) throws VideoAlreadyFinishedException, VideoAlreadyFinishedException, ListOfEpisodesEmptyException, EpisodeNotFoundException, VideoNotFoundException;

}
