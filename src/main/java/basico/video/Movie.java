package basico.video;
import basico.exception.VideoNotInitializedException;

public class Movie extends Video{
    
    private double time;

    public Movie(String name,double time, String genre, int year, String nameCast) {
        super(name, genre, year, nameCast);
        this.name = name;
        this.time = time;
        this.genre = genre;
        this.year = year;
        this.nameCast = nameCast;
    }
    
    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }


  @Override
	public String toString() {
		
        return "Filme: " + this.name +"\n"
        + " Tempo de filme:" + this.time +"\n"
         + " Genero do filme:" + this.genre +"\n" 
         + " Ano do filme:" + this.year +"\n"
         + " Nome do estúdio" + this.nameCast +"\n";
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