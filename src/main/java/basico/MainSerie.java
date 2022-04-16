package basico;
import basico.exception.VideoAlreadyPausedException;
import basico.exception.VideoAlreadyPlayingException;
import basico.exception.VideoNotInitializedException;

import java.util.Scanner;

public class MainSerie extends Main {
    static Scanner in = new Scanner(System.in);
    static PavaoPrime tela01 = new PavaoPrime();

    public static void menuSerie() throws VideoAlreadyPausedException, VideoAlreadyPlayingException, VideoAlreadyPausedException, VideoNotInitializedException{
        System.out.println("1- Criar série.");
        System.out.println("2- Dar play na série.");
        System.out.println("3- Pausar série.");
        System.out.println("4- Avançar 15s no episódio.");
        System.out.println("5- Mostrar informações sobre determinada série.");
        System.out.println("6- Encerrar o programa.");

        int escolha = s.nextInt();

        switch(escolha){
            case 1://criar série
                try{
                    System.out.println("Digite o nome da série");
                    String name = s.next();
                    System.out.println("Digite o gênero da série");
                    String genre = s.next();
                    System.out.println("Digite o ano da série");
                    int year = s.nextInt();
                    System.out.println("Digite o nome do estúdio");
                    String nameCast = s.next();

                    tela01.criarSerie(name, genre, year, nameCast);

                }catch (VideoNotInitializedException videoNotInitializedException){
                    System.out.println(videoNotInitializedException.getMessage());
                }finally {
                    System.out.println("Série criada com sucesso!");
                }
                break;

            case 2://play série(episódio)
                try{
                    System.out.println("Digite o nome do Episódio");
                    String name = s.next();
                    tela01.play(name);
                }catch(VideoAlreadyPlayingException videoAlreadyPlayingException){
                    videoAlreadyPlayingException.getMessage();
                }finally{
                    System.out.println("Série tocando...");
                }
                break;

            case 3://pausar série
                try{
                    System.out.println("Digite o nome do Video");
                    String name = s.next();
                    tela01.pause(name);
                }catch(VideoAlreadyPausedException videoAlreadyPausedException){
                    videoAlreadyPausedException.getMessage();
                }finally{
                    System.out.println("Série pausada.");
                }
                break;

            case 4://avançar filme
                    /* à ser implementado
                    try{

                    }catch(){

                    }finally{
                    }
                     */
                break;

            case 5:
                System.out.println("Exibindo informações sobre nossas séries do catálogo:");
                tela01.mostrarInformacoes();
                break;

            case 0:
                System.out.println("Bye bye!!");

            default:
                System.out.println("Opção inválida!");
        }
    }
}
