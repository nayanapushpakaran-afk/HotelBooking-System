public class Room {

    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean available;

    // Constructor
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.available = true;
    }

    // Get room number
    public int getRoomNumber() {
        return roomNumber;
    }

    // Get room type
    public String getRoomType() {
        return roomType;
    }

    // Get price
    public double getPricePerNight() {
        return pricePerNight;
    }

    // Check availability
    public boolean isAvailable() {
        return available;
    }

    // Update room type
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    // Update room price
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    // Update availability
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Display room details
    public void displayRoom() {
        System.out.println("Room Number : " + roomNumber);
        System.out.println("Room Type   : " + roomType);
        System.out.println("Price/Night : Rs." + pricePerNight);
        System.out.println("Status      : " +
                (available ? "Available" : "Booked"));
        System.out.println("-----------------------------");
    }
}