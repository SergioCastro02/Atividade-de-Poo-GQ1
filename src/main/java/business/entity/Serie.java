package business.entity;

import business.exceptions.EpisodeNotFoundException;
import business.exceptions.ListOfEpisodesEmpty;
import business.strategys.StrategyVideo;

import java.util.ArrayList;

public class Serie extends Video implements StrategyVideo {

    private ArrayList<Episode> episodes;
    private int numEpisode;

    public Serie(String name, String genre, int year, String nameCast) {
        super(name, genre, year, nameCast);
        this.episodes = new ArrayList<Episode>();
    }
    public Serie(String name) {
        super(name);
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

    public boolean addEpisode(String name, int time){
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
		String returnsInformation = "Série: " + this.name + ",\n Gênero: " + this.genre +
			   "\n Ano: " + this.year + ",\n Nome do estúdio: " + this.nameCast;

            returnsInformation += "\nEpisódios:";
        for(Episode episode : this.episodes ){
            returnsInformation += "\nTítulo:" + episode.getTitulo() + 
                        "\nTempo:" + episode.getTime() + "\n";
        }
        System.out.println(returnsInformation);
	}

	public Video searchEpisode(String nameEpisode) throws EpisodeNotFoundException, ListOfEpisodesEmpty, ListOfEpisodesEmpty {
        if (this.episodes.size() > 0) {
            for (Episode episode : episodes) {
                System.out.println(episode.getName());
                if (episode.getTitulo().equals(nameEpisode)) {
                    return episode;
                }
            }
            throw  new EpisodeNotFoundException("Episódio não encontrado.");
        }
        throw  new ListOfEpisodesEmpty("Lista de episódios vazia.");
    }
}