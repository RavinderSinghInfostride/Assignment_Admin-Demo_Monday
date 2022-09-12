package Test;

import org.testng.annotations.Test;

public class EditCustomerName extends BaseClass {
    @Test
    public void login() {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void visitCustomerPage()
    {
        pageFactory.getCustomersPage().visitCustomersPage();
        pageFactory.getCustomersPage().editCustomerName();
    }
}