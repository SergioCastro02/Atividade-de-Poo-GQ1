package business.entity;

public class Episode extends Video {

    private String title;    
    private double time;

    public Episode(String title, double time) {
        super(title);
        this.title = title;
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getTitulo() {
        return title;
    }

    public void setTitulo(String title) {
        this.title = title;
    }

}
