package gui.movie;
import business.FacadeVideo;
import gui.Main;
import business.exceptions.*;
import business.exceptions.VideoNotFoundException;

import java.util.Scanner;

public class GUIMovie extends Main {

    static Scanner s = new Scanner(System.in);
    static FacadeVideo facadeVideo = new FacadeVideo();

    public static void menuMovie() throws VideoAlreadyPausedException, VideoAlreadyPlayingException, VideoAlreadyPausedException {
        System.out.println("1- Criar filme.");
        System.out.println("2- Dar play no filme.");
        System.out.println("3- Pausar filme.");
        System.out.println("4- Avançar filme.");
        System.out.println("5- Mostrar informações sobre todos os nossos filmes.");
        System.out.println("6- Mostrar informações sobre determinado filme.");
        System.out.println("0- Encerrar o programa.");

        int escolha = s.nextInt();

        switch(escolha){
                case 1://criar filme
                        System.out.println("Digite o nome do filme");
                        String name = s.next();
                        System.out.println("Digite o tempo do filme");
                        int time = s.nextInt();
                        System.out.println("Digite o gênero do filme");
                        String genre = s.next();
                        System.out.println("Digite o ano do filme");
                        int year = s.nextInt();
                        System.out.println("Digite o nome do estúdio");
                        String nameCast = s.next();

                        facadeVideo.createMovie(name, time, genre, year, nameCast);

                        System.out.println("Operação realizada.");

                    break;

                case 2://play filme

                    try{
                        System.out.println("Digite o nome do Video");
                        name = s.next();
                        facadeVideo.play(name);
                    }catch(VideoNotFoundException | EpisodeNotFoundException | EpisodeCantAdvanceException | ListOfEpisodesEmptyException videoAlreadyPlayingException){
                        videoAlreadyPlayingException.getMessage();
                    }finally{
                        System.out.println("Operação realizada.");
                    }
                    break;

                case 3://pausar filme
                    try{
                        System.out.println("Digite o nome do Video");
                        name = s.next();
                        facadeVideo.pause(name);
                    }catch(VideoAlreadyPausedException | VideoNotFoundException videoAlreadyPausedException){
                        videoAlreadyPausedException.getMessage();
                    }finally{
                        System.out.println("Operação realizada.");
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Digite o nome do filme");
                        name = s.next();
                        facadeVideo.advance(name);
                    }catch (VideoNotFoundException e) {
                        System.out.println(e.getMessage());
                    } catch (VideoAlreadyFinishedException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("Operação realizada.");
                    }
                    break;
                case 5:
                    System.out.println("Exibindo informações sobre nossos filmes do catálogo:");
                    facadeVideo.showInformationsVideo();
                    break;
                case 6:
                    System.out.println("Digite o nome do Filme:");
                    name = s.next();
                    facadeVideo.showInformationsVideoSpecified(name);
                    break;
                case 0:
                    System.out.println("Bye bye!!");

                default:
                    System.out.println("Opção inválida!");
            }
    }

}
