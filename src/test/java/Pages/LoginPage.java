package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginPage {
    WebDriver driver;

    By emailInput = By.xpath("//input[contains(@class,'email')]");
    By passwordInput = By.xpath("//input[contains(@class,'password')]");
    By loginButton = By.xpath("//button[contains(@class,'login-button')]");
    By dashboardPageVerify = By.xpath("//h1[contains(text(),'Dashboard')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestDataFile.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String email = sheet.getRow(1).getCell(0).getStringCellValue();
        String password = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(emailInput).clear();
        driver.findElement(passwordInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        String actual = driver.findElement(dashboardPageVerify).getText();
        Assert.isTrue(actual.equals("Dashboard"), "Expected result does not match with actual result");
    }
}