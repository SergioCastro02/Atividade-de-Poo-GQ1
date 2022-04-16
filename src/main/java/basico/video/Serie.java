package basico.video;
import basico.exception.VideoNotInitializedException;

import java.util.ArrayList;

public class Serie extends Video{

    private ArrayList<Episode> episodes;
    private int numEpisode;

    public Serie(String name, String genre, int year, String nameCast) {
        super(name, genre, year, nameCast);
        this.episodes = new ArrayList<Episode>();
    }

    public int getNumEpisode() {
        return numEpisode;
    }

    public void setNumEpisode(int numEpisode) {
        this.numEpisode = numEpisode;
    }

    public boolean adicionarEpisodio(String name, double time){
        if(name != "" && time != 0){
            Episode episode = new Episode(name, time);
            if(this.episodes.add(episode)){
                this.numEpisode++;
                return true;
            }else{
                return false;
            }            
        }else{
            return false;
        }
    }

    public boolean removerEpisodio(String name){
        for (Episode episode : this.episodes ) {
            if(episode.getTitulo().equals(name)){
                if(this.episodes.remove(episode)){
                    this.numEpisode--;
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;  
    }
    
    @Override
	public String toString() {
		String retorno = "Série: " + this.name + ",\n Gênero: " + this.genre +
			   "\n Ano: " + this.year + ",\n Nome do estúdio: " + this.nameCast;

        retorno += "\nEpisódios:";
        for(Episode episode : this.episodes ){
            retorno += "\nTítulo:" + episode.getTitulo() + 
                        "\nTempo:" + episode.getTime() + "\n";
        }
        return retorno;
	}

    @Override
    public boolean pass() throws VideoNotInitializedException {
        for(Episode episode : episodes){
            if (episode.playing == true){
                episode.pass();
                return true;
            }else{
                throw new VideoNotInitializedException();
            }
        }
        return false;
    }

    @Override
    public boolean back() throws VideoNotInitializedException {
        for(Episode episode : episodes){
            if (episode.playing == true){
                episode.back();
                return true;
            }else{
                throw new VideoNotInitializedException();
            }
        }
        return false;
    }
}