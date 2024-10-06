import java.util.Scanner;

public class Theater {
    private char[][] seats;
    private int rows;
    private int columns;

    public Theater(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = 'E'; 
            }
        }
    }

    public void displaySeats() {
        System.out.println("Theater Seating Arrangement:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void bookSeat(int row, int column) {
        if (seats[row][column] == 'E') {
            seats[row][column] = 'B'; 
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("Seat is already booked. Please choose another seat.");
        }
    }

    public void cancelBooking(int row, int column) {
        if (seats[row][column] == 'B') {
            seats[row][column] = 'E'; 
            System.out.println("Booking cancelled successfully!");
        } else {
            System.out.println("Seat is not booked. Please choose another seat.");
        }
    }

    public static void main(String[] args) {
        Theater theater = new Theater(5, 5); 
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Theater Menu:");
            System.out.println("1. Display Seating Arrangement");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    theater.displaySeats();
                    break;
                case 2:
                    System.out.print("Enter row number: ");
                    int row = scanner.nextInt();
                    System.out.print("Enter column number: ");
                    int column = scanner.nextInt();
                    theater.bookSeat(row, column);
                    break;
                case 3:
                    System.out.print("Enter row number: ");
                    row = scanner.nextInt();
                    System.out.print("Enter column number: ");
                    column = scanner.nextInt();
                    theater.cancelBooking(row, column);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
