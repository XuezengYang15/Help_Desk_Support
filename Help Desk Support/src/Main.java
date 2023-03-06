/*
Create a system to maintain a list of service tickets for a help desk:
1.A ticket has a description, a creation date and a due date
2.When a ticket is created, add it to the list
3.When a ticket is resolved, remove it from the list
4.The system should provide the following services:
    a.Creating a new ticket
    b.Completing an existing ticket
    c.Displaying the list of tickets in the order of their creation
    d.Finding the ticket with the earliest due date
5.Create a menu-driven test app that allows the user to perform all
  specified operations until the user decides to stop.
 */

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static int serviceInput;

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        Ticket tick = new Ticket ();

        System.out.println( "Welcome to Ticket Master 2000, " +
                            "please enter the corresponding number for the following services: \n" +
                            "1.Create a new ticket\n" +
                            "2.Complete/remove an existing ticket\n" +
                            "3.Organizes the tickets by their creation date\n" +
                            "4.Organizes the tickets by their due date\n" +
                            "5.Print the queued tickets\n" +
                            "6.Exit the program\n");

        serviceInput = keyboard.nextInt();

        while (serviceInput > 0 && serviceInput < 6) {

            switch (serviceInput) {
                case 1:
                    //Adds the ticket to the array list.
                    tick.addTicket();
                    break;
                case 2:
                    //Remove ticket
                    System.out.println("Which ticket would you like to remove/complete?\n\n");

                    tick.printTicketListForLoop();

                    System.out.println("Please enter the ticket number that your wish to remove. ");
                    int inputNumber = keyboard.nextInt();

                    //This will let the user know that the arraylist is empty.
                    boolean case2 = tick.ticketList.isEmpty();
                    if(case2 == true)
                        System.out.println("There are no tickets available.\n");

                    tick.removeTicket(inputNumber);
                    break;
                case 3:
                    //Organize tickets by their creation dates.
                    Comparator<Ticket> byCreationDate = new Comparator<Ticket>() {
                        @Override
                        public int compare(Ticket cd1, Ticket cd2) {
                            return Integer.valueOf(cd1.getCreationDate().compareTo(cd2.getCreationDate()));
                        }
                    };
                    tick.printTicketListForLoop();
                    System.out.println("Ticket list is sorted by creation date.\n");
                    break;
                case 4:
                    //Organize tickets by their due dates.
                    Comparator<Ticket> byDueDate = new Comparator<Ticket>() {
                        @Override
                        public int compare(Ticket dd1, Ticket dd2) {
                            return Integer.valueOf(dd1.getDueDate().compareTo(dd2.getDueDate()));
                        }
                    };
                    tick.printTicketListForLoop();
                    System.out.println("Ticket list is sorted by due date.\n");
                    break;
                case 5:
                    //Prints the ticket list
                    boolean case5 = tick.ticketList.isEmpty();
                    if(case5 == true)
                        System.out.println("There are no1 tickets available.\n");
                    tick.printTicketListForLoop();
                    break;
                case 6:
                    //Exits the program.
                    break;
            }

            introMessage();

            //User will see the menu again and given the option to chose selection.
            serviceInput = keyboard.nextInt();
        }

        //Testing out what prints
        tick.printTicketListForLoop();

    }
    public static void introMessage() {
        System.out.println("1.Create a new ticket\n" +
                           "2.Complete/remove an existing ticket\n" +
                           "3.Organizes the tickets by their creation date\n" +
                           "4.Organizes the tickets by their due date\n" +
                           "5.Print the queued tickets\n" +
                           "6.Exit the program\n");
    }
}
