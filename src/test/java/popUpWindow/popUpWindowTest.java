package popUpWindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by selenium on 10.08.2015.
 */
public class popUpWindowTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp (){
        driver = new FirefoxDriver();
        driver.get("http://www.quackit.com/html/codes/html_popup_window_code.cfm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

    @Test
    public void popUpWindowWithTitle(){
        String parentWindowId = driver.getWindowHandle();
        WebElement openPopUpWindowButton = driver.findElement(By.xpath("html/body/div[1]/div/article/div[2]/div[2]/div[2]/div/h4/a"));
        openPopUpWindowButton.click();

        Set<String> allWindows = driver.getWindowHandles();
        if(!allWindows.isEmpty()){
            for (String windowId : allWindows){
                if (driver.switchTo().window(windowId).getTitle().equals("Open a popup window"));
                driver.close();
            }
        }
    }

    @AfterTest
    public void tearDown()

    {
        driver.quit();
    }

}

