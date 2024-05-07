package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage{
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@id='tabButton']")
    WebElement btnNewTab;

    public BrowserWindowsPage openSamplePage() {
        clickWithJSScroll(btnNewTab, 0, 300);
        return this;
    }

    public SamplePage switchToSamplePage(int index) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        //System.out.println(windows.get(index));
        return new SamplePage(driver);
    }
}
