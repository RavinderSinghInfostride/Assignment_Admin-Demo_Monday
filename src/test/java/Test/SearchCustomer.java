package Test;

import org.testng.annotations.Test;

public class SearchCustomer extends BaseClass{
    @Test
    public void login() {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void searchCustomer()
    {
        pageFactory.getCustomersPage().searchCustomer();
    }
}
