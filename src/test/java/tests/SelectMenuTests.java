package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LeftSideMenu;
import pages.SelectMenuPage;

public class SelectMenuTests extends BaseTest{

    @BeforeClass
    public void beforeClassPreConditions() {
        new HomePage(driver).clickOnWidgets();
        new LeftSideMenu(driver).clickOnSelectMenu();
    }

    @Test
    public void fillFormTest() {
        new SelectMenuPage(driver)
                .fillSelectOne("Mr.")
                .fillOldStyleSelectMenu("Red")
                .fillMultiSelect(new String[]{"Green", "Black"})
                .fillStandartMultiSelect(new String[]{"Volvo", "Opel"});

//        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
//        softAssert.assertTrue(selectMenuPage.verifySlectOne("Mr."));
//        softAssert.assertTrue(selectMenuPage.verifyOldStyleSelectMenu("Red"));
//        softAssert.assertTrue(selectMenuPage.verifyDropDownSelect("Green"));
//        softAssert.assertTrue(selectMenuPage.verifyStandartMultiplySelect("Volvo"));
//
//        softAssert.assertAll();
    }
}

