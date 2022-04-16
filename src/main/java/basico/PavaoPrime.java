package basico;
import java.util.ArrayList;
import java.util.Scanner;
import basico.exception.VideoAlreadyPausedException;
import basico.exception.VideoAlreadyPlayingException;
import basico.exception.VideoNotInitializedException;
import basico.video.Movie;
import basico.video.Serie;
import basico.video.Video;

public class PavaoPrime implements Info{
    static Scanner sc = new Scanner(System.in);

    private ArrayList<Video> midias;
	private int cont = 0;

    public PavaoPrime() {
        this.midias = new ArrayList<Video>();
		this.cont = 0;
    }

    public void mostrarInformacoes(){

        if(this.getVideos() > 0){
            for(Video midia: this.midias){
                System.out.println(midia.toString());
            }
        }else{
            System.out.println("Lista de vídeos vazia!!");
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

    public boolean pause(String name) throws VideoAlreadyPausedException {
        Video busca = buscar(name);

        if(busca == null){
            return false;
        }else{
            if(busca.getPlaying() == true){
                busca.setPlaying(false);
                return true;
            }else{
                throw new VideoAlreadyPausedException();
            }
        }
	}

    public boolean play(String name) throws VideoAlreadyPlayingException {
        Video busca = buscar(name);

        if (busca == null) {
            return false;
        } else {
            if (busca.getPlaying() == false) {
                busca.setPlaying(true);
                return true;
            }
            throw new VideoAlreadyPlayingException();
        }
    }

     public boolean criarFilme(String name, double temp, String genre,int year, String nameCast) throws VideoNotInitializedException {
        if(name != "" && temp != 0 && year != 0 && nameCast != "" && genre != ""){
            Video movie = new Movie(name, temp, genre, year, nameCast);
            this.midias.add(movie);
            this.cont++;
            return true;
        }else{
            return false;
        }
    }

    public boolean criarSerie(String name, String genre,int year, String nameCast) throws VideoNotInitializedException{
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