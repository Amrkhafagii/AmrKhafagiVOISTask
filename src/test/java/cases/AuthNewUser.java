package cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.dashboardScreen;
import screens.landingScreen;
import screens.loginScreen;

public class AuthNewUser extends testbase.testannotations {


    @Test(priority = 1)
    public void authenticateAsNewAdmin() {

        landingScreen land = new landingScreen(driver);
        land.openURL();
        land.openAdmin();
        loginScreen login = new loginScreen(driver);
        login.loginNewAdmin();
        dashboardScreen dashboard = new dashboardScreen(driver);
        //the site delete always the new accounts created so, it may not loggin and gives error
        Assert.assertEquals(dashboard.verifyLogin().contains("Dashboard"), true);

    }


}
