package automationFramework;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by anny on 22.11.15.
 */
public class SeleniumPractice extends TestBase{

    @Test(description = "WebDriver Browser commands", enabled = true, priority = 2)
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

    @Test(description = "WebDriver Browser Navigation commands", enabled = true, priority = 1)
    public void navigationCommands() {
        driver.get(URLDemoQA);
        assertEquals(URLDemoQA, driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id='menu-item-374']/a")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to(URLDemoQA);
        driver.navigate().refresh();
    }

    @Test(description = "WebElement commands", enabled = true, priority = 4)
    public void webElementCommands() {
        driver.get(URLToolsQA);
        assertEquals(URLToolsQA, driver.getCurrentUrl());
        WebElement firstNameLoc = driver.findElement(By.name("firstname"));
        firstNameLoc.sendKeys("Anna");
        WebElement lastNameLoc = driver.findElement(By.name("lastname"));
        lastNameLoc.sendKeys("Airiian");
        driver.findElement(By.id("submit")).click();
    }

    @Test(description = "FindElement Commands Method", enabled = true, priority = 3)
    public void findElementCommands() {
        driver.get(URLToolsQA);
        assertEquals(URLToolsQA, driver.getCurrentUrl());
        WebElement patialLinkTestLoc = driver.findElement(By.partialLinkText("Partial"));
        patialLinkTestLoc.click();
        WebElement button = driver.findElement(By.tagName("button"));
        String attName = button.getAttribute("name");
        System.out.println("The attribute of name parameter is " + attName);
        WebElement linkTestLoc = driver.findElement(By.xpath("//*[text() = 'Link Test']"));
        linkTestLoc.click();
    }
    @Test
    public void arrayTask(){

        String [] array = {"a", "b", "c"};
        int aLength = array.length;
        System.out.print(aLength);
    }

}
