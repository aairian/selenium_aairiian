package ui_tests.lesson_7.rozetkaTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.openqa.selenium.By.xpath;

/**
 * Created by anny on 12.08.15.
 */
public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public VKLoginPage openVKLoginWindow() {
//        String parentWindowId = driver.getWindowHandle();
        WebElement openPopUpWindowButton = driver.findElement(By.xpath("//a[@class='btn-link-i' and text()='ВКонтакте']"));
        openPopUpWindowButton.click();
        //add waiting
        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String windowId : allWindows) {
                if (driver.switchTo().window(windowId).getTitle().equals("ВКонтакте")) ;
                driver.close();
            }
        }
        return new VKLoginPage(driver);
    }
}






