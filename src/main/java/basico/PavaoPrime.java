package basico;
import java.util.ArrayList;

import basico.exception.ExceptionAlreadyPaused;
import basico.exception.ExceptionAlreadyPlayed;
      //banco
public class PavaoPrime implements VideoInterface{
    
    private ArrayList<Movie> movies;
    private ArrayList<Serie> series;
    private ArrayList<Video> midias;
	private int contadorDeVideos = 0;
    private boolean playing;

    public PavaoPrime() {
        this.movies = new ArrayList<Movie>();
        this.series = new ArrayList<Serie>();
		contadorDeVideos = 0;
        playing = true;
    }

    public Movie buscarFilme(String name){
        Movie retorno=null;
        for (Movie movie : this.movies ) {
            System.out.println(movie);
            if(movie.getName().equals(name)){
                System.out.println("Encontrou!");
                retorno = movie;
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


    public void mostrarInformacoesSerie(String name){
        for(Serie serie : this.series){
            if(serie.getName().equals(name)){
                System.out.println(serie);
            }else{
                 System.out.println("Série não encontrada!");
            }
        }
    }

    public void mostrarInformacoesMovie(String name){
        for(Movie filme : this.movies){
            if(filme.getName().equals(name)){
                System.out.println(filme);
            }else{
                System.out.println("Série não encontrada!");
            }
        }
    }

    public void pausarSerie(String name) throws ExceptionAlreadyPaused{
		for(Serie serie: this.series){
			if (serie.getName().equals(name)){
                if(this.playing == true){
                    this.playing = false;
                    System.out.println("Série pausada...");
                }else{
                    throw new ExceptionAlreadyPaused();
                }
            }
		}
	}

    public void playSerie(String name) throws ExceptionAlreadyPlayed{
		for(Serie serie: this.series){
			if (serie.getName().equals(name)){             
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
		for(Movie movie: this.movies){
			if (movie.getName().equals(name)){
                if(this.playing == true){
                    this.playing = false;
                    System.out.println("Filme pausado...");
                }else{
                    throw new ExceptionAlreadyPaused();
                }
			}
		}
	}

    public void playFilme(String name) throws ExceptionAlreadyPlayed{
		for(Movie movie: this.movies){
			if (movie.getName().equals(name)){
                if(this.playing == false){
                    this.playing = true;
                    System.out.println("Filme tocando...");	
                }else{
                    throw new ExceptionAlreadyPlayed();
                }		
			}
		}
	}

    public boolean criarFilme(String name, double temp, String genre,int year, String nameCast){
        
        if(name != "" && temp != 0 && year != 0 && nameCast != "" && genre != ""){
            Movie movie = new Movie(name, temp, genre, year, nameCast);
            this.movies.add(movie);
            this.contadorDeVideos++;
            return true;
        }else{
            return false;
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