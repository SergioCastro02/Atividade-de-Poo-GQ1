//
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

    @Override
    public void mostrarInformacoes() {
        // TODO Auto-generated method stub
        
    }
    

}