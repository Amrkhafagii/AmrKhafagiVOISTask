package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class landingScreen {

    WebDriver driver;

    By chooseLogin_btn = By.xpath("//div[@class='col-md-12 form-group']//a[contains(@href,'admin')]");
    String URL = "https://phptravels.com/demo/";


    public landingScreen(WebDriver driver) {

        this.driver = driver;

    }


    public void openURL() {
        driver.navigate().to(URL);

    }

    public void openAdmin() {
        WebElement element = driver.findElement(chooseLogin_btn);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

        ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
        //switch to active tab
        driver.switchTo().window(wid.get(1));


    }

    public void createNewAdmin() {

        dashboardScreen dashboard = new dashboardScreen(driver);
        dashboard.openAdminDashboard();

    }
}
