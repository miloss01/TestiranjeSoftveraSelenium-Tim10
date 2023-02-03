package booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CurrentRidePage {

    private WebDriver driver;
    public static String PAGE_URL="http://localhost:4200/current-ride";

    @FindBy(xpath = "//button[contains(., \"OK\") and contains(@class, \"swal2-confirm\")]")
    WebElement swalOkButton;
    @FindBy(xpath = "//button[contains(., \"Accept\") and contains(@class, \"swal2-confirm\")]")
    WebElement swalAcceptButton;

    @FindBy(xpath = "//button[contains(., \"Decline\") and contains(@class, \"swal2-confirm\")]")
    WebElement swalDeclineButton;

    @FindBy(tagName = "app-map")
    WebElement map;

    @FindBy(id = "cancel-ride-btn")
    WebElement cancelRideButton;

    @FindBy(id = "start-ride-btn")
    WebElement startRideButton;

    @FindBy(id = "end-ride-btn")
    WebElement endRideButton;

    @FindBy(xpath = "//app-cancel-dialog")
    WebElement cancelDialog;
    @FindBy(xpath = "//textarea")
    WebElement cancelExplanationInput;

    @FindBy(xpath = "//button[contains(., \"Decline\")]")
    WebElement declineRideButton;


    public CurrentRidePage(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void loadPage() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.visibilityOf(map));
    }

    public void clickAccept() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(swalAcceptButton)).click();
    }

    public void setCancelExplanationInput(String explanation) {
        cancelExplanationInput.sendKeys(explanation);
    }

    public void clickCancel() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(cancelRideButton)).click();
    }

    public void clickStart() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(startRideButton)).click();
    }

    public void clickEnd() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(endRideButton)).click();
    }

    public void waitCancelDialog() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//app-cancel-dialog")));
    }

    public void clickDecline() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(declineRideButton)).click();
    }

    public void waitForNoRideTitle() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(., \"No ride currently in progress.\")]")));
    }

    public void waitForAcceptedRide() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("start-ride-btn")));
    }

    public void waitForActiveRide() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("end-ride-btn")));
    }

    public void exitSwalPopUp() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.visibilityOf(swalOkButton));
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(swalOkButton)).click();
    }

    public void closeSnackBar() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(., \"Close\")]"))).click();
    }

}
