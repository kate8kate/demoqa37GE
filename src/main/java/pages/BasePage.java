package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    WebDriver driver;
    JavascriptExecutor js;

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
        js.executeScript("window.scrollBy(${x},${y})");
        clickBase(element);
    }
    public void typeText(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys();
    }
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
