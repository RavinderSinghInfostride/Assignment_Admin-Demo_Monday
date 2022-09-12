package Test;

import Pages.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
    protected PageFactory pageFactory;
    WebDriver driver;

    By logoutButton = By.xpath("//a[contains(text(),'Logout')]");

    @Parameters("browserName")
    @BeforeClass
    public void setup(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://admin-demo.nopcommerce.com");
            pageFactory = new PageFactory(driver);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://admin-demo.nopcommerce.com");
            pageFactory = new PageFactory(driver);
        }
    }

    @AfterClass
    public void close() {
        driver.findElement(logoutButton).click();
        driver.close();
    }
}