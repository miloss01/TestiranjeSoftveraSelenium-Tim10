package booking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookingPage {
    private WebDriver driver;
    private static String PAGE_URL="http://localhost:4200/book-ride";

    @FindBy(tagName = "app-map")
    WebElement map;

    @FindBy(name = "destination")
    WebElement destinationSearchField;

    @FindBy(name = "departure")
    WebElement departureSearchField;

    @FindBy(id = "estimate-btn")
    WebElement estimateButton;

    @FindBy(tagName = "mat-select")
    WebElement vehicleTypeDropdown;

    @FindBy(id = "inv-btn")
    WebElement inviteFriendsDialog;

//    @FindBy(tagName = "button")
//    WebElement inviteButton;
//
//    @FindBy(css = "button[style=\"background-color: #24ED80;\"]")
//    WebElement cancelButton;
//
//    @FindBy(tagName = "input")
//    WebElement friendInputField;

    @FindBy(css = "input[placeholder=\"Book time\"]")
    WebElement datePicker;

    @FindBy(id="pet-checkbox")
    WebElement petCheckBox;

    @FindBy(xpath = "//p[contains(., \"Kids\")]/mat-checkbox")
    WebElement babyCheckBox;

    @FindBy(xpath = "//p[starts-with(., \"Estimated price:\")]")
    WebElement estimatedPriceLabel;

    @FindBy(id = "book-btn")
    WebElement bookRideButton;


    @FindBy(xpath = "//button[contains(., \"OK\") and contains(@class, \"swal2-confirm\")]")
    WebElement swalOkButton;

    @FindBy(xpath = "//button[contains(., \"OK!\") and contains(@class, \"swal2-confirm\")]")
    WebElement swalOkButtonRideAccepted;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
//        driver.navigate().to(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public boolean loadPage() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.visibilityOf(map));
        return true;
    }

    public void fillDepartureTextBox(String address) {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(departureSearchField));
        departureSearchField.clear();
        departureSearchField.sendKeys(address);
    }

    public void fillDestinationTextBox(String address) {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(destinationSearchField));
        destinationSearchField.clear();
        destinationSearchField.sendKeys(address);
    }

    public void clickOnMap(int xOffset, int yOffset) {

    }

    public void clickEstimate() {
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(estimateButton)).click();
        System.out.println(estimatedPriceLabel.getText());
        (new WebDriverWait(driver, 7))
                .until(ExpectedConditions.textToBePresentInElement(estimatedPriceLabel, "Estimated price: $370"));
        System.out.println(estimatedPriceLabel.getText());

    }

    public void clickBook() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(bookRideButton)).click();
    }

    public void clickPetCheckbox() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(petCheckBox)).click();
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(petCheckBox));
    }

    public void selectInvalidDate() {
        LocalDateTime date = LocalDateTime.now();
        date = date.plusHours(5);
        date = date.plusMinutes(10);
        LocalDateTime dateForForm = date;
        if (date.getHour() >= 12) dateForForm = dateForForm.minusHours(12);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy HHmm");
        String dateString = dateForForm.format(formatter);
        System.out.println(dateString);
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(datePicker));
        for (int i = 0; i < 4; i=i+2) {
            datePicker.sendKeys(dateString.substring(i, i + 2));
            (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.elementToBeClickable(datePicker));
        }
        datePicker.sendKeys(dateString.substring(4, 8));
        datePicker.sendKeys(Keys.ARROW_RIGHT);
        datePicker.sendKeys(dateString.substring(9, 11));
        System.out.println(dateString.substring(9, 11));
        datePicker.sendKeys(dateString.substring(11));

        if (date.getHour() >= 12) datePicker.sendKeys(Keys.chord(Keys.SHIFT, "p"));
        else datePicker.sendKeys(Keys.chord(Keys.SHIFT, "a"));
    }

    public void selectValidDate() {
        LocalDateTime date = LocalDateTime.now();
        date = date.plusMinutes(10);
        LocalDateTime dateForForm = date;
        if (date.getHour() >= 12) dateForForm = dateForForm.minusHours(12);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy HHmm");
        String dateString = dateForForm.format(formatter);
        System.out.println(dateString);
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(datePicker));
        for (int i = 0; i < 4; i=i+2) {
            datePicker.sendKeys(dateString.substring(i, i + 2));
            (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.elementToBeClickable(datePicker));
        }
        datePicker.sendKeys(dateString.substring(4, 8));
        datePicker.sendKeys(Keys.ARROW_RIGHT);
        datePicker.sendKeys(dateString.substring(9, 11));
        System.out.println(dateString.substring(9, 11));
        datePicker.sendKeys(dateString.substring(11));

        if (date.getHour() >= 12) datePicker.sendKeys(Keys.chord(Keys.SHIFT, "p"));
        else datePicker.sendKeys(Keys.chord(Keys.SHIFT, "a"));
    }

    public void selectDropDown(String vehicleType) {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(vehicleTypeDropdown)).click();
//        Select select = new Select(vehicleTypeDropdown);
//        select.selectByVisibleText(vehicleType);
        driver.findElement(By.xpath("//mat-option[contains(., \""+ vehicleType + "\")]")).click();
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(vehicleTypeDropdown));
    }

    public void reloadPage() {
        driver.navigate().to(PAGE_URL);
        loadPage();
    }

    public void exitSwalPopUp() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.visibilityOf(swalOkButton));
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(swalOkButton)).click();
    }

    public void waitForNoAvailableVehiclePopUp() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(., \"Booking failed :(\")]")));
//        (new WebDriverWait(driver, 3))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(., \"OK\")]")));
//        (new WebDriverWait(driver, 3))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., \"OK\")]")));
    }

    public void waitForBookingSucessfullPopUp() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[starts-with(., \"Driver has been appointed.\")]")));
    }

    public void waitForRidePendingPopUp() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(., \"Oops...\")]")));
    }

    public void waitForTimeNotValid() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(., \"Time not valid\")]")));
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., \"Close\")]")));
    }

    public void closeSnackBar() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(., \"Close\")]"))).click();
    }
}
