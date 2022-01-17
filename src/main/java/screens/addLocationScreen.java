package screens;

import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.JSONFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class addLocationScreen {


    WebDriver driver;
    JSONFileManager json = new JSONFileManager(System.getProperty("testDataFolderPath") + "locations.json");

    By country_label = By.xpath("//select[@class='chosen-select select2-offscreen']");
    By location_label = By.id("location");
    By longtitude_label = By.id("long");
    By latitude_label = By.id("lat");
    By submit_btn = By.xpath("//button[@type='submit']");
    String countrySelect="Egypt,EG";


    public addLocationScreen(WebDriver driver) {

        this.driver = driver;
    }

    public void addLocation() {

        Select dropd = new Select(driver.findElement(country_label));
        dropd.selectByValue(countrySelect);
        // driver.findElement(country_label).sendKeys("egypt");
       // driver.findElement(location_label).sendKeys("egy");
        ElementActions.type(driver, location_label, json.getTestData("location_label[0]"));
        ElementActions.type(driver, longtitude_label, json.getTestData("longtitude_label[0]"));
        ElementActions.type(driver, latitude_label, json.getTestData("latitude_label[0]"));
        driver.findElement(submit_btn).click();
    }

    public void updateLocation() {

        Select dropd = new Select(driver.findElement(country_label));
        dropd.selectByValue(countrySelect);
        // driver.findElement(country_label).sendKeys("egypt");
        ElementActions.type(driver, location_label, json.getTestData("location_label[1]"));
        ElementActions.type(driver, longtitude_label, json.getTestData("longtitude_label[1]"));
        ElementActions.type(driver, latitude_label, json.getTestData("latitude_label[1]"));
        driver.findElement(submit_btn).click();
    }
}
