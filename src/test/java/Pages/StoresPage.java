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

public class StoresPage {
    WebDriver driver;
    WebDriverWait wait;

    By configurationMenuOption = By.xpath("//a[contains(@class,'nav-link')]//p[contains(text(),'Configuration')]");
    By storesSubMenuOption = By.xpath("//li[@class='nav-item']//p[contains(text(),' Stores')]");
    By storesPageVerify = By.xpath("//h1[contains(text(),'Stores')]");
    By editLinkBtn = By.xpath("(//a[contains(text(),'Edit')])[1]");
    By storeNameInput = By.xpath("//input[@value='Your store name']");
    By saveButton = By.xpath("//button[@name='save']");

    public StoresPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToStoresPage() {
        driver.findElement(configurationMenuOption).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(storesSubMenuOption));
        driver.findElement(storesSubMenuOption).click();
        String actual = driver.findElement(storesPageVerify).getText();
        Assert.isTrue(actual.equals("Stores"), "Expected result does not match with actual result");
    }

    public void editStoreName() throws IOException {
        driver.findElement(editLinkBtn).click();
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//TestDataFile.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String storeName = sheet.getRow(1).getCell(4).getStringCellValue();
        driver.findElement(storeNameInput).clear();
        driver.findElement(storeNameInput).sendKeys(storeName);
        driver.findElement(saveButton).click();
    }
}