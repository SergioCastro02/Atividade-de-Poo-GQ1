import business.VideoController;
import business.entity.Movie;
import business.entity.Video;
import business.exceptions.*;
import data.IRepositoryVideo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class VideoTest {

    private ArrayList<Video> midias;
    private int cont = 0;
    private VideoController controllerVideo = new VideoController();

    @BeforeEach
    public void setup(){
        this.midias = new ArrayList<>();
    }

    @Test
    public void esperaAumentoMidias() throws CantCreateMovieException {
        controllerVideo.createMovie("It", 160, "Terror", 2017, "Warn");
        Assertions.assertEquals(1, controllerVideo.getVideos());
    }

    @Test
    public void esperaIncrementoMidias() throws CantCreateMovieException {
        controllerVideo.createMovie("It", 160, "Terror", 2017, "Warn");
        Assertions.assertEquals(1, controllerVideo.getVideos());
    }

    @Test
    public void esperaPlayVideo() throws VideoAlreadyPlayingException, VideoNotFoundException, EpisodeCantAdvanceException, EpisodeNotFoundException, ListOfEpisodesEmptyException, CantCreateMovieException {
        controllerVideo.createMovie("It", 160, "Terror", 2017, "Warn");
        controllerVideo.play("It");

        Video movieFind = controllerVideo.find("It");
        Assumptions.assumeTrue(movieFind.getPlaying());
    }

    @Test
    public void esperaPauseVideo() throws VideoAlreadyPlayingException, VideoNotFoundException, EpisodeNotFoundException, ListOfEpisodesEmptyException, CantCreateMovieException {
        controllerVideo.createMovie("It", 160, "Terror", 2017, "Warn");
        controllerVideo.play("It");

        Video movieFind = controllerVideo.find("It");
        Assumptions.assumeFalse(movieFind.getPlaying());
    }

}
