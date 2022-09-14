package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class EmailAccountsPage {
    WebDriver driver;
    WebDriverWait wait;
    By configurationMenuOption = By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),'Configuration')]");
    By emailAccountsSubMenuOption = By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),' Email accounts')]");
    By emailAccountPageVerify = By.xpath("//h1[contains(text(),'Email accounts')]");
    By addNewLinkBtn = By.xpath("//div[@class='float-right']");
    By emailAddressInput = By.xpath("(//input[contains(@class,'text-box')])[1]");
    By emailDisplayNameInput = By.xpath("(//input[contains(@class,'text-box')])[2]");
    By saveButton = By.xpath("//button[@name='save']");

    public EmailAccountsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToEmailAccountsPage() {
        driver.findElement(configurationMenuOption).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAccountsSubMenuOption));
        driver.findElement(emailAccountsSubMenuOption).click();
        String actual = driver.findElement(emailAccountPageVerify).getText();
        Assert.isTrue(actual.equals("Email accounts"), "Expected result does not match with actual result");
        driver.findElement(addNewLinkBtn).click();
    }

    public void addEmailAccount() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestDataFile.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String email = sheet.getRow(1).getCell(2).getStringCellValue();
        String emailDisplayName = sheet.getRow(1).getCell(3).getStringCellValue();
        driver.findElement(emailAddressInput).sendKeys(email);
        driver.findElement(emailDisplayNameInput).sendKeys(emailDisplayName);
        driver.findElement(saveButton).click();
    }
}