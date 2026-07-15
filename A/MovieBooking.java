class MovieTicketCounter {

    int availableSeats;

    MovieTicketCounter(int seats) {
        availableSeats = seats;
    }

    // Synchronized method
    synchronized void bookTicket(String customer, int seats) {

        System.out.println(customer + " wants to book " + seats + " seat(s).");

        if (availableSeats >= seats) {
            availableSeats = availableSeats - seats;
            System.out.println("Booking Successful for " + customer);
        } else {
            System.out.println("Booking Failed for " + customer + " (Not enough seats)");
        }

        System.out.println("Remaining Seats: " + availableSeats);
        System.out.println();
    }
}

// Customer Thread
class Customer extends Thread {

    MovieTicketCounter counter;
    int seats;

    Customer(MovieTicketCounter counter, String name, int seats) {
        this.counter = counter;
        this.seats = seats;
        setName(name);
    }

    public void run() {
        counter.bookTicket(getName(), seats);
    }
}

// Main Class
public class MovieBooking {

    public static void main(String[] args) {

        MovieTicketCounter counter = new MovieTicketCounter(10);

        Customer c1 = new Customer(counter, "Ram", 4);
        Customer c2 = new Customer(counter, "Sita", 3);
        Customer c3 = new Customer(counter, "Hari", 5);

        c1.start();
        c2.start();
        c3.start();
    }
}