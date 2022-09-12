package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static net.jodah.failsafe.internal.util.Assert.isTrue;

public class CustomersPage {
    WebDriver driver;

    String customerEmail = "victoria_victoria@nopCommerce.com";
    String newFirstName = "Ravinder";

    By customerMenuOption = By.xpath("(//li[contains(@class,'has-treeview')])[4]");
    By customerSubMenuOption = By.xpath("(//li[@class='nav-item']//a[@class='nav-link'])[17]");
    By customerPageVerify = By.xpath("//h1[contains(text(),'Customers')]");
    By customerEmailInput = By.xpath("//input[@id='SearchEmail']");
    By customerSearchBtn = By.xpath("//button[@id='search-customers']");
    By editCustomerLink = By.xpath("//td[@class=' button-column']/a[contains(@class,'btn-default')]");
    By firstNameEditInput = By.xpath("//input[@id='FirstName']");
    By saveEditButton = By.xpath("(//div[@class='float-right']//button[contains(@class,'btn-primary')])[1]");
    By confirmMessage = By.xpath("//div[contains(@class,'alert-succe')]");
    By verifyCustomerSearch = By.xpath("//td[contains(text(),'victoria_victoria@nopCommerce.com')]");

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void visitCustomersPage() {
        driver.findElement(customerMenuOption).click();
        driver.findElement(customerSubMenuOption).click();
        String actual = driver.findElement(customerPageVerify).getText();
        isTrue(actual.equals("Customers"), "Expected result does not match with actual result");
    }

    public void editCustomerName() {
        driver.findElement(customerEmailInput).sendKeys(customerEmail);
        driver.findElement(customerSearchBtn).click();
        driver.findElement(editCustomerLink).click();
        driver.findElement(firstNameEditInput).clear();
        driver.findElement(firstNameEditInput).sendKeys(newFirstName);
        driver.findElement(saveEditButton).click();
        boolean isAdminDisplayed = driver.findElement(confirmMessage).isDisplayed();
        Assert.assertTrue(isAdminDisplayed, "User is not added");
    }

    public void searchCustomer()
    {
        driver.findElement(customerMenuOption).click();
        driver.findElement(customerSubMenuOption).click();
        String actual = driver.findElement(customerPageVerify).getText();
        isTrue(actual.equals("Customers"), "Expected result does not match with actual result");
        driver.findElement(customerEmailInput).sendKeys(customerEmail);
        driver.findElement(customerSearchBtn).click();
        boolean isCustomerDisplayed = driver.findElement(verifyCustomerSearch).isDisplayed();
        Assert.assertTrue(isCustomerDisplayed, "Customer not present");
    }
}