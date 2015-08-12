package ui_tests.lesson_7.rozetkaTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

/**
 * Created by anny on 12.08.15.
 */
public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openLoginPopWindow() {
        String parentWindowId = driver.getWindowHandle();
        WebElement openPopUpWindowButton = driver.findElement(By.name("signin"));
        openPopUpWindowButton.click();

        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String windowId : allWindows) {
                if (driver.switchTo().window(windowId).getTitle().equals("Вход в интернет-магазин")) ;
                driver.close();
            }
        }
        return new LoginPage(driver);
    }
}
