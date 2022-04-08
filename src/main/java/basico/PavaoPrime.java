package basico;
import java.util.ArrayList;

import basico.exception.ExceptionAlreadyPaused;
import basico.exception.ExceptionAlreadyPlayed;
      //banco
public class PavaoPrime implements VideoInterface{
    
    private ArrayList<Movie> filmes;
    private ArrayList<Serie> series;
    private ArrayList<Video> midias;
	private int contadorDeVideos = 0;
    private boolean playing ;

    public PavaoPrime() {
        this.filmes = new ArrayList<Movie>();
        this.series = new ArrayList<Serie>();
		contadorDeVideos = 0;

    }

    public Movie buscarFilme(String name){
        Movie retorno=null;
        for (Movie item : this.filmes ) {
            System.out.println(item);
            if(item.getName().equals(name)){
                System.out.println("Encontrou!");
                retorno = item;
            }
        }                 
        return retorno;
    }

    public Serie buscarSerie(String name){
        Serie retorno=null;
        for (Serie item : this.series ) {
            System.out.println(item);
            if(item.getName().equals(name)){
                System.out.println("Encontrou!");
                retorno = item;
            }
        }                 
        return retorno;
    }
    
    /*
    public void pause(Video video) throws ExceptionAlreadyPaused{

        Video busca = buscar(video);

        if(busca == null){
            System.out.println("Série não encontrada!");
        }else{
            if(playing == true){
                playing = false;
                System.out.println("Vídeo pausado...");
            }else{
                throw new ExceptionAlreadyPaused();
            }
        }    
    }

    public void play(String name) throws ExceptionAlreadyPlayed{

        Video busca = buscar(video);

        if(busca == null){
            System.out.println("Série não encontrada!");
        }else{
            if(playing == false){
                playing = true;
                System.out.println("Vídeo rolando...");            
            }else{
                throw new ExceptionAlreadyPlayed();
            }
        }
       
    }
*/
    public void pausarSerie(String name) throws ExceptionAlreadyPaused{
		for(Serie serie: this.series){
			if (serie.getName().equals(name)){
                this.playing = false;
                System.out.println("Série pausada...");
            }
		}
		throw new ExceptionAlreadyPaused();
	}

    public void playSerie(String name) throws ExceptionAlreadyPlayed{
		for(Serie serie: this.series){
			if (serie.getName().equals(name)){
                System.out.println("Encontrei");                
			    if(this.playing == false){
                    this.playing = true;
                    System.out.println("Série tocando...");
                }else{
                    throw new ExceptionAlreadyPlayed();
                }
            }
		}
		
	}
    public void pausarFilme(String name) throws ExceptionAlreadyPaused{
		for(Movie filme: this.filmes){
			if (filme.getName().equals(name)){
                System.out.println("Encontrei");
                this.playing = false;
                System.out.println("Filme pausado...");
			}else{
                throw new ExceptionAlreadyPaused();
            }
		}
		
	}

    public boolean playFilme(String name) throws ExceptionAlreadyPlayed{
		for(Movie filme: this.filmes){
			if (filme.getName().equals(name)){
                System.out.println("Encontrei");
                this.playing = true;
                System.out.println("Filme tocando...");				
			}
		}
		throw new ExceptionAlreadyPlayed();
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