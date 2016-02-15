package stepOfDef;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by anny on 14.02.16.
 */
public class MyStepdefs {
    public WebDriver driver;
//    public MyStepdefs (WebDriver driver) {this.driver = driver;}

    @Given("^User is on Home Page$")
    public void User_is_on_Home_Page() throws Throwable {
        System.setProperty("webdriver.chrome.driver",
                "/home/anny/IdeaProjects/main/src/test/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.store.demoqa.com");
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^User Navigate to LogIn Page$")
    public void User_Navigate_to_LogIn_Page() throws Throwable {
        // Express the Regexp above with the code you wish you had
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        throw new PendingException();
    }

}
