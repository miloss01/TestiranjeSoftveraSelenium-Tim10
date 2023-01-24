package booking.tests;

import booking.pages.BookingPage;
import booking.pages.LandingPage;
import booking.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Helper.takeScreenshoot;

public class BookRideTest extends TestBase{
    static final String DEPARTURE_ADDRESS = "Developer";
    static final String DESTINATION_ADDRESS = "email";
    static final String FRIEND_NAME = "full name";
    static final String VEHICLE_TYPE = "luxury";

    @Test
    public void bookRideWithNoAddress() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickLogin();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillUsername("nana@DEsi.com");
        logInPage.fillPassword("333");
        logInPage.clickLogin();
//        BookingPage bookingPage = new BookingPage(driver);
//        Assert.assertTrue(bookingPage.loadPage());
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
