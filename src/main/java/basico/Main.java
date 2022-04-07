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

        PavaoPrime tela1 = new PavaoPrime();

        if(escolha == 1){
            System.out.println("Digite o nome do filme");
            String name = s.next();
            System.out.println("Digite o tempo do filme");
            double time = s.nextDouble();
            System.out.println("Digite o gênero do filme");
            String genre = s.next();
            System.out.println("Digite o ano do filme");
            int year = s.nextInt();
            System.out.println("Digite o nome do elenco");
            String nameCast = s.next();
            tela1.criarFilme(name, time, genre, year, nameCast);
        }else if(escolha == 2){

        }else if(escolha == 3){

        }else if(escolha == 4){

        }


    }
}
