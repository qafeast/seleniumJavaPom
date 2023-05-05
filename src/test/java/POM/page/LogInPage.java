package POM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LogInPage {

    WebDriver driver;
    public LogInPage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterUserName() {
        driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("admin");
    }
    public void enterPassword() {
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
    }
    public void clickLogInButton() {
        driver.findElement(By.cssSelector("input[name='submit']")).click();
    }
    public void verifyLogInSuccess() {
        boolean waitForHomePage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("login_sucess.php"));
        Assert.assertTrue(waitForHomePage, "Successfully Logged in");
    }
}
