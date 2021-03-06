package business;

import business.entity.Video;
import business.exceptions.*;
import business.interfaces.IFacadeVideo;

public class FacadeVideo implements IFacadeVideo {
    private VideoController controllerVideo = new VideoController();

    @Override
    public boolean createMovie(String name, int temp, String genre, int year, String nameCast) throws CantCreateMovieException {
        return this.controllerVideo.createMovie(name, temp, genre, year, nameCast);
    }

    @Override
    public boolean createSerie(String name, String genre, int year, String nameCast) throws CantCreateSerieException {
        return this.controllerVideo.createSerie(name, genre, year, nameCast);
    }

    @Override
    public void showInformationsVideoSpecified(String name) {
        this.controllerVideo.showInformationsVideoSpecified(name);
    }


    @Override
    public Video find(String name) {
        return this.controllerVideo.find(name);
    }

    @Override
    public void showInformationsVideo() {
        this.controllerVideo.showInformationsVideo();
    }

    @Override
    public boolean pause(String name) throws VideoNotFoundException, VideoAlreadyPausedException, ListOfEpisodesEmptyException, EpisodeNotFoundException {
        return this.controllerVideo.pause(name);
    }

    @Override
    public boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException, EpisodeNotFoundException, ListOfEpisodesEmptyException {
        return this.controllerVideo.play(name);
    }

    @Override
    public void advance(String name) throws VideoAlreadyFinishedException, VideoNotFoundException, ListOfEpisodesEmptyException, EpisodeNotFoundException {
        this.controllerVideo.advance(name);
    }

    @Override
    public void back(String name) throws VideoAlreadyFinishedException, VideoNotFoundException, ListOfEpisodesEmptyException, EpisodeNotFoundException {
        this.controllerVideo.back(name);
    }

    @Override
    public int getVideos() {
        return this.controllerVideo.getVideos();
    }
}
