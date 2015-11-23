package automationFramework;

import core.BrowserFactory;
import core.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.*;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by anny on 09.08.15.
 */
public class RozetkaTests extends TestBase{


    @Test (enabled = false)
    public void seleniumCourseFinalTask() throws InterruptedException {
        HomePage home = new HomePage(driver);
        ComputersNotebooksPage onComputerNotebooksPage = home.openComputersNotebooks();
        assertTrue(onComputerNotebooksPage.findTitle().getText().contains(computersNotebooksTitleText));
        NotebooksPage onNotebooksPage = onComputerNotebooksPage.verifyNumberOfNotebooksVariantsAndSelectAllNotebooksLink();

        assertEquals(9, onNotebooksPage.listOfManufacture().size());
        NotebooksApplePage onNotebooksApplePage = onNotebooksPage.openManufacture(appleManufacture);
        assertTrue(onNotebooksApplePage.findPageTitle().getText().contains(appleNotebooksPageTitleText));
        AppleExpensiveFilterPage onAppleExpensiveFilterPage = onNotebooksApplePage.setFilter(expensivefilter);

        assertTrue(onAppleExpensiveFilterPage.findItem(appleMacBookProRetinaZ0QP000X6).getText().contains(appleMacBookProRetinaZ0QP000X6));
        AppleExpensiveFilterPage comparisonItemOne = onAppleExpensiveFilterPage.addToCompare(appleMacBookProRetinaZ0QP000X6);
        assertTrue(comparisonItemOne.findItemInCompareList(appleMacBookProRetinaZ0QP000X6).getText().contains(appleMacBookProRetinaZ0QP000X6));

        assertTrue(onAppleExpensiveFilterPage.findItem(appleMacBookProRetinaMGXA2UA).getText().contains(appleMacBookProRetinaMGXA2UA));
        AppleExpensiveFilterPage comparisonItemTwo = onAppleExpensiveFilterPage.addToCompare(appleMacBookProRetinaMGXA2UA);
        assertTrue(comparisonItemTwo.findItemInCompareList(appleMacBookProRetinaMGXA2UA).getText().contains(appleMacBookProRetinaMGXA2UA));

        NotebooksComparisonPage comparisonNotebooks = onAppleExpensiveFilterPage.compareItems();
        assertTrue(comparisonNotebooks.findPageHeader().getText().contains(comparisonPageHeaderText));

        assertTrue(comparisonNotebooks.findComparedItem(appleMacBookProRetinaZ0QP000X6).getText().contains(appleMacBookProRetinaZ0QP000X6));
        assertTrue(comparisonNotebooks.findComparedItem(appleMacBookProRetinaMGXA2UA).getText().contains(appleMacBookProRetinaMGXA2UA));

    }

    @Test (enabled = false)
    public void loginWithVKAccountTest () throws Exception {
        HomePage home = new HomePage(driver);
        LoginPage loginPage = home.openLoginPopWindow();
        VKLoginPage vkLoginPage = loginPage.openVKLoginWindow();
        HomePage user = vkLoginPage.entranceWithValidCredentials(login, password);
        assertTrue(user.findUserName().getText().contains(userName));
        PersonalDataPage myPersonalData = user.openPersonalData();
        assertTrue(myPersonalData.findTitle().getText().contains(personalDataText));

    }

    @Test (enabled = false)
    public void sampleTest002()
    {
        WebDriver driver = BrowserFactory.getBrowser("Chrome");


        //Test that both the browsers are actually only one instance of chrome driver
        WebDriver driver1 = BrowserFactory.getBrowser("Chrome");
        if(driver.equals(driver1))
        {
            System.out.println("The two chrome drivers are same");
        }
    }


    @AfterTest
    public void tearDown() {
        BrowserFactory.closeAllDriver();
    }


}
