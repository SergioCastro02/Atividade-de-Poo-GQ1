package gui.serie;
import business.entity.Serie;
import business.exceptions.*;
import business.FacadeVideo;
import gui.Main;

import java.util.Scanner;

public class GUISerie extends Main {

    static Scanner s = new Scanner(System.in);
    static FacadeVideo facadeVideo = new FacadeVideo();

    public static void menuSerie() throws CantCreateSerieException {
        System.out.println("1- Criar série.");
        System.out.println("2- Dar play na série.");
        System.out.println("3- Pausar série.");
        System.out.println("4- Avançar 10s no episódio.");
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

                    try{
                        facadeVideo.createSerie(name, genre, year, nameCast);
                    }catch (CantCreateSerieException e){
                        System.out.println(e.getMessage());
                    }finally {
                        System.out.println("Operação realizada.");
                    }

                    System.out.println("Operação realizada.");
                break;

            case 2://play série(episódio)
                try{
                    System.out.println("Digite o nome da série:");
                    name = s.next();
                    facadeVideo.play(name);
                }catch(VideoAlreadyPlayingException | VideoNotFoundException | EpisodeNotFoundException | ListOfEpisodesEmptyException videoAlreadyPlayingException){
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
                } catch (ListOfEpisodesEmptyException e) {
                    e.printStackTrace();
                } catch (EpisodeNotFoundException e) {
                    e.printStackTrace();
                } finally{
                    System.out.println("Operação realizada.");
                }
                break;
            case 4:
                try {
                    System.out.println("Digite o nome da série");
                    name = s.next();
                    facadeVideo.advance(name);

                }catch (VideoNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (VideoAlreadyFinishedException e) {
                    System.out.println(e.getMessage());
                } catch (EpisodeNotFoundException e) {
                    e.printStackTrace();
                } catch (ListOfEpisodesEmptyException listOfEpisodesEmptyException) {
                    listOfEpisodesEmptyException.printStackTrace();
                } finally {
                    System.out.println("Operação realizada.");
                }
                break;
            case 5:
                try {
                    System.out.println("Digite o nome da série");
                    name = s.next();
                    facadeVideo.back(name);
                }catch (VideoNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (VideoAlreadyFinishedException e) {
                    System.out.println(e.getMessage());
                }catch (ListOfEpisodesEmptyException e) {
                    e.printStackTrace();
                } catch (EpisodeNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Operação realizada.");
                }
                break;

            case 6:
                System.out.println("Exibindo informações sobre nossas séries do catálogo:");
                facadeVideo.showInformationsVideo();
                break;
            case 7:
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
