package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by anny on 22.11.15.
 */
public class SeleniumPractice {


    @Test (description = "WebDriver Browser commands", enabled = false)
    public void browserCommands() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://Store.DemoQA.com");
        String title = driver.getTitle();
        int titleLength = title.length();
        System.out.println("The current title is " + title);
        System.out.println("The title length is " + titleLength);
        driver.getCurrentUrl().equals("http://Store.DemoQA.com");
        int pageSourceLength = driver.getPageSource().length();
        System.out.println("The page source length is " + pageSourceLength);

        driver.quit();

    }

    @Test (description = "WebDriver Browser Navigation commands", enabled = true)
    public void navigationCommands() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String homePage = "http://DemoQA.com";
        driver.get(homePage);
        driver.findElement(By.xpath("//*[@id='menu-item-374']/a")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to(homePage);
        driver.navigate().refresh();
        driver.quit();

    }

}
