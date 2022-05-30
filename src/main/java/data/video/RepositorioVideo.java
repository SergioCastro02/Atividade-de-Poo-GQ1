package data.video;

import basico.exception.VideoAlreadyPausedException;
import basico.exception.VideoAlreadyPlayingException;
import basico.exception.VideoNotFoundException;
import basico.video.Episode;
import basico.video.Movie;
import basico.video.Serie;
import basico.video.Video;
import data.IRepositorioVideo;

import java.util.ArrayList;
import java.util.Scanner;

public class RepositorioVideo implements IRepositorioVideo {
    static Scanner sc = new Scanner(System.in);

    private ArrayList<Video> midias;
    private int cont = 0;

    public RepositorioVideo(){
        this.midias = new ArrayList<>();
    }

    @Override
    public boolean createMovie(String name, double temp, String genre, int year, String nameCast) {
        if(name != "" && temp != 0 && year != 0 && nameCast != "" && genre != ""){
            Video movie = new Movie(name, temp, genre, year, nameCast);
            this.midias.add(movie);
            this.cont++;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean createSerie(String name, String genre, int year, String nameCast) {
        if(name != "" && year != 0 && nameCast != "" && genre != ""){
            Serie serie = new Serie(name, genre, year, nameCast);
            Serie serieCast = serie;
            System.out.println("Deseja adicionar quantos episódios?");
            int op = sc.nextInt();

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

    @Override
    public void showInformationsVideo() {
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

    @Override
    public Video find(String name) {
        Video retorno = null;
        for(Video midia: this.midias){
            if (midia.getName().equals(name)){
                retorno = midia;
            }
        }
        return retorno;
    }

    @Override
    public boolean pause(String name) throws VideoAlreadyPausedException, VideoNotFoundException {
        Video found = find(name);

        if(found == null){
            throw new VideoNotFoundException("Vídeo não encontrado...");
        }else{
            if(found.getPlaying()){
                found.setPlaying(false);
                return true;
            }else{
                throw new VideoAlreadyPausedException("Vídeo já está tocando...");
            }
        }
    }

    @Override
    public boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException {
        Video busca = find(name);

        if (busca == null) {
            throw new VideoNotFoundException("Vídeo não encontrado...");
        } else {
            if (!busca.getPlaying()) {
                busca.setPlaying(true);
                return true;
            }
        }
        throw new VideoAlreadyPlayingException("O vídeo já está tocando!");
    }

    @Override
    public int getVideos() {
        return this.midias.size();
    }
}
