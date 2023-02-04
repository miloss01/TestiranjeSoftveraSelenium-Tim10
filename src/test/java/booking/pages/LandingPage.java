package booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
    private WebDriver driver;
    private static String PAGE_URL="http://localhost:4200";

    @FindBy(tagName = "app-map")
    WebElement map;

    @FindBy(xpath = "//span[contains(., \"Log in\")]")
    WebElement logInButton;

    @FindBy(xpath = "//button[contains(., \" Log out \")]")
    private WebElement logOutButton;

    @FindBy(xpath = "//button[contains(., \"Manage accounts\")]")
    private WebElement manageAccountsButton;

    @FindBy(xpath = "//p[contains(., \"Your status:\")]")
    WebElement yourStatusText;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLandingPage() {
        driver.navigate().to(PAGE_URL);
    }

    public boolean loadPage() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.visibilityOf(map));
        return true;
    }

    public void clickLogin() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(logInButton)).click();
    }

    public void clickLogout() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(logOutButton)).click();
    }

    public boolean checkIfStatusTextExists() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(yourStatusText, "Your status:"));
        return true;
    }

    public boolean checkIfManageAccountsButtonExists() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(manageAccountsButton));
        return true;
    }
}
