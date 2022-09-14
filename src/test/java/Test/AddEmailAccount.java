package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class AddEmailAccount extends BaseClass{
    @Test
    public void login() throws IOException {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void navigateToEmailAccountsPage() {
        pageFactory.getEmailAccountsPage().navigateToEmailAccountsPage();
    }

    @Test(dependsOnMethods = "navigateToEmailAccountsPage")
    public void addEmailAccount() throws IOException {
        pageFactory.getEmailAccountsPage().addEmailAccount();
    }
}