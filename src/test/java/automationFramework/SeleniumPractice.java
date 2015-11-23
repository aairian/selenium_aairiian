package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Created by anny on 22.11.15.
 */
public class SeleniumPractice {


    @Test (description = "WebDriver Browser commands", enabled = true)
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
}