package basico;
import java.util.Scanner;

import basico.exception.ExceptionAlreadyPaused;
import basico.exception.ExceptionAlreadyPlayed;

public class Main {       
    
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws ExceptionAlreadyPlayed, ExceptionAlreadyPaused {
        int escolha = 0;
        PavaoPrime tela01 = new PavaoPrime();
        String name, genre, nameCast;
        double time;
        int year;

        do {  
            menu();
            escolha = s.nextInt();

            switch(escolha){
                case 1:
                    System.out.println("Digite o nome do filme");
                    name = s.next();
                    //System.out.println("");

                    System.out.println("Digite o tempo do filme");
                    time = s.nextDouble();
                    System.out.println("Digite o gênero do filme");
                    genre = s.next();
                    //System.out.println("");
                    System.out.println("Digite o ano do filme");
                    year = s.nextInt();
                    System.out.println("Digite o nome do estúdio");
                    nameCast = s.next();
                    //System.out.println("");
                    tela01.criarFilme(name, time, genre, year, nameCast);
                    break;
                case 2:
                    System.out.println("Digite o nome da série");
                    name = s.next();
                    //System.out.println("");
                    System.out.println("Digite o tempo da série");
                    time = s.nextDouble();
                    System.out.println("Digite o gênero da série");
                    genre = s.next();
                    //System.out.println("");
                    System.out.println("Digite o ano da série");
                    year = s.nextInt();
                    System.out.println("Digite o nome do estúdio");
                    nameCast = s.next();
                    //System.out.println("");
                    tela01.criarSerie(name, genre, year, nameCast);
                    break;
                case 3:
                    System.out.println("Digite o nome do Video");
                    name = s.next();
                    //System.out.println("");
                    tela01.pause(name);                
                    break;
                 case 4:                        
                    System.out.println("Digite o nome do Video");
                    name = s.next();
                    //System.out.println("");
                    tela01.play(name);                
                    break;
                case 5:
                    tela01.mostrarInformacoes();
                    break;
                case 6:
                    System.out.println("Código encerrado!");
                    break;
                default:
                    System.out.println("Opcão errada!");
            }  

        }while(escolha != 6);
    }

    public static void menu(){
            System.out.println("Escolha uma opção");
            System.out.println("1- Criar Filme");
            System.out.println("2- Criar Série");
            System.out.println("3- Pausar");
            System.out.println("4- Play");
            System.out.println("5- Mostrar informações");
            System.out.println("6- Encerrar");

    }
}
