package basico;
//poupança (filha de conta)
import java.util.ArrayList;

public class Serie extends Video{
    
    private ArrayList<Video> episodios;
    private int numEpisode;

    public Serie(String name, double temp, String genre, int year, String nameCast) {
        super(name, temp, genre, year, nameCast);
    }

    public int getNumEpisode() {
        return numEpisode;
    }

    public void setNumEpisode(int numEpisode) {
        this.numEpisode = numEpisode;
    }

    @Override
    public boolean avancar(double valor) {
        for(Video episodio : episodios){
            episodio.time =+ valor;
        }
        return true;
    }

    @Override
    public boolean voltar(double valor) {
        for(Video episodio : episodios){
            episodio.time =- valor;
        }
        return true;
    }
    
}