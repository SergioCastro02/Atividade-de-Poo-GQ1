package basico.exception;

public class VideoAlreadyPausedException extends Exception{
    public VideoAlreadyPausedException(){
        super("O vídeo já está pausado!");
    }
}
