package cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.dashboardScreen;
import screens.landingScreen;
import screens.loginScreen;

public class deleteLocation extends testbase.testannotations {


    @Test
    public void verifyUserCannotDeleteLocation() {

        landingScreen land = new landingScreen(driver);
        land.openURL();
        land.openAdmin();
        loginScreen login = new loginScreen(driver);
        login.loginNewAdmin();

        dashboardScreen dashboard = new dashboardScreen(driver);
        dashboard.verifyLocationDashboard();
        //Assert.assertEquals(dashboard.verifyLogin().contains("Dashboard"), true);

    }


}
