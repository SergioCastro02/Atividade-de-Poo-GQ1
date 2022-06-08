package data.video;

import business.entity.Episode;
import business.entity.Movie;
import business.entity.Serie;
import business.entity.Video;
import business.exceptions.*;
import business.threads.ThreadAdvance;
import business.threads.ThreadPlay;
import data.IRepositoryVideo;

import java.util.ArrayList;
import java.util.Scanner;

public class RepositoryVideo implements IRepositoryVideo {
    static Scanner sc = new Scanner(System.in);

    private ArrayList<Video> midias;
    private int count = 0;
    private double timing;

    public RepositoryVideo(){
        this.midias = new ArrayList<>();
    }

    @Override
    public boolean createMovie(String name, int temp, String genre, int year, String nameCast) {
        if(!name.equals("") && !nameCast.equals("") && !genre.equals("") && temp != 0 && year != 0){
            Video movie = new Movie(name, temp, genre, year, nameCast);
            this.midias.add(movie);
            this.count++;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean createSerie(String name, String genre, int year, String nameCast) {
        if(!name.equals("") && !nameCast.equals("") && !genre.equals("") && year != 0 ){
            Serie serie = new Serie(name, genre, year, nameCast);
            System.out.println("Deseja adicionar quantos episódios?");
            int op = sc.nextInt();

            for(int i=0; i<op; i++){
                System.out.println("Digite o nome do episódio::");
                String nameEp = sc.next();
                System.out.println("Digite o tempo do episódio::");
                int temp = sc.nextInt();
                serie.addEpisode(nameEp, temp);
            }
            this.midias.add(serie);
            this.count++;
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
                String returnInformation = "Série: " + found.getName() + ",\n Gênero: " + found.getGenre() +
                        "\n Ano: " + found.getYear() + ",\n Nome do estúdio: " + found.getNameCast();

                returnInformation += "\nEpisódios:";
                for(Episode episode : ((Serie) found).getEpisodes()){
                    returnInformation += "\nTítulo:" + episode.getTitulo() +
                            "\nTempo:" + episode.getTime() + "\n";
                }
                System.out.println(returnInformation);
            }
        }
    }

    @Override
    public void showInformationsVideo() {
        if(this.midias.size() > 0){
            midias.stream().filter(midia -> midia instanceof Serie).forEach(midia -> ((Serie) midia).showInformations());
            midias.stream().filter(midia -> midia instanceof Movie).forEach(midia -> ((Movie) midia).showInformations());
        }else{
            System.out.println("Lista de vídeos vazia!!");
        }
    }

    @Override
    public Video find(String name) {
        Video returnName = null;
        for(Video midia: this.midias){
            if (midia.getName().equals(name)){
                returnName = midia;
            }
        }
        return returnName;
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
    public boolean play(String name) throws VideoAlreadyPlayingException, VideoNotFoundException, EpisodeNotFoundException, ListOfEpisodesEmptyException {
        Video search = find(name);
        boolean isSerie = search instanceof Serie;
        if(isSerie){
            search = ((Serie) search).searchEpisode(name);
        }
        if (search == null) {
            throw new VideoNotFoundException("Vídeo não encontrado...");
        } else {
            if (!search.getPlaying()) {
                search.setPlaying(true);
                ThreadPlay threadAdvance = new ThreadPlay("Tocando",search.getTime());
                Thread threadAdvanceRun = new Thread(threadAdvance);

                threadAdvanceRun.start();

                while(threadAdvanceRun.isAlive()){
                    try{
                        threadAdvanceRun.join(200);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
                return true;
            }
        }
        throw new VideoAlreadyPlayingException("O vídeo já está tocando!");
    }

    @Override
    public void advance(String name) throws VideoAlreadyFinishedException, VideoNotFoundException, EpisodeCantAdvanceException {

        Video search = find(name);

        boolean isSerie = search instanceof Serie;

        if(isSerie){
            throw new EpisodeCantAdvanceException("No momento não podemos avançar um episódio... Tente novamente mais tarde.");
        }
        if (search == null) {
            throw new VideoNotFoundException("Vídeo não encontrado...");
        }else{
            double timeAcresc = this.timing += 10;

            if(timeAcresc < search.getTime()){
                ThreadAdvance threadAdvance = new ThreadAdvance("Avançando",500);
                Thread threadAdvanceRun = new Thread(threadAdvance);

                threadAdvanceRun.start();

                while(threadAdvanceRun.isAlive()){
                    try{
                        threadAdvanceRun.join(200);
                    }catch (InterruptedException e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Programa finalizado");
                /*
                new Thread() {
                    double timing = 10;
                    @Override
                    public void run() {
                        try {
                            for(double time=search.getTime(); time>=timing; time--) {
                                System.out.println(time);
                                Thread.sleep(1000);
                            }

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Filme avançado 10s..");
                    }
                }.start();
                 */

            }else{
                throw new VideoAlreadyFinishedException("Vídeo finalizado..");
            }
        }
    }

    @Override
    public void back(String name) throws VideoAlreadyFinishedException {

    }

    @Override
    public int getVideos() {
        return this.midias.size();
    }
}
