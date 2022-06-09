import business.VideoController;
import business.entity.Movie;
import business.entity.Video;
import business.exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class VideoTest {

    private ArrayList<Video> midias;
    private int count = 0;
    private VideoController VideoController = new VideoController();

    @BeforeEach
    public void setup(){
        this.midias = new ArrayList<>();
    }

    @Test
    public void esperaAumentoMidias() throws CantCreateMovieException{
        VideoController.createMovie("It", 160, "Terror", 2017, "Warn");
        Assertions.assertEquals(1, VideoController.getVideos());
    }

    @Test
    public void esperaIncrementoMidias() throws CantCreateMovieException{
        VideoController.createMovie("It", 160, "Terror", 2017, "Warn");
        Assertions.assertEquals(1, VideoController.getVideos());
    }

    @Test
    public void esperaPlayVideo() throws VideoAlreadyPlayingException, VideoNotFoundException, EpisodeCantAdvanceException, EpisodeNotFoundException, ListOfEpisodesEmptyException, CantCreateMovieException {
        VideoController.createMovie("It", 160, "Terror", 2017, "Warn");
        VideoController.play("It");

        Video movieFind = VideoController.find("It");
        Assumptions.assumeTrue(movieFind.getPlaying());
    }

    @Test
    public void esperaPauseVideo() throws VideoAlreadyPlayingException, VideoNotFoundException, EpisodeNotFoundException, ListOfEpisodesEmptyException, CantCreateMovieException {
        VideoController.createMovie("It", 160, "Terror", 2017, "Warn");
        VideoController.play("It");

        Video movieFind = VideoController.find("It");
        Assumptions.assumeFalse(movieFind.getPlaying());
    }

}
