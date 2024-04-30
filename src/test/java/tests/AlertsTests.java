package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertsTests extends BaseTest{

    @BeforeClass
    public void classPreconditions() {
        // click on alerts frame on main page

        // click on alerts on left menu
    }

    @AfterMethod
    public void postConditionAfterMethod() {
        // closeAlertIfPresent()
    }
    @Test
    public void fifeSecondsWaitAlertOpen() {

    }
}
