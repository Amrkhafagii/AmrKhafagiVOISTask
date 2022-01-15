package screens;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboardScreen {


    WebDriver driver;
    By accounts_btn = By.xpath("//div[@class='nav-link-icon']//i[contains(text(),'people')]");
    By admin_btn = By.xpath("//div[@id='collapseLayouts']//a[contains(@href,'admins')]");
    By preLocation_btn = By.xpath("//i[contains(text(),'fa fa-map-marker')]");
    By location_btn = By.xpath("//a[contains(text(),'Locations')]");
    By menu_btn = By.id("drawerToggle");
    By title = By.xpath("//h1[contains(text(),'Dashboard')]");


    public dashboardScreen(WebDriver driver) {
        this.driver = driver;
    }

    public void openAdminDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(menu_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(accounts_btn)).click();
        driver.findElement(admin_btn).click();
    }

    public void openLocationDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(menu_btn)).click();
        WebElement element = driver.findElement(location_btn);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

        //driver.findElement(location_btn).click();

    }


    public String verifyLogin() {

        String Text = driver.findElement(title).getText();
        return Text;
    }

    public void verifyLocationDashboard() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(menu_btn)).click();

        try {
            driver.findElement(location_btn).click();
        } catch (NoSuchElementException e) {
            System.out.println("user cannot delete location");
        }
    }


}
