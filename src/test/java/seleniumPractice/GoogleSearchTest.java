//
//            a1[a1.length - 1 - i] = temp;
//        }
//        System.out.println(Arrays.toString(a1));
//    }
//  }
//
////package bionicUniversityCourse;
////
////import bionicUniversityCourse.core.TestBase;
////import org.testng.annotations.Test;
////import bionicUniversityCourse.pageObjects.GoogleSearchPages;
////
////import static org.testng.Assert.assertTrue;
////
/////**
//// * Created by selenium on 22.07.2015.
//// */
////public class GoogleSearchTest extends TestBase {
////
////
////    private String googleWebSite = "https://www.google.com";
////    private String searchText = "Selenium";
////
////    @Test
////    public void seleniumSearchTest() {
////        GoogleSearchPages onGoogleSearchPages = new GoogleSearchPages(driver);
////        onGoogleSearchPages.open(googleWebSite);
////        onGoogleSearchPages.searchText(searchText);
////        assertTrue(onGoogleSearchPages.findURL().getText().contains(searchText));
////    }
////}
