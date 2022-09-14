package Test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EditCustomerName extends BaseClass {
    @Test
    public void login() throws IOException {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void editCustomerName()
    {
        pageFactory.getCustomersPage().visitCustomersPage();
        pageFactory.getCustomersPage().editCustomerName();
    }
}