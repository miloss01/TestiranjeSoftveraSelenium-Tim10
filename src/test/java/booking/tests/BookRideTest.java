package booking.tests;

import booking.pages.BookingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Helper.takeScreenshoot;

public class BookRideTest extends TestBaseForBooking {
    static final String DEPARTURE_ADDRESS = "Developer";
    static final String DESTINATION_ADDRESS = "email";
    static final String FRIEND_NAME = "full name";
    static final String VEHICLE_TYPE = "luxury";

    @Test
    public void bookRideWithNoAddress() {
        BookingPage bookingPage = new BookingPage(driver);
        Assert.assertTrue(bookingPage.loadPage());
        takeScreenshoot(driver, "jj");
    }

//    @Test
//    public void bookRideInvalidDate() {
//        BookingPage bookingPage = new BookingPage(driver);
//
//    }
//
//    @Test
//    public void bookRideNoAvailableVehicles() {
//        BookingPage bookingPage = new BookingPage(driver);
//
//    }
//
//    @Test
//    public void bookRideHappyEnding() {
//        BookingPage bookingPage = new BookingPage(driver);
//
//    }
//
//    @Test
//    public void bookRideAlreadyPending() {
//        BookingPage bookingPage = new BookingPage(driver);
//
//    }
}
