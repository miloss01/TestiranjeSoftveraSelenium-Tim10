package booking.tests;

import booking.pages.LandingPage;
import booking.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBaseForExecutingRide {

    public static WebDriver driver;

    @BeforeSuite
    public void initializeWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickLogin();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillUsername("testExecute@DEsi.com");
        logInPage.fillPassword("333");
        logInPage.commenceLogin();

    }

    @AfterSuite
    public void quitDriver() {
//        driver.quit();
    }
}
