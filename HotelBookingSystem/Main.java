import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create HotelManager object
        HotelManager manager = new HotelManager();

        // Add some sample rooms
        manager.addRoom(new Room(101, "Single", 1500));
        manager.addRoom(new Room(102, "Double", 2500));
        manager.addRoom(new Room(103, "Deluxe", 4000));

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     HOTEL ROOM BOOKING SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Room");
            System.out.println("2. Remove Room");
            System.out.println("3. Update Room");
            System.out.println("4. View Available Rooms");
            System.out.println("5. Display All Rooms");
            System.out.println("6. Register Guest");
            System.out.println("7. Book Room");
            System.out.println("8. Cancel Booking");
            System.out.println("9. Calculate Bill");
            System.out.println("10. Display Bookings");
            System.out.println("0. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                // ---------------- ADD ROOM ----------------
                case 1:

                    System.out.print("Enter room number: ");
                    int roomNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter room type: ");
                    String roomType = sc.nextLine();

                    System.out.print("Enter price per night: ");
                    double price = sc.nextDouble();

                    Room room = new Room(
                            roomNo,
                            roomType,
                            price
                    );

                    manager.addRoom(room);

                    break;

                // ---------------- REMOVE ROOM ----------------
                case 2:

                    System.out.print("Enter room number: ");
                    int removeRoomNo = sc.nextInt();

                    manager.removeRoom(removeRoomNo);

                    break;

                // ---------------- UPDATE ROOM ----------------
                case 3:

                    System.out.print("Enter room number: ");
                    int updateRoomNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter new room type: ");
                    String newRoomType = sc.nextLine();

                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    manager.updateRoom(
                            updateRoomNo,
                            newRoomType,
                            newPrice
                    );

                    break;

                // ---------------- VIEW AVAILABLE ROOMS ----------------
                case 4:

                    sc.nextLine();

                    System.out.print("Enter room type: ");
                    String searchType = sc.nextLine();

                    manager.viewAvailableRooms(searchType);

                    break;

                // ---------------- DISPLAY ALL ROOMS ----------------
                case 5:

                    manager.displayAllRooms();

                    break;

                // ---------------- REGISTER GUEST ----------------
                case 6:

                    System.out.print("Enter guest ID: ");
                    int guestId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter guest name: ");
                    String guestName = sc.nextLine();

                    System.out.print("Enter contact number: ");
                    String contact = sc.nextLine();

                    Guest guest = new Guest(
                            guestId,
                            guestName,
                            contact
                    );

                    manager.addGuest(guest);

                    break;

                // ---------------- BOOK ROOM ----------------
                case 7:

                    System.out.print("Enter booking ID: ");
                    int bookingId = sc.nextInt();

                    System.out.print("Enter guest ID: ");
                    int bookGuestId = sc.nextInt();

                    System.out.print("Enter room number: ");
                    int bookRoomNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print(
                            "Enter check-in date (YYYY-MM-DD): "
                    );

                    LocalDate checkIn =
                            LocalDate.parse(sc.nextLine());

                    System.out.print(
                            "Enter check-out date (YYYY-MM-DD): "
                    );

                    LocalDate checkOut =
                            LocalDate.parse(sc.nextLine());

                    manager.bookRoom(
                            bookingId,
                            bookGuestId,
                            bookRoomNo,
                            checkIn,
                            checkOut
                    );

                    break;

                // ---------------- CANCEL BOOKING ----------------
                case 8:

                    System.out.print("Enter booking ID: ");
                    int cancelBookingId = sc.nextInt();

                    manager.cancelBooking(cancelBookingId);

                    break;

                // ---------------- CALCULATE BILL ----------------
                case 9:

                    System.out.print("Enter booking ID: ");
                    int billBookingId = sc.nextInt();

                    manager.calculateBill(billBookingId);

                    break;

                // ---------------- DISPLAY BOOKINGS ----------------
                case 10:

                    manager.displayBookings();

                    break;

                // ---------------- EXIT ----------------
                case 0:

                    System.out.println(
                            "Thank you for using Hotel Booking System!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 0);

        sc.close();
    }
}