package booking.tests;

import booking.pages.CurrentRidePage;
import org.testng.annotations.Test;

import static helper.Helper.takeScreenshoot;

public class ExecuteRideTest extends TestBaseForExecutingRide {


    @Test(priority=1)
    public void acceptPendingRide() {
        CurrentRidePage currentRidePage = new CurrentRidePage(driver);
        currentRidePage.loadPage();
        currentRidePage.clickAccept();
        takeScreenshoot(driver, "booking_accept_pending_ride");
    }

    @Test(priority=2)
    public void startRide() {
        CurrentRidePage currentRidePage = new CurrentRidePage(driver);
        currentRidePage.loadPage();
        currentRidePage.waitForAcceptedRide();
        currentRidePage.clickStart();
        currentRidePage.waitForActiveRide();
        takeScreenshoot(driver, "starting_accepted_ride");
    }

    @Test(priority=3)
    public void endRide() {
        CurrentRidePage currentRidePage = new CurrentRidePage(driver);
        currentRidePage.loadPage();
        currentRidePage.waitForActiveRide();
        currentRidePage.clickEnd();
        currentRidePage.waitForNoRideTitle();
        takeScreenshoot(driver, "ending_active_ride");
    }

}

