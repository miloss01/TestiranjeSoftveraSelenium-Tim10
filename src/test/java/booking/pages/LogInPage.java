package booking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
    private WebDriver driver;
//    private static String PAGE_URL="http://localhost:4200";

    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//form/button[contains(., \"Log in\")]")
    WebElement logInButton;

    @FindBy(tagName = "p")
    WebElement errorMessage;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
//        driver.navigate().to(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void fillUsername(String username) {
        usernameField.clear();
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(usernameField)).clear();
        usernameField.sendKeys(username);
    }

    public void fillPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        System.out.println(logInButton.getText());
        (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.elementToBeClickable(logInButton)).click();
    }

    public Boolean checkErrorMessageText(String text) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBePresentInElement(errorMessage, text));
        return true;
    }
}
