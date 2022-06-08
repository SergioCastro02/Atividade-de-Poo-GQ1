package gui;
import java.util.Scanner;

import business.exceptions.VideoAlreadyPausedException;
import business.exceptions.VideoAlreadyPlayingException;
import business.interfaces.IFacadeVideo;
import business.FacadeVideo;

public class Main {       
    
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) throws VideoAlreadyPlayingException, VideoAlreadyPausedException, VideoAlreadyPausedException, VideoAlreadyPausedException {
        int option = 0;

        do {
            Menu menu = Menu.getMenu();

            System.out.println("Bem vindo(a)! Deseja navegar entre séries ou filmes?");
            System.out.println("1- Séries | 2-Filmes | 0-Sair do Programa");
            option = s.nextInt();

            IFacadeVideo facadeVideo = new FacadeVideo();

            switch(option){
                case 1://Séries
                    menu.exibirMenuSerie();
                    break;
                case 2://Filmes
                    menu.exibirMenuMovie();
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opcão inválida!");
            }  

        }while(option != 0);
    }
}
