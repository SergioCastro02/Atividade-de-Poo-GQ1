//
package basico;
public class Movie extends Video{
    
    private double time;

    public Movie(String name, double temp, String genre, int year, String nameCast) {
        super(name, temp, genre, year, nameCast);
    }

    @Override
    public boolean avancar(double valor) {
        this.time =+ valor;        
        return true;
    }

    @Override
    public boolean voltar(double valor) {
        this.time =- valor;    
        return true;
    }
    

}