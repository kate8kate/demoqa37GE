package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BrowserWindowsPage;
import pages.HomePage;
import pages.LeftSideMenu;
import pages.SamplePage;

public class BrowserWindowsTests extends BaseTest{
    @BeforeClass
    public void classPreconditions() {
        new HomePage(driver).clickOnAlertsFrames();
        new LeftSideMenu(driver).clickOnWindows();
    }

    @AfterClass
    public void classPostConditions() {
        // go to main tab and close all other tabs
        // close all tabs, except current
        new HomePage(driver).navigateToHomePage();
    }

    @AfterMethod
    public void afterMethodPostConditions() {
        new SamplePage(driver).closeCurrentTab()
                .switchToBrowserWindowPage(0);
    }
    @Test
    public void isNewHandlerOpen() {
        Assert.assertTrue(new BrowserWindowsPage(driver)
                .openSamplePage()
                .switchToSamplePage(1)
                .verifySamplePageOpen());
    }
}
