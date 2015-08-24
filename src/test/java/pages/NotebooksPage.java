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
    private String manufactureName = "Apple";


    public NotebooksPage(WebDriver driver) {
        this.driver = driver;
    }


    public List<WebElement> findListOfManufacture() {

        WebElement manufacturers = driver.findElement(By.xpath("//h4[@class='m-cat-l-i-title' and contains(text(), 'Производители')]/following-sibling::ul"));
        List<WebElement> listOfmanufacturers = manufacturers.findElements(By.tagName("a"));
        return listOfmanufacturers;
    }


    public NotebooksApplePage findOpenAppleManufacture() {
        int iSize = findListOfManufacture().size();
        for (int i = 0; i <= iSize; i++) {
            if (findListOfManufacture().get(i).equals(manufactureName));
            {
                WebElement manufacture = driver.
                        findElement(By.xpath("//a[@class='m-cat-subl-i-link' and contains(text(), 'Apple')]"));
                manufacture.click();
                break;
            }
        }
        return new NotebooksApplePage(driver);
    }
}
