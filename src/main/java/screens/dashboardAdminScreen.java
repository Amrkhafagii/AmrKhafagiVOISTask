package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboardAdminScreen {


    WebDriver driver;
    By addAccount_btn = By.xpath("//form[@class='add_button']//button[@type='submit']");
    By editAccount_btn = By.xpath("//i[@class='fa fa-edit']");


    public dashboardAdminScreen(WebDriver driver) {

        this.driver = driver;
    }


    public void navToAddAdmin() {
        driver.findElement(addAccount_btn).click();

    }

    public void navToEditAdmin() {

        driver.findElement(editAccount_btn).click();
    }
}
