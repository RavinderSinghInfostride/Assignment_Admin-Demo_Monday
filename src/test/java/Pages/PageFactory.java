package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private LoginPage loginPage;
    private EmailAccountsPage emailAccountsPage;
    private StoresPage storesPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public EmailAccountsPage getEmailAccountsPage() {
        if (emailAccountsPage == null) {
            emailAccountsPage = new EmailAccountsPage(driver);
        }
        return emailAccountsPage;
    }

    public StoresPage getStoresPage() {
        if (storesPage == null) {
            storesPage = new StoresPage(driver);
        }
        return storesPage;
    }
}