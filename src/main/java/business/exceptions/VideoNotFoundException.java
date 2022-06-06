package business.exceptions;

public class VideoNotFoundException extends Exception {
    public VideoNotFoundException(String string) {
        System.out.println(string);
    }
}
