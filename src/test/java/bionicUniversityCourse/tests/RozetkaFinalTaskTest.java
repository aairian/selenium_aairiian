package bionicUniversityCourse.tests;

import bionicUniversityCourse.core.BrowserFactory;
import bionicUniversityCourse.core.TestBase;
import bionicUniversityCourse.pageObjects.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by anny on 09.08.15.
 */
public class RozetkaFinalTaskTest extends TestBase{


    @Test (enabled = true)
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



    @AfterTest
    public void tearDown() {
        BrowserFactory.closeAllDriver();
    }


}
