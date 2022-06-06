package business.entity;

import business.interfaces.Information;

public class Movie extends Video implements Information {
    
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
	public void showInformations() {
      System.out.println( "Filme: " + this.name +"\n"
              + " Tempo de filme:" + this.time +"\n"
              + " Genero do filme:" + this.genre +"\n"
              + " Ano do filme:" + this.year +"\n"
              + " Nome do estúdio" + this.nameCast +"\n");

	}
}