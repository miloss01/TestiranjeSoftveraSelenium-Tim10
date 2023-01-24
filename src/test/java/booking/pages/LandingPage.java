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

    @FindBy(xpath = "//span[contains(., \"Log in\")]")
    WebElement logInButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickLogin() {
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(logInButton)).click();
    }
}
