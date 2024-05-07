package tests;

import org.testng.annotations.Test;
import pages.BrokenLinksPage;

public class BrokenLinksTests extends BaseTest{
    @Test
    public void brokenLinksTests() {
        // this is wrong
        driver.navigate().to("https://demoqa.com/broken");
        new BrokenLinksPage(driver).checkBrokenLinks();
    }

    @Test
    public void brokenImagesTest() {
        // this is wrong
        driver.navigate().to("https://demoqa.com/broken");
        new BrokenLinksPage(driver).checkBrokenImages();
    }
}
