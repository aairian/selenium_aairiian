package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by anny on 23.08.15.
 */
public class NotebooksApplePage {
    private WebDriver driver;
    private WebElement pageTitle;

    public NotebooksApplePage (WebDriver driver){this.driver=driver;}

    public WebElement findPageTitle(){
        pageTitle = driver.findElement(By.cssSelector(".c-cols-inner-l>h1"));
        return pageTitle;
    }



}
