package basico;
import java.util.ArrayList;
import java.util.Scanner;

import business.entity.Video;
import business.interfaces.GetVideo;

public class PavaoPrime implements GetVideo {
    static Scanner sc = new Scanner(System.in);

    private ArrayList<Video> midias;
	private int count;

    public PavaoPrime() {
        this.midias = new ArrayList<>();
		this.count = 0;
    }


    @Override
    public int getVideos() {
        return this.midias.size();
    }
}