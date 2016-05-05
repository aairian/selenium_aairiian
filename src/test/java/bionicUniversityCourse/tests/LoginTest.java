package bionicUniversityCourse.tests;

import bionicUniversityCourse.core.TestBase;
import bionicUniversityCourse.pageObjects.HomePage;
import bionicUniversityCourse.pageObjects.LoginPage;
import bionicUniversityCourse.pageObjects.PersonalDataPage;
import bionicUniversityCourse.pageObjects.VKLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by anny on 05.05.16.
 */
public class LoginTest extends TestBase {

    public LoginTest (WebDriver driver){ this.driver = driver;}

    @Test(enabled = false)
    public void loginWithVKAccountTest () throws Exception {
        HomePage home = new HomePage(driver);
        LoginPage loginPage = home.openLoginPopWindow();
        VKLoginPage vkLoginPage = loginPage.openVKLoginWindow();
        HomePage user = vkLoginPage.entranceWithValidCredentials(login, password);
        assertTrue(user.findUserName().getText().contains(userName));
        PersonalDataPage myPersonalData = user.openPersonalData();
        assertTrue(myPersonalData.findTitle().getText().contains(personalDataText));

    }

}
