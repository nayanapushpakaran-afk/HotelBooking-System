// Select a room
function selectRoom(type, price) {

    document.getElementById("roomType").value = type;

    document.getElementById("booking").scrollIntoView({
        behavior: "smooth"
    });
}


// Calculate booking bill
function calculateBill() {

    const guestName =
        document.getElementById("guestName").value;

    const guestId =
        document.getElementById("guestId").value;

    const contact =
        document.getElementById("contact").value;

    const roomType =
        document.getElementById("roomType").value;

    const checkIn =
        document.getElementById("checkIn").value;

    const checkOut =
        document.getElementById("checkOut").value;


    // Check required fields
    if (
        guestName === "" ||
        guestId === "" ||
        contact === "" ||
        checkIn === "" ||
        checkOut === ""
    ) {

        alert("Please fill in all details.");

        return;
    }


    // Room prices
    let price;

    if (roomType === "Single") {
        price = 1500;
    }
    else if (roomType === "Double") {
        price = 2500;
    }
    else {
        price = 4000;
    }


    // Calculate number of nights
    const startDate = new Date(checkIn);
    const endDate = new Date(checkOut);

    const difference =
        endDate - startDate;

    const nights =
        difference / (1000 * 60 * 60 * 24);


    // Validate dates
    if (nights <= 0) {

        alert(
            "Check-out date must be after check-in date."
        );

        return;
    }


    // Calculate bill
    const total =
        nights * price;


    // Display bill
    document.getElementById("billDetails").innerHTML =

        "Guest Name: " + guestName +
        "<br>Guest ID: " + guestId +
        "<br>Contact: " + contact +
        "<br>Room Type: " + roomType +
        "<br>Check-in: " + checkIn +
        "<br>Check-out: " + checkOut +
        "<br>Number of Nights: " + nights +
        "<br>Price per Night: ₹" + price +
        "<br><br><strong>Total Bill: ₹"
        + total +
        "</strong>";
}