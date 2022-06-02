package gui.serie;
import basico.PavaoPrime;
import basico.exception.VideoAlreadyPausedException;
import basico.exception.VideoAlreadyPlayingException;
import basico.exception.VideoNotFoundException;
import basico.exception.VideoNotInitializedException;
import data.video.RepositorioVideo;
import gui.Main;

import java.util.Scanner;

public class GUISerie extends Main {
    static Scanner s = new Scanner(System.in);
    static PavaoPrime tela01 = new PavaoPrime();
    static RepositorioVideo repositorioVideo;

    public static void menuSerie(){
        System.out.println("1- Criar série.");
        System.out.println("2- Dar play na série.");
        System.out.println("3- Pausar série.");
        System.out.println("4- Mostrar informações sobre as nossas séries.");
        System.out.println("5- Mostrar informações sobre uma série específica.");
        System.out.println("0- Encerrar o programa.");

        int escolha = s.nextInt();

        switch(escolha){
            case 1://criar série
                    System.out.println("Digite o nome da série:");
                    String name = s.next();
                    System.out.println("Digite o gênero da série:");
                    String genre = s.next();
                    System.out.println("Digite o ano da série:");
                    int year = s.nextInt();
                    System.out.println("Digite o nome do estúdio:");
                    String nameCast = s.next();

                    repositorioVideo.createSerie(name, genre, year, nameCast);

                    System.out.println("Operação realizada.");
                break;

            case 2://play série(episódio)
                try{
                    System.out.println("Digite o nome da série:");
                    name = s.next();
                    repositorioVideo.play(name);
                }catch(VideoAlreadyPlayingException | VideoNotFoundException videoAlreadyPlayingException){
                    videoAlreadyPlayingException.getMessage();
                }finally{
                    System.out.println("Operação realizada.");
                }
                break;

            case 3://pausar série
                try{
                    System.out.println("Digite o nome da série:");
                    name = s.next();
                    repositorioVideo.pause(name);
                }catch(VideoAlreadyPausedException | VideoNotFoundException videoAlreadyPausedException){
                    videoAlreadyPausedException.getMessage();
                }finally{
                    System.out.println("Operação realizada.");
                }
                break;
            case 4:
                System.out.println("Exibindo informações sobre nossas séries do catálogo:");

                repositorioVideo.showInformationsVideo();
                break;
            case 5:
                System.out.println("Digite o nome da série:");
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
