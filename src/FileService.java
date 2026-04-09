import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private static final String FILE_NAME = "tickets.json";
    private Gson gson = new Gson();


    public List<Ticket> load() {
        try (Reader reader = new FileReader(FILE_NAME)) {

            Type listType = new TypeToken<List<Ticket>>() {}.getType();
            List<Ticket> tickets = gson.fromJson(reader, listType);

            if (tickets == null) return new ArrayList<>();

            return tickets;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    public void save(List<Ticket> tickets) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(tickets, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
