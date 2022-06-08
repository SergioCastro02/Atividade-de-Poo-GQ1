package business.exceptions;

public class VideoAlreadyFinishedException extends Exception{
    VideoAlreadyFinishedException(String message){
        super(message);
    }
}
