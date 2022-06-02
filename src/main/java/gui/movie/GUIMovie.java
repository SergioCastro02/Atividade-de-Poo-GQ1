package gui.movie;
import data.video.RepositorioVideo;
import gui.Main;
import basico.PavaoPrime;
import basico.exception.VideoAlreadyPausedException;
import basico.exception.VideoAlreadyPlayingException;
import basico.exception.VideoNotFoundException;

import java.util.Scanner;

public class GUIMovie extends Main {

    static Scanner s = new Scanner(System.in);
    static PavaoPrime tela01 = new PavaoPrime();
    static RepositorioVideo repositorioVideo;

    public static void menuMovie() throws VideoAlreadyPausedException, VideoAlreadyPlayingException, VideoAlreadyPausedException {
        System.out.println("1- Criar filme.");
        System.out.println("2- Dar play no filme.");
        System.out.println("3- Pausar filme.");
        System.out.println("4- Mostrar informações sobre todos os nossos filmes.");
        System.out.println("5- Mostrar informações sobre determinado filme.");
        System.out.println("0- Encerrar o programa.");

        int escolha = s.nextInt();

        switch(escolha){
                case 1://criar filme
                        System.out.println("Digite o nome do filme");
                        String name = s.next();
                        System.out.println("Digite o tempo do filme");
                        double time = s.nextDouble();
                        System.out.println("Digite o gênero do filme");
                        String genre = s.next();
                        System.out.println("Digite o ano do filme");
                        int year = s.nextInt();
                        System.out.println("Digite o nome do estúdio");
                        String nameCast = s.next();

                        repositorioVideo.createMovie(name, time, genre, year, nameCast);

                        System.out.println("Operação realizada.");

                    break;

                case 2://play filme

                    try{
                        System.out.println("Digite o nome do Video");
                        name = s.next();
                        repositorioVideo.play(name);
                    }catch(VideoAlreadyPlayingException | VideoNotFoundException videoAlreadyPlayingException){
                        videoAlreadyPlayingException.getMessage();
                    }finally{
                        System.out.println("Operação realizada.");
                    }
                    break;

                case 3://pausar filme
                    try{
                        System.out.println("Digite o nome do Video");
                        name = s.next();
                        repositorioVideo.pause(name);
                    }catch(VideoAlreadyPausedException | VideoNotFoundException videoAlreadyPausedException){
                        videoAlreadyPausedException.getMessage();
                    }finally{
                        System.out.println("Operação realizada.");
                    }
                    break;
                case 4:
                    System.out.println("Exibindo informações sobre nossos filmes do catálogo:");
                    repositorioVideo.showInformationsVideo();
                    break;
                case 5:
                    System.out.println("Digite o nome do Filme:");
                    name = s.next();
                    repositorioVideo.showInformationsVideoSpecified(name);
                    break;

                case 0:
                    System.out.println("Bye bye!!");

                default:
                    System.out.println("Opção inválida!");
            }
    }

}