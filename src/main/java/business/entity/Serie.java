package business.entity;

import business.interfaces.Information;

import java.util.ArrayList;

public class Serie extends Video implements Information {

    private ArrayList<Episode> episodes;
    private int numEpisode;

    public Serie(String name, String genre, int year, String nameCast) {
        super(name, genre, year, nameCast);
        this.episodes = new ArrayList<Episode>();
    }

    public ArrayList<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(ArrayList<Episode> episodes) {
        this.episodes = episodes;
    }

    public int getNumEpisode() {
        return numEpisode;
    }

    public void setNumEpisode(int numEpisode) {
        this.numEpisode = numEpisode;
    }

    public boolean addEpisode(String name, double time){
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

    public boolean removeEpisode(String name){
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
    public void showInformations() {
		String retorno = "Série: " + this.name + ",\n Gênero: " + this.genre +
			   "\n Ano: " + this.year + ",\n Nome do estúdio: " + this.nameCast;

        retorno += "\nEpisódios:";
        for(Episode episode : this.episodes ){
            retorno += "\nTítulo:" + episode.getTitulo() + 
                        "\nTempo:" + episode.getTime() + "\n";
        }
        System.out.println(retorno);
	}

}