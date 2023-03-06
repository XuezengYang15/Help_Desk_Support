import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ticket {

    private String description;
    private LocalDate creationDate;
    private int cdYear, cdMonth, cdDay;
    private LocalDate dueDate;
    private int ddYear, ddMonth, ddDay;

    //Arraylist to hold the ticket lists.
    List<Ticket> ticketList = new ArrayList<Ticket>();

    Scanner keyboard = new Scanner(System.in);

    //Constructor
    public Ticket (String inputDescription, LocalDate inputCreationDate,
                   LocalDate inputDueDate) {
        this.description = inputDescription;
        this.creationDate = inputCreationDate;
        this.dueDate = inputDueDate;
    }

    public Ticket () {

    }

    public void removeTicket(int inputTicketNumber) {

        ticketList.remove(inputTicketNumber - 1);
    }

    public void addTicket() {

        System.out.println("Enter the description of the issue:");
        description = keyboard.nextLine();

        System.out.println("What is the creation date year of ticket?");
        cdYear = keyboard.nextInt();

        System.out.println("What is the creation date month of ticket?");
        cdMonth = keyboard.nextInt();

        System.out.println("What is the creation date day of ticket?");
        cdDay = keyboard.nextInt();

        LocalDate cdDate = LocalDate.of(cdYear, cdMonth, cdDay); //year, month, day

        System.out.println("What is the due date year of ticket?");
        ddYear = keyboard.nextInt();

        System.out.println("What is the due date month of ticket?");
        ddMonth = keyboard.nextInt();

        System.out.println("What is the due date day of ticket?");
        ddDay = keyboard.nextInt();

        LocalDate ddDate = LocalDate.of(ddYear, ddMonth, ddDay); //year, month, day

        //Creates ticket object that will be eventually be added to Arraylist
        Ticket createdTicket = new Ticket(description, cdDate, ddDate);

        //Adding createdTicket to Arraylist.
        ticketList.add(createdTicket);

        //Consumes remaining newline.
        keyboard.nextLine();
    }

    //Different print outs of ticket list
    public void printTicketListForLoop() {
        for(int i = 0; i < ticketList.size(); i++) {
            System.out.println("Ticket #" + (i+1));
            System.out.println(ticketList.get(i));
        }
    }

    //Getter
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }


    //toString method to print the content in the tickets
    public String toString() {
        return  "Description: " + description + "\n" +
                "Creation date: " + creationDate + "\n" +
                "Due date: " + dueDate + "\n";
    }
}

