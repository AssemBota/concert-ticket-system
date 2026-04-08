import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketStorage {
    private static final String FILE_NAME = "tickets.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Ticket> loadTickets() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(file, new TypeReference<List<Ticket>>() {});
        } catch (IOException e) {
            System.out.println("Error loading tickets: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveTickets(List<Ticket> tickets) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_NAME), tickets);
        } catch (IOException e) {
            System.out.println("Error saving tickets: " + e.getMessage());
        }
    }
}