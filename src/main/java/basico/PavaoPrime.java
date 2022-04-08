package basico;
import java.util.ArrayList;

import basico.exception.ExceptionAlreadyPaused;
import basico.exception.ExceptionAlreadyPlayed;
      //banco
public class PavaoPrime implements VideoInterface{
    
    private ArrayList<Movie> filmes;
    private ArrayList<Serie> series;
    private ArrayList<Video> midias;
	private int contadorDeVideos;
    private boolean playing;

    public PavaoPrime() {
        this.filmes = new ArrayList<Movie>();
        this.series = new ArrayList<Serie>();
		contadorDeVideos = 0;

    }
    
    public void pause() throws ExceptionAlreadyPaused{
        if(playing == true){
            playing = false;
            System.out.println("Vídeo pausado...");
        }else{
            throw new ExceptionAlreadyPaused();
        }
    }

    public void play() throws ExceptionAlreadyPlayed{
        if(playing == false){
            playing = true;
            System.out.println("Vídeo rolando...");            
        }else{
            throw new ExceptionAlreadyPlayed();
        }
    }

    public boolean criarFilme(String name, double temp, String genre,int year, String nameCast){
        
        if(name != "" && temp != 0 && year != 0 && nameCast != "" && genre != ""){
            Movie filme = new Movie(name, temp, genre, year, nameCast);
            this.filmes.add(filme);
            this.contadorDeVideos++;
            return true;
        }else{
            return false;
        }
    }
    public void informacao(String name){
        if (name != ""){
            for(Video midia: this.midias){
                if(midia.getName() == name){
                   System.out.println(midia.toString());
                }
            }
        }else{
            System.out.println("Mídia não encontrada.");
        }
    }

    public boolean criarSerie(String name, double temp, String genre,int year, String nameCast) {
        if(name != "" && temp != 0 && year != 0 && nameCast != "" && genre != ""){
            Serie serie = new Serie(name, genre, year, nameCast);
            this.series.add(serie);
            this.contadorDeVideos++;
            return true;
        }else{
            return false;
        }

    }

    

    @Override
    public int getVideos() {
        return this.midias.size();
    }


}