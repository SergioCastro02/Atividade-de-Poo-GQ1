package basico;
import java.util.ArrayList;
import java.util.Scanner;
import basico.exception.VideoAlreadyPausedException;
import basico.exception.VideoAlreadyPlayingException;
import basico.exception.VideoNotFoundException;
import basico.exception.VideoNotInitializedException;
import basico.video.*;

public class PavaoPrime implements GetVideo {
    static Scanner sc = new Scanner(System.in);

    private ArrayList<Video> midias;
	private int cont = 0;

    public PavaoPrime() {
        this.midias = new ArrayList<>();
		this.cont = 0;
    }


    @Override
    public int getVideos() {
        return this.midias.size();
    }
}