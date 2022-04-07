package basico.exception;

public class ExceptionAlreadyPaused extends Exception{
    public ExceptionAlreadyPaused(){
        super("O vídeo já está pausado!");
    }
}
