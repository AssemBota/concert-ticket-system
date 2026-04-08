import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Ticket {
    public int id;
    public String status;
    public Map<String, String> timestamps;

    public Ticket(int id) {
        this.id = id;
        this.status = "Reserved";

        timestamps = new HashMap<>();
        timestamps.put("Reserved", LocalDateTime.now().toString());
    }
}