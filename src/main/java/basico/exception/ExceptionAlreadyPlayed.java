package basico.exception;

public class ExceptionAlreadyPlayed extends Exception{
    public ExceptionAlreadyPlayed(){
        super("O vídeo já está tocando!");
    }
}
