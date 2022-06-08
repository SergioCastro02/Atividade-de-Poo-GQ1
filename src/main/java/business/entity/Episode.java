package business.entity;

public class Episode extends Video {

    private String title;    
    private int time;

    public Episode(String title, int time) {
        super(title);
        this.title = title;
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getTitulo() {
        return title;
    }

    public void setTitulo(String title) {
        this.title = title;
    }

}
