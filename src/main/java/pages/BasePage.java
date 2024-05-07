package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {
    WebDriver driver;
    JavascriptExecutor js;
    static Logger logger = LoggerFactory.getLogger(BasePage.class);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // with chain and @FindBy
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void clickBase(WebElement element) {
        element.click();
    }

    public void clickWithJSScroll(WebElement element, int x, int y) {
        jsScroll(x, y);
        clickBase(element);
    }

    protected void jsScroll(int x, int y) {
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void typeText(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public String getTextBase(WebElement element) {
        return element.getText().trim();
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected boolean isStringsEqual(String actualRes, String expectedRes) {
        if (actualRes.equals(expectedRes)) {
            return true;
        } else {
            System.out.println("actual res: " + actualRes +
                    " expected res " + expectedRes);
            return false;
        }
    }
    protected String getAttributeBase(WebElement el, String attributeName) {
        return el.getAttribute(attributeName);
    }
    protected Keys getKeyForOSCommandOrControl() {
        String os = System.getProperty("os.name");
        System.out.println("my os: " + os);
        if(os.startsWith("Mac")) {
            return Keys.COMMAND;
        } else if(os.startsWith("Win")) {
            return Keys.CONTROL;
        }
        return Keys.CONTROL;
    }

    public void hideIFrames() {
        hideFooter();
        hideBanner();
    }

    private void hideBanner() {
        js.executeScript("document.getElementById('fixedban').style.display='none';");
    }

    private void hideFooter() {
        js.executeScript("document.querySelector('footer').style.display='none';");

    }
}


