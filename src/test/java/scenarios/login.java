package scenarios;

import org.testng.annotations.Test;
import screens.*;

public class login extends testbase.testannotations {


    @Test(priority = 1)

    public void authenticateAsDefaultAdmin() {
        loginScreen login = new loginScreen(driver);
        landingScreen land = new landingScreen(driver);
        land.openURL();
        land.openAdmin();
        login.loginFirst();

    }

    @Test(priority = 2)

    public void createNewAdmin() {
        dashboardScreen dashboard = new dashboardScreen(driver);
        dashboardAdminScreen dashboardAdmin = new dashboardAdminScreen(driver);
        addAdminScreen addAdmin = new addAdminScreen(driver);
        dashboard.openAdminDashboard();
        dashboardAdmin.navToAddAdmin();
        addAdmin.addNewAdmin();

    }

    @Test(priority = 3)

    public void editNewAdminPermission() {

        dashboardAdminScreen dashboardAdmin = new dashboardAdminScreen(driver);
        addAdminScreen addAdmin = new addAdminScreen(driver);
        dashboardAdmin.navToEditAdmin();
        addAdmin.updateAdmin();

    }


}
