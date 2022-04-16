package basico.exception;

public class VideoAlreadyPlayingException extends Exception{
    public VideoAlreadyPlayingException(){
        super("O vídeo já está tocando!");
    }
}
