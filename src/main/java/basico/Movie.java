package basico;
public class Movie extends Video implements Info{
    
    private double time;

    public Movie(String name,double time, String genre, int year, String nameCast) {
        super(name, genre, year, nameCast);
        this.name = name;
        this.time = time;
        this.genre = genre;
        this.year = year;
        this.nameCast = nameCast;
    }

    public Movie(String name, String genre, int year, String nameCast) {
        super(name, genre, year, nameCast);
        this.name = name;
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
    public boolean voltar(double valor) {
        this.time =- valor;    
        return true;
    }
     
    @Override
    public boolean avancar(double valor) {
        this.time =+ valor;        
        return true;
    }

  @Override
	public String toString() {
		
        return "Filme: " + this.name +"\n"
        + " Tempo de filme:" + this.time +"\n"
         + " Genero do filme:" + this.genre +"\n" 
         + " Ano do filme:" + this.year +"\n"
         + " Nome pro elenco" + this.nameCast +"\n";
	}

    
}