package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

/**
 * Created by anny on 23.08.15.
 */
public class NotebooksApplePage {
    private WebDriver driver;
    private WebElement pageTitle;
    private WebElement expensiveFilter;

    public NotebooksApplePage (WebDriver driver){this.driver=driver;}

    public WebElement findPageTitle(){
        pageTitle = driver.findElement(By.cssSelector(".c-cols-inner-l>h1"));
        return pageTitle;
    }

    public List<WebElement> filterList () throws InterruptedException {

        WebElement filterView = driver.findElement(By.name("drop_link"));
        filterView.click();
        Thread.sleep(5000);

        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String sortListPopWindow : allWindows) {
                if (driver.switchTo().window(sortListPopWindow).getTitle().equals()) {
                }
                WebElement expensiveFilter = driver.findElement(By.xpath("//a[@class='sort-view-l-i-link novisited sprite-side' and contains(text(), 'от дорогих к дешевым')]"));
            }
        }
        return filterList;
    }


    public AppleExpensiveFilterPage setFilter(String filterText) {
        for(WebElement filter : filterList()){
        if (filter.getText().equals(filterText)){
            filter.click();
        }
    }
        return new AppleExpensiveFilterPage(driver);
    }



}



