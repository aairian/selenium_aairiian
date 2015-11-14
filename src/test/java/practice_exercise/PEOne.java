package practice_exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by anny on 14.11.15.
 */

public class PEOne {

    @Test (enabled = true)
    public void browserCommands(){
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
