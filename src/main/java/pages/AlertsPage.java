package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    WebElement btnAlert5Sec;

    @FindBy(xpath = "//span[@id='promptResult']")
    WebElement textFromPrompt;

    @FindBy(xpath = "//button[@id='promtButton']")
    WebElement btnOpenPromptAlert;

    private Alert getAlert() {
        return driver.switchTo().alert();
    }

    public AlertsPage clickAccept(Alert alert) {
        alert.accept();
        return this;
    }

    public AlertsPage clickDismiss(Alert alert) {
        alert.dismiss();
        return this;
    }

    private void typeInAlertPrompt(String text, Alert alert) {
        alert.sendKeys(text);
    }

    private String getMessageAlert(Alert alert) {
        return alert.getText().trim();
    }

    public AlertsPage closeAlertIfPresent() {
        try {
            clickAccept(getAlert());
        } catch (Exception e) {
            logger.info("alert not displays");
        }
        return this;
    }

    private void waitForAlertPresent(int time) {
        new WebDriverWait(driver, Duration.ofSeconds(time))
                .until(ExpectedConditions.alertIsPresent());
    }


    public boolean verifyAlert5SecsOpen() {
        clickWithJSScroll(btnAlert5Sec, 0, 300);
        pause(5200);
        Alert alert = getAlert();
        String expectedRes = "This alert appeared after 5 seconds";
        String actualRes = getMessageAlert(alert);
        clickAccept(alert);
        return expectedRes.equals(actualRes);
    }

    public boolean verifyTextFromPromptDisplaysCorrect(String text) {
        clickWithJSScroll(btnOpenPromptAlert, 0, 500);
        waitForAlertPresent(2);
        Alert alert = getAlert();
        typeInAlertPrompt(text, alert);
        clickAccept(alert);
        String actualRes = getTextBase(textFromPrompt);
        return actualRes.contains(text);
    }
}
