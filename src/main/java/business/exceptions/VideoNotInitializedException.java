package business.exceptions;

public class VideoNotInitializedException extends Exception{

    public VideoNotInitializedException(){
        super("Vídeo ainda não foi inicializado!!");
    }

}
