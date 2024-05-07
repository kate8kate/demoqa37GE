package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SamplePage extends BasePage{
    public SamplePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1")
    WebElement textTitle;

    public boolean verifySamplePageOpen() {
        String actualRes = getTextBase(textTitle);
        String expectedRes = "This is a sample page";
        return isStringsEqual(actualRes, expectedRes);
    }

    public BrowserWindowsPage switchToBrowserWindowPage(int index) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        //System.out.println(windows.get(index));
        return new BrowserWindowsPage(driver);
    }

    public SamplePage closeCurrentTab() {
        driver.close();
        return this;
    }
}
