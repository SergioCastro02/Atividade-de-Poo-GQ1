package business.exceptions;

public class VideoAlreadyFinishedException extends Exception{
    public VideoAlreadyFinishedException(String message){
        super(message);
    }
}
