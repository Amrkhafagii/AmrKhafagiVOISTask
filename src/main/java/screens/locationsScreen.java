package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class locationsScreen {


    WebDriver driver;

    By location_text = By.xpath("//tr[@class='xcrud-row xcrud-row-0']//td[contains(text(),'egy')]");
    By editLocation_btn = By.xpath("//i[@class='fa fa-edit']");
    By addLocation_btn = By.xpath("//form[@class='add_button']//button[@type='submit']");
    By deleteLocation_btn = By.xpath("//i[@class='fa fa-times']");
    By addedLocation = By.xpath("//td[contains(text(),'1')]/following-sibling::td");


    public locationsScreen(WebDriver driver) {

        this.driver = driver;
    }

    public void navToAddLocation() {

        driver.findElement(addLocation_btn).click();
    }

    public String verifyAddedLocation() {

        String Text = driver.findElement(addedLocation).getText();
        return Text;
    }

    public void editLocation() {
        driver.findElement(editLocation_btn).click();

    }

    public void removeLocation() {
        driver.findElement(editLocation_btn).click();
        driver.switchTo().alert().accept();


    }
}
