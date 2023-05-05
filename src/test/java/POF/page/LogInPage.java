package POF.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LogInPage {
    WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver=driver;
    }

    //Locating the username text box
    @FindBy(css="input[name='userName']")
    WebElement username;

    //Locating the password text box
    @FindBy(css="input[name='password']")
    WebElement password;

    //Locating Login Button
    @FindBy(css="input[name='submit']")
    WebElement loginBtn;


    //Method that performs login action using the web elements
    public void logInAction(String userName, String pwd){
        username.sendKeys(userName);
        password.sendKeys(pwd);
        loginBtn.click();
    }

    public void verifyLogInSuccess() {
        boolean isLogInSuccess = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("login_sucess.php"));
        Assert.assertTrue(isLogInSuccess,"Successfully logged in");
    }

}
