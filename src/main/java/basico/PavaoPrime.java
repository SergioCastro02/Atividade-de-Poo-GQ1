package basico;
import java.util.ArrayList;
import java.util.Scanner;

import basico.exception.ExceptionAlreadyPaused;
import basico.exception.ExceptionAlreadyPlayed;
      //banco
public class PavaoPrime implements VideoInterface{
    static Scanner sc = new Scanner(System.in);

    private ArrayList<Video> midias;
	private int cont = 0;

    public PavaoPrime() {
        this.midias = new ArrayList<Video>();
		this.cont = 0;
    }

    public Video buscarFilme(String name){
        Video retorno=null;
        for (Video movie : this.midias ) {
            System.out.println(movie);
            if(movie.getName().equals(name)){
                System.out.println("Encontrou!");
                retorno = movie;
            }
        }                 
        return retorno;
    }

    public Video buscarSerie(String name){
        Video retorno=null;
        for (Video item : this.midias ) {
            System.out.println(item);
            if(item.getName().equals(name)){
                retorno = item;
            }
        }                 
        return retorno;
    }

    public void mostrarInformacoes(){
        for(Video midia: this.midias){
			System.out.println(midia.toString());
		}
    }

    public Video buscar(String name){
        Video retorno = null;
        for(Video midia: this.midias){
			if (midia.getName().equals(name)){
                retorno = midia;
            }
        }
        return retorno;
    }

    public boolean pause(String name) throws ExceptionAlreadyPaused {
        Video busca = buscar(name);
        if(busca.getPlaying() == true){
            busca.setPlaying(false);
            System.out.println("Video pausado...");
            return true;
        }
		throw new ExceptionAlreadyPaused();
	}

    public boolean play(String name) throws ExceptionAlreadyPlayed {
        Video busca = buscar(name);
        if(busca.getPlaying() == false){
            busca.setPlaying(true);
            System.out.println("Video tocando...");
            return true;
        }
		throw new ExceptionAlreadyPlayed();
	}

     public boolean criarFilme(String name, double temp, String genre,int year, String nameCast){
        if(name != "" && temp != 0 && year != 0 && nameCast != "" && genre != ""){
            Video movie = new Movie(name, temp, genre, year, nameCast);
            this.midias.add(movie);
            this.cont++;
            return true;
        }else{
            return false;
        }
    }

    public boolean criarSerie(String name, String genre,int year, String nameCast) {
        if(name != "" && year != 0 && nameCast != "" && genre != ""){
            Video serie = new Serie(name, genre, year, nameCast);
            Serie serieCast = (Serie) serie;
            System.out.println("Deseja adicionar quantos episódios?");
            int op = (int) sc.nextInt();

            for(int i=0; i<op; i++){
                System.out.println("Digite o nome do episódio::");
                String nameEp = sc.next();
                System.out.println("Digite o tempo do episódio::");
                double temp = sc.nextDouble();
                serieCast.adicionarEpisodio(nameEp, temp);
            }

            this.midias.add(serie);
            this.cont++;
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