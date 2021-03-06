package business;
import business.entity.Video;
import business.exceptions.*;
import data.video.RepositoryVideo;

public class VideoController {

    private RepositoryVideo repositoryVideo;

    public VideoController(){
        this.repositoryVideo = new RepositoryVideo();
    }

    public boolean createMovie(String name, int temp, String genre, int year, String nameCast) throws CantCreateMovieException {
        return this.repositoryVideo.createMovie(name, temp, genre, year, nameCast);
    }

    public void showInformationsVideoSpecified(String name){
        this.repositoryVideo.showInformationsVideoSpecified(name);
    }

    public boolean createSerie(String name, String genre, int year, String nameCast) throws CantCreateSerieException {
        return this.repositoryVideo.createSerie(name, genre, year, nameCast);
    }

    public Video find(String name){
        return this.repositoryVideo.find(name);
    }

    public void showInformationsVideo(){
        this.repositoryVideo.showInformationsVideo();
    }

    public boolean pause(String name) throws VideoNotFoundException, VideoAlreadyPausedException, ListOfEpisodesEmptyException, EpisodeNotFoundException {
        return this.repositoryVideo.pause(name);
    }

    public boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException, EpisodeNotFoundException, ListOfEpisodesEmptyException {
        return this.repositoryVideo.play(name);
    }

    public void advance(String name) throws VideoAlreadyFinishedException, VideoNotFoundException, ListOfEpisodesEmptyException, EpisodeNotFoundException {
        this.repositoryVideo.advance(name);
    }
    public void back(String name) throws VideoAlreadyFinishedException, VideoNotFoundException, ListOfEpisodesEmptyException, EpisodeNotFoundException {
        this.repositoryVideo.back(name);
    }

    public int getVideos() {
        return this.repositoryVideo.getVideos();
    }
}
