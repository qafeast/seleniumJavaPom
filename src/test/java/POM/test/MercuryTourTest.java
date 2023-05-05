package POM.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import POM.page.LogInPage;

import java.time.Duration;

public class MercuryTourTest {

    public WebDriver driver;
    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test
    public void logInTest() {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.enterUserName();
        logInPage.enterPassword();
        logInPage.clickLogInButton();
        logInPage.verifyLogInSuccess();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
