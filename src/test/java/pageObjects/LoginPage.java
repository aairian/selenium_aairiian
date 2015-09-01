package pageObjects;

import org.openqa.selenium.By;
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

    public VKLoginPage openVKLoginWindow() throws Exception {

        WebElement openPopUpWindowButton = driver.findElement(By.xpath("//a[@class='btn-link-i' and text()='ВКонтакте']"));
        openPopUpWindowButton.click();
        Thread.sleep(5000);

        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String windowId : allWindows) {
               if (driver.switchTo().window(windowId).getTitle().equals("ВКонтакте")) ;
                   }
                 }
        return new VKLoginPage(driver);
    }
}






