package business.exceptions;

public class VideoAlreadyPausedException extends Exception{
    public VideoAlreadyPausedException(String string) {
        System.out.println(string);
    }
}
