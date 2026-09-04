import java.util.ArrayList;

public class Guest {

    private int guestId;
    private String guestName;
    private String contact;

    // Stores the guest's booking history
    private ArrayList<Booking> bookingHistory;

    // Constructor
    public Guest(int guestId, String guestName, String contact) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.contact = contact;
        this.bookingHistory = new ArrayList<>();
    }

    // Get guest ID
    public int getGuestId() {
        return guestId;
    }

    // Get guest name
    public String getGuestName() {
        return guestName;
    }

    // Get contact number
    public String getContact() {
        return contact;
    }

    // Get booking history
    public ArrayList<Booking> getBookingHistory() {
        return bookingHistory;
    }

    // Add a booking to booking history
    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
    }

    // Display guest details
    public void displayGuest() {
        System.out.println("Guest ID : " + guestId);
        System.out.println("Name     : " + guestName);
        System.out.println("Contact  : " + contact);
    }
}