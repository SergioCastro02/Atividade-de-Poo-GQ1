package business.exceptions;

public class VideoFinishException extends Exception{
    public VideoFinishException(){
        super("O Vídeo está finalizado!");
    }
}
