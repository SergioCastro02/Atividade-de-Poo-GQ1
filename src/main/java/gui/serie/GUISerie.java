package gui.serie;
import business.entity.Serie;
import business.exceptions.*;
import business.FacadeVideo;
import gui.Main;

import java.util.Scanner;

public class GUISerie extends Main {

    static Scanner s = new Scanner(System.in);
    static FacadeVideo facadeVideo = new FacadeVideo();

    public static void menuSerie(){
        System.out.println("1- Criar série.");
        System.out.println("2- Dar play na série.");
        System.out.println("3- Pausar série.");
        System.out.println("4- Avançar Série.");
        System.out.println("5- Mostrar informações sobre as nossas séries.");
        System.out.println("6- Mostrar informações sobre uma série específica.");
        System.out.println("0- Encerrar o programa.");

        int option = s.nextInt();

        switch(option){
            case 1://criar série
                    System.out.println("Digite o nome da série:");
                    String name = s.next();
                    System.out.println("Digite o gênero da série:");
                    String genre = s.next();
                    System.out.println("Digite o ano da série:");
                    int year = s.nextInt();
                    System.out.println("Digite o nome do estúdio:");
                    String nameCast = s.next();

                    facadeVideo.createSerie(name, genre, year, nameCast);

                    System.out.println("Operação realizada.");
                break;

            case 2://play série(episódio)
                try{
                    System.out.println("Digite o nome da série:");
                    name = s.next();
                    facadeVideo.play(name);
                }catch(VideoAlreadyPlayingException | VideoNotFoundException | EpisodeNotFoundException | ListOfEpisodesEmpty videoAlreadyPlayingException){
                    videoAlreadyPlayingException.getMessage();
                }finally{
                    System.out.println("Operação realizada.");
                }
                break;

            case 3://pausar série
                try{
                    System.out.println("Digite o nome da série:");
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
                    System.out.println("Digite o nome da série");
                    name = s.next();
                    Serie serie = new Serie(name);
                    System.out.println("Agora digite o nome do episódio");
                    String nameEpisode = s.next();
                    serie.searchEpisode(nameEpisode);

                    facadeVideo.advance(name);

                }catch (VideoNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (VideoAlreadyFinishedException e) {
                    System.out.println(e.getMessage());
                } catch (EpisodeNotFoundException e) {
                    e.printStackTrace();
                } catch (ListOfEpisodesEmpty listOfEpisodesEmpty) {
                    listOfEpisodesEmpty.printStackTrace();
                } finally {
                    System.out.println("Operação realizada.");
                }
                break;
            case 5:
                System.out.println("Exibindo informações sobre nossas séries do catálogo:");
                facadeVideo.showInformationsVideo();
                break;
            case 6:
                System.out.println("Digite o nome da série:");
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
