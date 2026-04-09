import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private FileService fileService = new FileService();
    private CacheService cacheService = new CacheService();
    private LoggerService logger = new LoggerService();

    private List<Ticket> tickets = fileService.load();
    private TicketService ticketService = new TicketService();
    private Scanner scanner = new Scanner(System.in);




    public void start() {

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Create Ticket");
            System.out.println("2. Update Status");
            System.out.println("3. View Tickets");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createTicket();
                    break;
                case 2:
                    updateTicket();
                    break;
                case 3:
                    viewTickets();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }


    private void createTicket() {

        int id = tickets.size() + 1;
        Ticket ticket = new Ticket(id);
        tickets.add(ticket);
        fileService.save(tickets);
        logger.log("Ticket " + id + " created");

        System.out.println("Ticket created with ID: " + id);
    }

    private void updateTicket() {
        System.out.print("Enter Ticket ID: ");
        int id = scanner.nextInt();


        Ticket ticket = findTicket(id);

        if (ticket == null) {
            System.out.println("Ticket not found");
            return;
        }


        System.out.print("Enter new status (Paid / Issued): ");
        String newStatus = scanner.next();

        try {
            ticketService.updateStatus(ticket, newStatus);
            fileService.save(tickets); // ← ДОБАВЬ ЭТУ СТРОКУ
            System.out.println("Status updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        logger.log("Ticket " + ticket.id + " updated to " + newStatus);
    }

    private void viewTickets() {
        for (Ticket t : tickets) {
            System.out.println("ID: " + t.id + ", Status: " + t.status);
        }
    }

    private Ticket findTicket(int id) {


        Ticket cached = cacheService.get(id);
        if (cached != null) {
            return cached;
        }


        for (Ticket t : tickets) {
            if (t.id == id) {
                System.out.println("From file");
                cacheService.put(t);
                return t;
            }
        }

        return null;
    }
}
