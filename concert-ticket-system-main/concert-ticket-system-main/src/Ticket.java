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

    public int getId() {
        return id;
    }
   
    public String getStatus() {
        return status;
    }

    public Map<String, String> getTimestamps() {
        return timestamps;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTimestamps(Map<String, String> timestamps) {
        this.timestamps = timestamps;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", timestamps=" + timestamps +
                '}';
    } 
}