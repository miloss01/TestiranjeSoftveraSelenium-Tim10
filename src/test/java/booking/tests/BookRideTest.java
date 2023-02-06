package booking.tests;

import booking.pages.BookingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Helper.takeScreenshoot;

public class BookRideTest extends TestBaseForBooking {
    static final String DEPARTURE_ADDRESS = "Vuka Karadžića 6, Novi Sad";
    static final String DESTINATION_ADDRESS = "Pavleka Miškine 17, Novi Sad";
    static final String FRIEND_NAME = "full name";
    static final String VEHICLE_TYPE = "Luxury";

    static final String VEHICLE_TYPE_NO_VEHICLES = "Van";


    @Test(priority=1)
    public void bookRideWithNoAddress() {
        BookingPage bookingPage = new BookingPage(driver);
        Assert.assertTrue(bookingPage.loadPage());
        bookingPage.clickBook();
        takeScreenshoot(driver, "booking_address_not_filled");
    }

    @Test(priority=2)
    public void bookRideInvalidDate() {
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.fillDepartureTextBox(DEPARTURE_ADDRESS);
        bookingPage.fillDestinationTextBox(DESTINATION_ADDRESS);
        bookingPage.clickEstimate();
        bookingPage.clickPetCheckbox();
        bookingPage.clickBook();
        bookingPage.waitForTimeNotValid();
        takeScreenshoot(driver, "booking_time_not_selected");
        bookingPage.closeSnackBar();
        bookingPage.clickEstimate();
        bookingPage.selectInvalidDate();
        bookingPage.clickBook();
        bookingPage.waitForTimeNotValid();
        takeScreenshoot(driver, "booking_time_not_valid");
    }

    @Test(priority = 3)
    public void bookRideNoAvailableVehicles() {
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.reloadPage();
        bookingPage.fillDepartureTextBox(DEPARTURE_ADDRESS);
        bookingPage.fillDestinationTextBox(DESTINATION_ADDRESS);
        bookingPage.clickEstimate();
        bookingPage.selectValidDate();
        bookingPage.selectDropDown(VEHICLE_TYPE_NO_VEHICLES);
        bookingPage.clickBook();
        bookingPage.waitForNoAvailableVehiclePopUp();
        takeScreenshoot(driver, "booking_no_vehicles");
    }

    @Test(priority = 4)
    public void bookRideHappyEnding() {
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.exitSwalPopUp();
        bookingPage.reloadPage();
        bookingPage.fillDepartureTextBox(DEPARTURE_ADDRESS);
        bookingPage.fillDestinationTextBox(DESTINATION_ADDRESS);
        bookingPage.clickEstimate();
        bookingPage.selectDropDown(VEHICLE_TYPE);
        bookingPage.selectValidDate();
        bookingPage.clickBook();
        bookingPage.waitForBookingSucessfullPopUp();
        takeScreenshoot(driver, "booking_successful");
    }

    @Test(priority = 5)
    public void bookRideAlreadyPending() {
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.reloadPage();
        bookingPage.fillDepartureTextBox(DEPARTURE_ADDRESS);
        bookingPage.fillDestinationTextBox(DESTINATION_ADDRESS);
        bookingPage.clickEstimate();
        bookingPage.selectDropDown(VEHICLE_TYPE);
        bookingPage.selectValidDate();
        bookingPage.clickBook();
        bookingPage.waitForRidePendingPopUp();
        takeScreenshoot(driver, "booking_ride_already_pending");
    }
}
