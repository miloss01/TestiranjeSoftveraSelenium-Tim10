package booking.tests;

import booking.pages.CurrentRidePage;
import org.testng.annotations.Test;

import static helper.Helper.takeScreenshoot;

public class CancellingRideTest extends TestBaseForCancellingRide {

    static final String CANCEL_EXPLANATION = "Not right now";


    @Test(priority=1)
    public void cancelRide() {
        CurrentRidePage currentRidePage = new CurrentRidePage(driver);
        currentRidePage.loadPage();
        currentRidePage.clickCancel();
        currentRidePage.waitCancelDialog();
        currentRidePage.setCancelExplanationInput(CANCEL_EXPLANATION);
        currentRidePage.clickDecline();
        currentRidePage.waitForNoRideTitle();
        takeScreenshoot(driver, "cancelling_accepted_ride");
    }

}
