package basico;
import java.util.Scanner;

import basico.exception.ExceptionAlreadyPaused;
import basico.exception.ExceptionAlreadyPlayed;

public class Main {       
    
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws ExceptionAlreadyPlayed, ExceptionAlreadyPaused {
        int escolha = 0;
        PavaoPrime tela01 = new PavaoPrime();

        do {  
            System.out.println("Escolha uma opção");
            System.out.println("1- Criar Filme");
            System.out.println("2- Criar Série");
            System.out.println("3- Pausar");
            System.out.println("4- Play");
            System.out.println("5- Mostrar informações"); //->interface
            System.out.println("6- Encerrar");
            
            escolha = s.nextInt();

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
               

               // pausarFilme

            }else if(escolha == 4){

                System.out.println("Digite 1 para filmes e 2 para série:");
                int resposta = s.nextInt();

                if(resposta == 1){
                    System.out.println("Digite o nome do Filme");
                    String name = s.next();
                    tela01.playFilme(name);
                }else if(resposta == 2){
                    System.out.println("Digite o nome da Série");
                    String name = s.next();
                    tela01.playSerie(name);
                }

            }else if(escolha == 5){
                    
            }
        }while(escolha != 6);


    }
}
