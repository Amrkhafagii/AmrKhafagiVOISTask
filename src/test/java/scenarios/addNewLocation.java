package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.*;

public class addNewLocation extends testbase.testannotations {


    @Test(priority = 1)

    public void authenticateAsDefaultAdmin() {

        loginScreen login = new loginScreen(driver);
        landingScreen land = new landingScreen(driver);
        land.openURL();
        land.openAdmin();
        login.loginFirst();

    }


    @Test(priority = 2)
    public void add_verifyNewLocation() {

        dashboardScreen dashboard = new dashboardScreen(driver);
        locationsScreen location = new locationsScreen(driver);
        addLocationScreen addLocation = new addLocationScreen(driver);
        dashboard.openLocationDashboard();
        location.navToAddLocation();
        addLocation.addLocation();
        Assert.assertEquals(location.verifyAddedLocation().contains("egy"), true);

    }

    @Test(priority = 3)
    public void updateNewLocation() {

        locationsScreen location = new locationsScreen(driver);
        addLocationScreen addLocation = new addLocationScreen(driver);
        location.editLocation();
        addLocation.updateLocation();
        Assert.assertEquals(location.verifyAddedLocation().contains("egyHoward"), true);
    }
}
