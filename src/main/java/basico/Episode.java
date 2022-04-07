package basico;

public class Episode {

    private String titulo;    
    private double time;

    public Episode(String titulo, double time) {
        this.titulo = titulo;
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
