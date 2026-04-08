import java.util.HashMap;
import java.util.Map;

public class TicketCache {
    private final Map<Integer, Ticket> cache = new HashMap<>();

    public Ticket get(int id) {
        return cache.get(id);
    }

    public void put(Ticket ticket) {
        cache.put(ticket.getId(), ticket);
    }

    public boolean contains(int id) {
        return cache.containsKey(id);
    }

    public void remove(int id) {
        cache.remove(id);
    }

    public void clear() {
        cache.clear();
    }
}