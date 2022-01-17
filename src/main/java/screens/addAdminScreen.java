package screens;

import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.JSONFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addAdminScreen {


    WebDriver driver;
    JSONFileManager json = new JSONFileManager(System.getProperty("testDataFolderPath") + "adminInfo.json");

    By firstName_label = By.name("fname");
    By lastName_label = By.name("lname");
    By email_label = By.name("email");
    By password_label = By.name("password");
    By mobile_label = By.name("mobile");
    By country_label = By.xpath("//select[@class='chosen-select select2-offscreen']");
    By notiAlert = By.xpath("//h4[@class='ui-pnotify-title']");
    String alertText = "Changes Saved!";


    By updateSettings1_btn = By.xpath("//div[@class='text-end']//button");
    By addLocation_check = By.xpath("//input[@value='addlocationsRentals']");
    By editLocation_check = By.xpath("//input[@value='editlocationsRentals']");

    public addAdminScreen(WebDriver driver) {
        this.driver = driver;
    }

    public void addNewAdmin() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(firstName_label));
        ElementActions.type(driver, firstName_label, json.getTestData("firstName_label"));
        ElementActions.type(driver, lastName_label, json.getTestData("lastName_label"));
        ElementActions.type(driver, email_label, json.getTestData("email_label"));
        ElementActions.type(driver, password_label, json.getTestData("password_label"));
        ElementActions.type(driver, mobile_label, json.getTestData("mobile_label"));
        //error div rather than select
        Select dropd = new Select(driver.findElement(country_label));
        dropd.selectByValue("EG");
        driver.findElement(updateSettings1_btn).click();

    }

    public void updateAdmin()  {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(notiAlert, alertText));
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(addLocation_check)).click();
        //wait.until(ExpectedConditions.invisibilityOfElementWithText(notiAlert,"Changes Saved!"));
        //driver.findElement(addLocation_check).click();
        //driver.findElement(editLocation_check).click();
        wait.until(ExpectedConditions.elementToBeClickable(editLocation_check)).click();
        driver.findElement(updateSettings1_btn).click();

    }
}
