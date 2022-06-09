package business.exceptions;

public class CantCreateMovieException extends Exception{
    public CantCreateMovieException(String message){
        super(message);
    }
}
