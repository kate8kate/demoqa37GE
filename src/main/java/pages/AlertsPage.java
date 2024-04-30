package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }
    public void clickAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void clickDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void typeAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }
    public String getMassageAlert() {
        Alert alert = driver.switchTo().alert();
        return alert.getText().trim();
    }

}
