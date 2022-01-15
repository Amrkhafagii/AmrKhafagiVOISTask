package screens;

import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.JSONFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginScreen {

    WebDriver driver;
    JSONFileManager json = new JSONFileManager(System.getProperty("testDataFolderPath") + "loginInfo.json");

    By emailLabel = By.xpath("//input[@name='email']");
    By passwordLabel = By.xpath("//input[@name='password']");
    By login_btn = By.xpath("//button[@type='submit']");


    public loginScreen(WebDriver driver) {

        this.driver = driver;
    }

    public void loginFirst() {

        //.switchToWindow(driver,"Administator Login");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        // wait.until(ExpectedConditions.elementToBeClickable(emailLabel)).sendKeys("admin@phptravels.com");

        wait.until(ExpectedConditions.elementToBeClickable(emailLabel));
        ElementActions.type(driver, emailLabel, json.getTestData("emailLabel[0]"));
        ElementActions.type(driver, passwordLabel, json.getTestData("passwordLabel[0]"));
        driver.findElement(login_btn).click();

    }

    public void loginNewAdmin() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(emailLabel));
        ElementActions.type(driver, emailLabel, json.getTestData("emailLabel[1]"));
        ElementActions.type(driver, passwordLabel, json.getTestData("passwordLabel[1]"));
        driver.findElement(login_btn).click();

    }


}
