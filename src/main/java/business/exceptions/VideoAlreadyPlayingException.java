package business.exceptions;

public class VideoAlreadyPlayingException extends Exception{
    public VideoAlreadyPlayingException(String string){
        System.out.println(string);
    }
}
