package iframeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by selenium on 10.08.2015.
 */
public class iframeTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp (){
        driver = new FirefoxDriver();
        driver.get("http://www.quackit.com/html/templates/frames/frames_example_1.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

    @Test
    public void iframeSwich(){
        driver.switchTo().frame("menu");
        WebElement menu = driver.findElement(By.xpath("html/body/h3"));
        assertEquals("Menu 1", menu.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("content");
        WebElement content = driver.findElement(By.xpath("html/body/h1"));
        assertEquals("Content", content.getText());

   }

    @AfterTest
    public void tearDown()

    {
        driver.quit();
    }

}
