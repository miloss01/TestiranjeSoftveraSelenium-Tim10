package booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//input[placeholder=\"Book time\"]")
    WebElement datePicker;

    @FindBy(xpath = "//p[contains(., \"Pets\")]/mat-checkbox")
    WebElement petCheckBox;

    @FindBy(xpath = "//p[contains(., \"Kids\")]/mat-checkbox")
    WebElement babyCheckBox;

    @FindBy(id = "book-btn")
    WebElement bookRideButton;

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
        departureSearchField.clear();
        departureSearchField.sendKeys(address);
    }

    public void fillDestinationTextBox(String address) {
        destinationSearchField.clear();
        destinationSearchField.sendKeys(address);
    }

    public void clickOnMap(int xOffset, int yOffset) {

    }
}
