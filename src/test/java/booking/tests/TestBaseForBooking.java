package booking.tests;

import booking.pages.LandingPage;
import booking.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBaseForBooking {
    public static WebDriver driver;

    @BeforeSuite
    public void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goToLandingPage();
        Assert.assertTrue(landingPage.loadPage());
        landingPage.clickLogin();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.fillUsername("nana@DEsi.com");
        logInPage.fillPassword("333");
        logInPage.clickLogin();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void quitDriver() {
//        driver.quit();
    }
}
