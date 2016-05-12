package cucumber.stepOfDef;

import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by anny on 14.03.16.
 */
public class LogInStepDefs {
    public WebDriver driver;
//    public LogInStepDefs (WebDriver driver) {this.driver = driver;}

    @Before
    public void setUP (){
        driver = new FirefoxDriver();
    }

    @Given("^User is on Home Page$")
    public void User_is_on_Home_Page(String homePage)  {
        driver.get("http://www.store.demoqa.com");
        driver.getCurrentUrl().equals(homePage);
        // Express the Regexp above with the code you wish you had
    }

    @When("^User Navigate to LogIn Page$")
    public void User_Navigate_to_LogIn_Page() throws Throwable {
        // Express the Regexp above with the code you wish you had
        driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        throw new PendingException();
    }

}
