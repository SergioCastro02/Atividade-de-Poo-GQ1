package basico.exception;

public class VideoNotFoundException extends Exception {
    public VideoNotFoundException(String string) {
        System.out.println(string);
    }
}
