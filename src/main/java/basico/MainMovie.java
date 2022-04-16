package basico;
import basico.exception.VideoAlreadyPausedException;
import basico.exception.VideoAlreadyPlayingException;
import basico.exception.VideoNotInitializedException;
import java.util.Scanner;

public class MainMovie extends Main{

    static Scanner in = new Scanner(System.in);
    static PavaoPrime tela01 = new PavaoPrime();
    double time;
    int year;

    public static void menuMovie() throws VideoAlreadyPausedException, VideoAlreadyPlayingException, VideoAlreadyPausedException {
        System.out.println("1- Criar filme.");
        System.out.println("2- Dar play no filme.");
        System.out.println("3- Pausar filme.");
        System.out.println("4- Avançar 15s no filme.");
        System.out.println("5- Mostrar informações sobre determinado filme.");
        System.out.println("0- Encerrar o programa.");

        int escolha = s.nextInt();

        switch(escolha){
                case 1://criar filme
                    try{
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

                        tela01.criarFilme(name, time, genre, year, nameCast);

                    }catch (VideoNotInitializedException videoNotInitializedException){
                        System.out.println(videoNotInitializedException.getMessage());
                    }finally {
                        System.out.println("Filme criado com sucesso!");
                    }
                    break;

                case 2://play filme
                    try{
                        System.out.println("Digite o nome do Video");
                        String name = s.next();
                        tela01.play(name);
                    }catch(VideoAlreadyPlayingException videoAlreadyPlayingException){
                        videoAlreadyPlayingException.getMessage();
                    }finally{
                        System.out.println("Filme tocando...");
                    }
                    break;

                case 3://pausar filme
                    try{
                        System.out.println("Digite o nome do Video");
                        String name = s.next();
                        tela01.pause(name);
                    }catch(VideoAlreadyPausedException videoAlreadyPausedException){
                        videoAlreadyPausedException.getMessage();
                    }finally{
                        System.out.println("Filme pausado.");
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
                    System.out.println("Exibindo informações sobre nossos filmes do catálogo:");
                    tela01.mostrarInformacoes();
                    break;

                case 0:
                    System.out.println("Bye bye!!");

                default:
                    System.out.println("Opção inválida!");
            }
    }

}
