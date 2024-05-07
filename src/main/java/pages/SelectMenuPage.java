package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class SelectMenuPage extends BasePage{
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Select Option')]")
    WebElement fieldSelectMenu;

    @FindBy(xpath = "//select[@id='oldSelectMenu']")
    WebElement selectDropDown;

    @FindBy(xpath="//div[@id='selectOne']")
    WebElement selectOne;

    @FindBy(id = "react-select-4-input")
    WebElement multiselect;

    @FindBy(className = "text-center")
    WebElement pageTitle;

    @FindBy(id = "cars")
    WebElement multiSelectForm;

    @FindBy(xpath = "//div[contains(@id,'react-select')]")
    List<WebElement> allDataInSelectOne;

    @FindBy(xpath = "//div[@id='selectOne']//div[contains(@class,'placeholder')]")
    WebElement inputSelectOne;

    public SelectMenuPage fillSelectValue(String str) {
        clickWithJSScroll(fieldSelectMenu, 0, 400);
        //some function to click on text
        return this;
    }

    public SelectMenuPage fillSelectOne(String str) {
        jsScroll(0,400);
        clickBase(inputSelectOne);
        for(WebElement el : allDataInSelectOne) {
            if(getTextBase(el).equals(str)) {
                clickWithJSScroll(el, 0, 150);
                break;
            }
        }
        pause(5000);
        return this;
    }

    public SelectMenuPage fillOldStyleSelectMenu(String str) {
        Select select = new Select(selectDropDown);
        select.selectByVisibleText(str);

        List<WebElement> options = select.getOptions();
        for(WebElement element: options) {
            if(getTextBase(element).equals(str)) {
                clickBase(element);
                break;
            }
        }
        return this;
    }

    public SelectMenuPage fillMultiSelect(String[] colors) {
        for(String color: colors) {
            multiselect.sendKeys(color);
            multiselect.sendKeys(Keys.ENTER);
        }
        clickBase(pageTitle);
        pause(5000);
        return this;
    }

    public SelectMenuPage fillStandartMultiSelect(String[] strings) {
        Select select = new Select(multiSelectForm);
        List<WebElement> options = select.getOptions();

        Keys key = getKeyForOSCommandOrControl();
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();

        for(String str : strings) {
            for(WebElement element: options) {
                if(getTextBase(element).equals(str)) {
                    clickBase(element);
                    break;
                }
            }
        }

        return this;
    }

}
