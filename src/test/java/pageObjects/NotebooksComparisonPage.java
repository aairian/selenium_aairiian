package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by anny on 31.08.15.
 */
public class NotebooksComparisonPage {
    private WebDriver driver;

    public NotebooksComparisonPage(WebDriver driver){this.driver = driver;}

    public WebElement findPageHeader(){
        WebElement pageTitle = driver.findElement(By.tagName("h1"));
        return pageTitle;

    }

    public WebElement findComparedItem(String itemName){
        List<WebElement> listOfComparedItem = driver.findElements(By.className("g-title"));
        for (WebElement comparedItem : listOfComparedItem){
            if (comparedItem.getText().contains(itemName)){
                return comparedItem;
            }
        }
        return findComparedItem(itemName);
    }
}
