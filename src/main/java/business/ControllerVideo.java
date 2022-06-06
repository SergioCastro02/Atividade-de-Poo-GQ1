package business;

import business.exceptions.VideoAlreadyPausedException;
import business.exceptions.VideoAlreadyPlayingException;
import business.exceptions.VideoNotFoundException;
import business.entity.Video;
import data.video.RepositoryVideo;

public class ControllerVideo {

    private RepositoryVideo repositoryVideo;

    public ControllerVideo(){
        this.repositoryVideo = new RepositoryVideo();
    }

    public boolean createMovie(String name, double temp, String genre, int year, String nameCast){
        return this.createMovie(name, temp, genre, year, nameCast);
    }

    public void showInformationsVideoSpecified(String name){
        this.repositoryVideo.showInformationsVideoSpecified(name);
    }

    public boolean createSerie(String name, String genre, int year, String nameCast){
        return this.repositoryVideo.createSerie(name, genre, year, nameCast);
    }

    public Video find(String name){
        return this.repositoryVideo.find(name);
    }

    public void showInformationsVideo(){
        this.repositoryVideo.showInformationsVideo();
    }

    public boolean pause(String name) throws VideoAlreadyPausedException, VideoNotFoundException {
        return this.repositoryVideo.pause(name);
    }

    public boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException {
        return this.repositoryVideo.play(name);
    }

    public int getVideos() {
        return this.repositoryVideo.getVideos();
    }
}