package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By emailInput = By.xpath("//input[contains(@class,'email')]");
    By passwordInput = By.xpath("//input[contains(@class,'password')]");
    By loginButton = By.xpath("//button[contains(@class,'login-button')]");
    By dashboardPageVerify = By.xpath("//h1[contains(text(),'Dashboard')]");

    String email = "admin@yourstore.com";
    String password = "admin";
    String dashboardPageText = "Dashboard";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        driver.findElement(emailInput).clear();
        driver.findElement(passwordInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        String actual = driver.findElement(dashboardPageVerify).getText();
        Assert.isTrue(actual.equals(dashboardPageText), "Expected result does not match with actual result");
    }
}