package booking.tests;

import booking.pages.CurrentRidePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helper.Helper.takeScreenshoot;

public class EndRideAndLoadAcceptedTest extends TestBaseForEndRideAndLoadAccepted {

    @Test(priority=1)
    public void endRide() {
        CurrentRidePage currentRidePage = new CurrentRidePage(driver);
        currentRidePage.loadPage();
        currentRidePage.waitForActiveRide();
        currentRidePage.clickEnd();
        Assert.assertTrue(currentRidePage.waitForAcceptedRide());
    }
}
