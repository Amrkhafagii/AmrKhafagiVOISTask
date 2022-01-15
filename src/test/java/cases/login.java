package cases;

import org.testng.annotations.Test;
import screens.*;

public class login extends testbase.testannotations {


    @Test(priority = 1)

    public void authenticateAsDefaultAdmin() {

        landingScreen land = new landingScreen(driver);
        land.openURL();
        land.openAdmin();

        loginScreen login = new loginScreen(driver);
        login.loginFirst();

    }

    @Test(priority = 2)

    public void createNewAdmin() {

        dashboardScreen dashboard = new dashboardScreen(driver);
        dashboard.openAdminDashboard();
        dashboardAdminScreen dashboardAdmin = new dashboardAdminScreen(driver);
        dashboardAdmin.navToAddAdmin();
        addAdminScreen addAdmin = new addAdminScreen(driver);
        addAdmin.addNewAdmin();

    }

    @Test(priority = 3)

    public void editNewAdminPermission() throws InterruptedException {

        dashboardAdminScreen dashboardAdmin = new dashboardAdminScreen(driver);
        dashboardAdmin.navToEditAdmin();
        addAdminScreen addAdmin = new addAdminScreen(driver);
        addAdmin.updateAdmin();

    }


}
