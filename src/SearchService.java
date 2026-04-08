import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    public Ticket findById(List<Ticket> tickets, int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public List<Ticket> filterByStatus(List<Ticket> tickets, String status) {
        return tickets.stream()
                .filter(ticket -> ticket.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}