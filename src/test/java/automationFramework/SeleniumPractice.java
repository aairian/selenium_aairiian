package automationFramework;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;

/**
 * Created by anny on 22.11.15.
 */
public class SeleniumPractice extends TestBase{

    @Test(description = "WebDriver Browser commands", enabled = true)
    public void browserCommands() {
        driver.get(URLStoreQA);
        assertEquals(URLStoreQA, driver.getCurrentUrl());
        String title = driver.getTitle();
        int titleLength = title.length();
        System.out.println("The current title is " + title);
        System.out.println("The title length is " + titleLength);
        int pageSourceLength = driver.getPageSource().length();
        System.out.println("The page source length is " + pageSourceLength);
    }

    @Test(description = "WebDriver Browser Navigation commands", enabled = true)
    public void navigationCommands() {
        driver.get(URLDemoQA);
        assertEquals(URLDemoQA, driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id='menu-item-374']/a")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to(URLDemoQA);
        driver.navigate().refresh();
    }

    @Test(description = "WebElement commands", enabled = false)
    public void webElementCommands() {
        driver.get(URLToolsQA);
        WebElement firstNameLoc = driver.findElement(By.name("firstname"));
        firstNameLoc.sendKeys("Anna");
        WebElement lastNameLoc = driver.findElement(By.name("lastname"));
        lastNameLoc.sendKeys("Airiian");
        driver.findElement(By.id("submit")).click();
        driver.quit();

    }

    @Test(description = "FindElement Commands Method", enabled = false)
    public void findElementCommands() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String homePage = "http://www.toolsqa.com/automation-practice-form/";
        driver.get(homePage);
        WebElement patialLinkTestLoc = driver.findElement(By.partialLinkText("Partial"));
        patialLinkTestLoc.click();
        WebElement button = driver.findElement(By.tagName("button"));
        String attName = button.getAttribute("name");
        System.out.println("The attribute of name parameter is " + attName);
        WebElement linkTestLoc = driver.findElement(By.xpath("//*[text() = 'Link Test']"));
        linkTestLoc.click();
        driver.quit();
    }
}
