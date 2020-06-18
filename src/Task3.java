import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Task3 {
    public static void main(String[] args) throws Exception {
        try {

            catchMe();
        } catch (NullPointerException | FileNotFoundException e) {

        }
    }

    public static void catchMe() throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException {
        int i = (int) (Math.random() * 4);
        if (i == 0) {
            throw new NullPointerException();
        } else if (i == 1) {
            throw new ArithmeticException();
        } else if (i == 2) {
            throw new FileNotFoundException();
        } else if (i == 3) {
            throw new URISyntaxException("", "");
        }
    }

}