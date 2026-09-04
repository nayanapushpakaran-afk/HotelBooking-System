import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {

    private int bookingId;
    private Guest guest;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;

    // Constructor
    public Booking(int bookingId, Guest guest, Room room,
                   LocalDate checkIn, LocalDate checkOut) {

        this.bookingId = bookingId;
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Get booking ID
    public int getBookingId() {
        return bookingId;
    }

    // Get guest
    public Guest getGuest() {
        return guest;
    }

    // Get room
    public Room getRoom() {
        return room;
    }

    // Get check-in date
    public LocalDate getCheckIn() {
        return checkIn;
    }

    // Get check-out date
    public LocalDate getCheckOut() {
        return checkOut;
    }

    // Calculate number of nights
    public long calculateNights() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    // Calculate total bill
    public double calculateBill() {
        return calculateNights() * room.getPricePerNight();
    }

    // Display booking details
    public void displayBooking() {

        System.out.println("Booking ID : " + bookingId);
        System.out.println("Guest      : " + guest.getGuestName());
        System.out.println("Room       : " + room.getRoomNumber());
        System.out.println("Room Type  : " + room.getRoomType());
        System.out.println("Check-in   : " + checkIn);
        System.out.println("Check-out  : " + checkOut);
        System.out.println("Nights     : " + calculateNights());
        System.out.println("Total Bill : Rs." + calculateBill());
        System.out.println("-----------------------------");
    }
}