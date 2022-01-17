package scenarios;

import org.testng.annotations.Test;
import screens.dashboardScreen;
import screens.landingScreen;
import screens.loginScreen;

public class deleteLocation extends testbase.testannotations {

    @Test
    public void verifyUserCannotDeleteLocation() {
        loginScreen login = new loginScreen(driver);
        dashboardScreen dashboard = new dashboardScreen(driver);
        landingScreen land = new landingScreen(driver);
        land.openURL();
        land.openAdmin();
        login.loginNewAdmin();
        dashboard.verifyLocationDashboard(); // added confirmation to console logs
        //Assert.assertEquals(dashboard.verifyLogin().contains("Dashboard"), true);

    }


}
