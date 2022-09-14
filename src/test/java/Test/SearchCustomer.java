package Test;

import org.testng.annotations.Test;

import java.io.IOException;

public class SearchCustomer extends BaseClass{
    @Test
    public void login() throws IOException {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void searchCustomer()
    {
        pageFactory.getCustomersPage().searchCustomer();
    }
}
