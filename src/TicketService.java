import java.time.LocalDateTime;

public class TicketService {

    public boolean isValidTransition(String current, String next) {
        if (current.equals("Reserved") && next.equals("Paid")) return true;
        if (current.equals("Paid") && next.equals("Issued")) return true;
        return false;
    }

    public void updateStatus(Ticket ticket, String newStatus) {

        if (ticket.status.equals("Issued")) {
            throw new RuntimeException("Cannot modify final stage");
        }

        if (!isValidTransition(ticket.status, newStatus)) {
            throw new RuntimeException("Invalid transition");
        }

        ticket.status = newStatus;
        ticket.timestamps.put(newStatus, LocalDateTime.now().toString());
    }
}