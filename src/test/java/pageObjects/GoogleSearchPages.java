package pageObjects;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by selenium on 29.07.2015.
 */
public class GoogleSearchPages extends TestBase{
    private WebElement searchField;
    private WebElement searchLink;
    private WebDriver driver;

    public void searchText (String searchText){
        searchField = driver.findElement(By.id("gs_htif0"));
        searchField.sendKeys(searchText);
    }

    public void open (String URL){
        driver.get(URL);
    }

    public GoogleSearchPages(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findURL (){
      searchLink = driver.findElement(By.xpath(".//*[@id='rso']/div[2]/li[1]/div/h3/a"));
      return searchLink;
    }
}
