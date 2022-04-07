package basico;
//poupança (filha de conta)
import java.util.ArrayList;

public class Serie extends Video implements Info{
    
    private ArrayList<Episode> episodios;
    private int numEpisode;

    public Serie(String name, String genre, int year, String nameCast) {
        super(name, genre, year, nameCast);
    }

    public int getNumEpisode() {
        return numEpisode;
    }

    public void setNumEpisode(int numEpisode) {
        this.numEpisode = numEpisode;
    }

    @Override
    public boolean avancar(double valor) {
        for(Episode episodio : episodios){
            time = episodio.getTime() + valor;
            episodio.setTime(time);
        }
        return true;
    }

    @Override
    public boolean voltar(double valor) {
        for(Episode episodio : episodios){
            time = episodio.getTime() - valor;
            episodio.setTime(time);
        }
        return true;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Name:" + name +"\n"  +                            
                            "Gênero" + genre + "\n" +                                    
                            "Ano:" + year + "\n"
    );
        
                            
    }

    public boolean adicionarEpisodio(String name, double time){
        if(name != "" && time != 0){
            Episode episode = new Episode(name, time);
            if(this.episodios.add(episode)){
                return true;
            }else{
                return false;
            }            
        }else{
            return false;
        }
    }
    
}