package business.entity;

import business.strategys.StrategyVideo;

public class Movie extends Video implements StrategyVideo {
    
    private int time;

    public Movie(String name,int time, String genre, int year, String nameCast) {
        super(name, genre, year, nameCast);
        this.name = name;
        this.time = time;
        this.genre = genre;
        this.year = year;
        this.nameCast = nameCast;
    }
    
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
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