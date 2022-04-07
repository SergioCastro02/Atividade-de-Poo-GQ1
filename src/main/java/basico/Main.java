package basico;
import java.util.Scanner;

public class Main {       
    
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Escolha uma opção");
        System.out.println("1- Criar Filme");
        System.out.println("2- Criar Série");
        System.out.println("3- Pausar");
        System.out.println("4- Play");
        System.out.println("4- Mostrar informações"); //->interface
        int escolha = s.nextInt();

        PavaoPrime tela01 = new PavaoPrime();

        if(escolha == 1){
            System.out.println("Digite o nome do filme");
            String name = s.next();
            System.out.println("Digite o tempo do filme");
            double time = s.nextDouble();
            System.out.println("Digite o gênero do filme");
            String genre = s.next();
            System.out.println("Digite o ano do filme");
            int year = s.nextInt();
            System.out.println("Digite os nomes do elenco");
            String nameCast = s.next();
            tela01.criarFilme(name, time, genre, year, nameCast);

        }else if(escolha == 2){
            System.out.println("Digite o nome da série");
            String name = s.next();
            System.out.println("Digite o tempo da série");
            double time = s.nextDouble();
            System.out.println("Digite o gênero da série");
            String genre = s.next();
            System.out.println("Digite o ano da série");
            int year = s.nextInt();
            System.out.println("Digite os nomes do elenco");
            String nameCast = s.next();
            tela01.criarSerie(name, time, genre, year, nameCast);

        }else if(escolha == 3){
          // .play();
        }else if(escolha == 4){
            //.pause();
        }


    }
}
