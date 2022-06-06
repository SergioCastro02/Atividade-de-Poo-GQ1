package business;

import business.entity.Video;
import business.exceptions.VideoAlreadyPausedException;
import business.exceptions.VideoAlreadyPlayingException;
import business.exceptions.VideoNotFoundException;
import business.interfaces.IFacadeVideo;

public class FacadeVideo implements IFacadeVideo {
    private ControllerVideo controllerVideo = new ControllerVideo();

    @Override
    public boolean createMovie(String name, double temp, String genre, int year, String nameCast) {
        return this.controllerVideo.createMovie(name, temp, genre, year, nameCast);
    }

    @Override
    public boolean createSerie(String name, String genre, int year, String nameCast) {
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
    public boolean pause(String name) throws VideoAlreadyPausedException, VideoNotFoundException {
        return this.controllerVideo.pause(name);
    }

    @Override
    public boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException {
        return this.controllerVideo.play(name);
    }

    @Override
    public int getVideos() {
        return this.controllerVideo.getVideos();
    }
}
