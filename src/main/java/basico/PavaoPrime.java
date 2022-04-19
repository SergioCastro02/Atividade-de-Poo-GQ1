package basico;
import java.util.ArrayList;
import java.util.Scanner;
import basico.exception.VideoAlreadyPausedException;
import basico.exception.VideoAlreadyPlayingException;
import basico.exception.VideoNotFoundException;
import basico.exception.VideoNotInitializedException;
import basico.video.*;

public class PavaoPrime implements GetVideo {
    static Scanner sc = new Scanner(System.in);

    private ArrayList<Video> midias;
	private int cont = 0;

    public PavaoPrime() {
        this.midias = new ArrayList<Video>();
		this.cont = 0;
    }

    public void showInformationsVideo(){
        if(this.getVideos() > 0){
            for(Video midia: this.midias){
                if(midia instanceof Movie){
                    ((Movie) midia).showInformations();
                }else if(midia instanceof Serie){
                    ((Serie) midia).showInformations();
                }
            }
        }else{
            System.out.println("Lista de vídeos vazia!!");
        }
    }

    public void showInformationsVideoSpecified(String name) {
        Video found = find(name);
        if(found == null){
            System.out.println("Vídeo não encontrado");
        }else{
            if(found instanceof Movie){
                System.out.println( "Filme: " + found.getName() +"\n"
                        + " Genero do filme:" + found.getGenre() +"\n"
                        + " Ano do filme:" + found.getYear() +"\n"
                        + " Nome do estúdio" + found.getNameCast() +"\n");
            }else if(found instanceof Serie){
                String retorno = "Série: " + found.getName() + ",\n Gênero: " + found.getGenre() +
                        "\n Ano: " + found.getYear() + ",\n Nome do estúdio: " + found.getNameCast();

                retorno += "\nEpisódios:";
                for(Episode episode : ((Serie) found).getEpisodes()){
                    retorno += "\nTítulo:" + episode.getTitulo() +
                            "\nTempo:" + episode.getTime() + "\n";
                }
                System.out.println(retorno);
            }
        }
    }

    public Video find(String name){
        Video retorno = null;
        for(Video midia: this.midias){
			if (midia.getName().equals(name)){
                retorno = midia;
            }
        }
        return retorno;
    }

    public boolean pause(String name) throws VideoAlreadyPausedException, VideoNotFoundException {
        Video found = find(name);

        if(found == null){
            throw new VideoNotFoundException("Vídeo não encontrado...");
        }else{
            if(found.getPlaying() == true){
                found.setPlaying(false);
                return true;
            }else{
                throw new VideoAlreadyPausedException("Vídeo já está tocando...");
            }
        }
	}

    public boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException {
        Video busca = find(name);

        if (busca == null) {
            throw new VideoNotFoundException("Vídeo não encontrado...");
        } else {
            if (busca.getPlaying() == false) {
                busca.setPlaying(true);
                return true;
            }
        }
        throw new VideoAlreadyPlayingException("O vídeo já está tocando!");
    }

     public boolean createMovie(String name, double temp, String genre,int year, String nameCast) {
        if(name != "" && temp != 0 && year != 0 && nameCast != "" && genre != ""){
            Video movie = new Movie(name, temp, genre, year, nameCast);
            this.midias.add(movie);
            this.cont++;
            return true;
        }else{
            return false;
        }
    }

    public boolean createSerie(String name, String genre,int year, String nameCast){
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
                serieCast.addEpisode(nameEp, temp);
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