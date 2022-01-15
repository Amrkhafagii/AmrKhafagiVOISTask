package cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.*;

public class addNewLocation extends testbase.testannotations {


    @Test(priority = 1)

    public void authenticateAsDefaultAdmin() {

        landingScreen land = new landingScreen(driver);
        land.openURL();
        land.openAdmin();

        loginScreen login = new loginScreen(driver);
        login.loginFirst();

    }


    @Test(priority = 2)
    public void add_verifyNewLocation() {

        dashboardScreen dashboard = new dashboardScreen(driver);
        dashboard.openLocationDashboard();
        locationsScreen location = new locationsScreen(driver);
        location.navToAddLocation();
        addLocationScreen addLocation = new addLocationScreen(driver);
        addLocation.addLocation();
        Assert.assertEquals(location.verifyAddedLocation().contains("egy"), true);


    }

    @Test(priority = 3)
    public void updateNewLocation() {

        locationsScreen location = new locationsScreen(driver);
        location.editLocation();
        addLocationScreen addLocation = new addLocationScreen(driver);
        addLocation.updateLocation();
        Assert.assertEquals(location.verifyAddedLocation().contains("egyHoward"), true);
    }
}
