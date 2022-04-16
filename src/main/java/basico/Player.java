package basico;
import basico.exception.VideoNotInitializedException;

public interface Player {

    boolean pass() throws VideoNotInitializedException;
    boolean back() throws VideoNotInitializedException;

}

