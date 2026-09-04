import java.time.LocalDate;
import java.util.ArrayList;

public class HotelManager {

    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;
    private ArrayList<Booking> bookings;

    // Constructor
    public HotelManager() {
        rooms = new ArrayList<>();
        guests = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    // ================= ROOM MANAGEMENT =================

    // Add a new room
    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Room added successfully.");
    }

    // Remove a room
    public void removeRoom(int roomNumber) {

        Room room = findRoom(roomNumber);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        if (!room.isAvailable()) {
            System.out.println("Cannot remove a booked room.");
            return;
        }

        rooms.remove(room);
        System.out.println("Room removed successfully.");
    }

    // Update room details
    public void updateRoom(int roomNumber,
                           String newType,
                           double newPrice) {

        Room room = findRoom(roomNumber);

        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        room.setRoomType(newType);
        room.setPricePerNight(newPrice);

        System.out.println("Room updated successfully.");
    }

    // Find a room using room number
    public Room findRoom(int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }

        return null;
    }

    // View available rooms by type
    public void viewAvailableRooms(String type) {

        boolean found = false;

        System.out.println("\nAvailable " + type + " Rooms:");

        for (Room room : rooms) {

            if (room.getRoomType().equalsIgnoreCase(type)
                    && room.isAvailable()) {

                room.displayRoom();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No rooms available.");
        }
    }

    // Display all rooms
    public void displayAllRooms() {

        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        for (Room room : rooms) {
            room.displayRoom();
        }
    }

    // ================= GUEST MANAGEMENT =================

    // Register a new guest
    public void addGuest(Guest guest) {
        guests.add(guest);
        System.out.println("Guest registered successfully.");
    }

    // Find guest using guest ID
    public Guest findGuest(int guestId) {

        for (Guest guest : guests) {

            if (guest.getGuestId() == guestId) {
                return guest;
            }
        }

        return null;
    }

    // ================= BOOKING OPERATIONS =================

    // Book a room
    public void bookRoom(int bookingId,
                         int guestId,
                         int roomNumber,
                         LocalDate checkIn,
                         LocalDate checkOut) {

        Guest guest = findGuest(guestId);
        Room room = findRoom(roomNumber);

        // Check guest
        if (guest == null) {
            System.out.println("Guest not found.");
            return;
        }

        // Check room
        if (room == null) {
            System.out.println("Room not found.");
            return;
        }

        // Check availability
        if (!room.isAvailable()) {
            System.out.println("Room is already booked.");
            return;
        }

        // Check dates
        if (!checkOut.isAfter(checkIn)) {
            System.out.println(
                    "Invalid check-in/check-out dates.");
            return;
        }

        // Create booking
        Booking booking = new Booking(
                bookingId,
                guest,
                room,
                checkIn,
                checkOut
        );

        // Add booking to booking list
        bookings.add(booking);

        // Mark room as booked
        room.setAvailable(false);

        // Add booking to guest history
        guest.addBooking(booking);

        System.out.println("Room booked successfully.");

        System.out.println(
                "Total Bill: Rs." + booking.calculateBill());
    }

    // Cancel a booking
    public void cancelBooking(int bookingId) {

        Booking booking = findBooking(bookingId);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        // Make the room available again
        booking.getRoom().setAvailable(true);

        // Remove booking
        bookings.remove(booking);

        System.out.println("Booking cancelled successfully.");
    }

    // Find booking using booking ID
    public Booking findBooking(int bookingId) {

        for (Booking booking : bookings) {

            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }

        return null;
    }

    // Calculate bill
    public void calculateBill(int bookingId) {

        Booking booking = findBooking(bookingId);

        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }

        System.out.println("\n========== BILL ==========");

        System.out.println(
                "Booking ID : " + booking.getBookingId());

        System.out.println(
                "Guest      : "
                        + booking.getGuest().getGuestName());

        System.out.println(
                "Room       : "
                        + booking.getRoom().getRoomNumber());

        System.out.println(
                "Check-in   : " + booking.getCheckIn());

        System.out.println(
                "Check-out  : " + booking.getCheckOut());

        System.out.println(
                "Nights     : " + booking.calculateNights());

        System.out.println(
                "Price/Night: Rs."
                        + booking.getRoom().getPricePerNight());

        System.out.println(
                "Total Bill : Rs."
                        + booking.calculateBill());

        System.out.println("==========================");
    }

    // Display all bookings
    public void displayBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        for (Booking booking : bookings) {
            booking.displayBooking();
        }
    }
}