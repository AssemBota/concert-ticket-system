import java.util.HashMap;
import java.util.Map;

public class CacheService {

    private Map<Integer, Ticket> cache = new HashMap<>();

    public Ticket get(int id) {
        if (cache.containsKey(id)) {
            System.out.println("From cache");
            return cache.get(id);
        }
        return null;
    }

    public void put(Ticket ticket) {
        cache.put(ticket.id, ticket);
    }
}