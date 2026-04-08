import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoggerService {

    public void log(String message) {
        try (FileWriter fw = new FileWriter("log.txt", true)) {
            fw.write(LocalDateTime.now() + " - " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}