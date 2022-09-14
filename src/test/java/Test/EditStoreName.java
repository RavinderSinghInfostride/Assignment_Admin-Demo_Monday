package Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class EditStoreName extends BaseClass {
    @Test
    public void login() throws IOException {
        pageFactory.getLoginPage().login();
    }

    @Test(dependsOnMethods = "login")
    public void navigateToStoresPage() {
        pageFactory.getStoresPage().navigateToStoresPage();
    }

    @Test(dependsOnMethods = "navigateToStoresPage")
    public void editStoreName() throws IOException{
        pageFactory.getStoresPage().editStoreName();
    }
}