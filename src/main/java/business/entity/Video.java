package business.entity;

public abstract class Video {

    protected String name;
    protected String genre;
    protected int  year;
    protected String nameCast;
    protected double time;
    protected boolean playing;

    public Video (String name, String genre , int year , String nameCast) {
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.nameCast = nameCast;
    }

    public Video (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getNameCast() {
        return nameCast;
    }

    public void setNameCast(String nameCast) {
        this.nameCast = nameCast;
    }

    public boolean getPlaying() {
        return this.playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

}
