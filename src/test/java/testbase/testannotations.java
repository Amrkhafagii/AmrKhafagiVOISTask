package testbase;

import com.shaft.driver.DriverFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class testannotations {


    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = DriverFactory.getDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));


    }

    @AfterClass
    public void afterClass() {

        DriverFactory.closeAllDrivers();
    }
}
