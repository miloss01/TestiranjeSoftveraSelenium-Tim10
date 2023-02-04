package booking.tests;

import booking.pages.BookingPage;
import booking.pages.LandingPage;
import booking.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogInTest {

    public static WebDriver driver;
    private LandingPage landingPage;
    private LogInPage logInPage;

    @BeforeSuite
    public void initializeWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        landingPage = new LandingPage(driver);
        landingPage.goToLandingPage();
        Assert.assertTrue(landingPage.loadPage());
        landingPage.clickLogin();
        logInPage = new LogInPage(driver);
        Assert.assertTrue(logInPage.loadPage());
//        Thread.sleep(2 * 1000);
    }

    @BeforeMethod
    public void openLogInPage() {
//        landingPage = new LandingPage(driver);
//        landingPage.goToLandingPage();
//        Assert.assertTrue(landingPage.loadPage());
        landingPage.clickLogin();
//        logInPage = new LogInPage(driver);
    }

    @Test
    public void wrongPassword() {
        logInPage.fillUsername("nana@DEsi.com");
        logInPage.fillPassword("222");
        logInPage.clickLogin();
        Assert.assertTrue(logInPage.checkErrorMessageText("Wrong username or password"));
    }

    @Test
    public void wrongEmail() {
        logInPage.fillUsername("nonexistent@DEsi.com");
        logInPage.fillPassword("222");
        logInPage.clickLogin();
        Assert.assertTrue(logInPage.checkErrorMessageText("Wrong username or password"));
    }

    @Test
    public void loginAsPassenger() {
        logInPage.fillUsername("nana@DEsi.com");
        logInPage.fillPassword("333");
        logInPage.clickLogin();
        BookingPage bookingPage = new BookingPage(driver);
        Assert.assertTrue(bookingPage.loadPage());
        landingPage.clickLogout();
        Assert.assertTrue(landingPage.loadPage());
    }

    @Test
    public void loginAsDriver() throws InterruptedException {
        logInPage.fillUsername("boki@DEsi.com");
        logInPage.fillPassword("333");
        logInPage.clickLogin();
        Assert.assertTrue(landingPage.loadPage());
        Assert.assertTrue(landingPage.checkIfStatusTextExists());
        landingPage.clickLogout();
        Assert.assertTrue(landingPage.loadPage());
    }

    @Test
    public void loginAsAdmin() {
        logInPage.fillUsername("dmina@gmail.com");
        logInPage.fillPassword("333");
        logInPage.clickLogin();
        Assert.assertTrue(landingPage.loadPage());
        Assert.assertTrue(landingPage.checkIfManageAccountsButtonExists());
        landingPage.clickLogout();
        Assert.assertTrue(landingPage.loadPage());
    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }

}
