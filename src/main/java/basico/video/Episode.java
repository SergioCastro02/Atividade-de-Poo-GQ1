package basico.video;

import basico.exception.VideoNotInitializedException;

public class Episode extends Video{

    private String titulo;    
    private double time;

    public Episode(String titulo, double time) {
        super(titulo);
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

    @Override
    public boolean pass() throws VideoNotInitializedException {
        if(this.time > 0){
            this.time =+ 15.0;
            return true;
        }else{
            throw new VideoNotInitializedException();
        }
    }

    @Override
    public boolean back() throws VideoNotInitializedException {
        if(this.time > 0){
            this.time =- 15.0;
            return true;
        }else{
            throw new VideoNotInitializedException();
        }
    }

}
