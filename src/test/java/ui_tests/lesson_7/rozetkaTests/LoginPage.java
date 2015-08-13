package ui_tests.lesson_7.rozetkaTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;



/**
 * Created by anny on 12.08.15.
 */
public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public VKLoginPage openVKLoginWindow() throws InterruptedException {
        String currentWindowId = driver.getWindowHandle();
        WebElement openPopUpWindowButton = driver.findElement(By.xpath("//a[@class='btn-link-i' and text()='ВКонтакте']"));
        openPopUpWindowButton.click();

        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String windowId : allWindows) {
                try {
                    if (driver.switchTo().window(windowId).getTitle().equals("ВКонтакте")) ;
                driver.close();
                    break;
                }
                catch(NoSuchWindowException e) {
                    e.printStackTrace();
                }
            }
        }
        return new VKLoginPage(driver);
    }
}






