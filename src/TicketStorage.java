import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TicketStorage {
    private static final String FILE_NAME = "tickets.json";

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Ticket> loadTickets() {
        try (Reader reader = new FileReader(FILE_NAME)) {

            Type listType = new TypeToken<List<Ticket>>() {}.getType();
            List<Ticket> tickets = gson.fromJson(reader, listType);

            return tickets != null ? tickets : new ArrayList<>();

        } catch (FileNotFoundException e) {
            return new ArrayList<>();

        } catch (IOException e) {
            System.out.println("Error loading tickets: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveTickets(List<Ticket> tickets) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tickets, writer);
        } catch (IOException e) {
            System.out.println("Error saving tickets: " + e.getMessage());
        }
    }
}