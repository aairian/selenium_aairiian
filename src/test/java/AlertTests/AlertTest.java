package AlertTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by selenium on 10.08.2015.
 */
public class AlertTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp (){
        driver = new FirefoxDriver();
        driver.get("http://www.quackit.com/javascript/codes/javascript_prompt.cfm");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

    @Test

    public void testPrompt(){
        WebElement alertFrame = driver.findElement(By.xpath("html/body/div[1]/div/article/div[2]/div[2]/div[2]/iframe"));
        driver.switchTo().frame(alertFrame);
        WebElement button = driver.findElement(By.xpath("html/body/input"));
        button.click();

            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            alert.sendKeys("Google");
            alert.accept();



    }
}
