package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by anny on 23.08.15.
 */
public class NotebooksPage {
    private WebDriver driver;
    private String manufactureName;


    public NotebooksPage(WebDriver driver) {
        this.driver = driver;
    }


    public List<WebElement> listOfManufacture() {

        WebElement manufacturers = driver.findElement(By.xpath("//h4[@class='m-cat-l-i-title' and contains(text(), 'Производители')]/following-sibling::ul"));
        List<WebElement> listOfmanufacturers = manufacturers.findElements(By.tagName("a"));
        return listOfmanufacturers;
    }


    public NotebooksApplePage openManufacture(String manufactureName) {
        for (WebElement manufacture : listOfManufacture()){
            if (manufacture.getText().equals(manufactureName)){
                manufacture.click();
                break;
            }
        }

        return new NotebooksApplePage(driver);
    }
}
