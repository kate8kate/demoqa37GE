package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DroppablePage extends BasePage{
    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement elementDrop;

    @FindBy(id = "droppable")
    WebElement elementToDrag;

    public DroppablePage actionsDragMe() {
        Actions actions = new Actions(driver);
        jsScroll(0, 550);
        actions.dragAndDrop(elementDrop, elementToDrag).perform();
        pause(10000);
        return this;
    }
}