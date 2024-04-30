package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.AlertsPage;
import pages.HomePage;
import pages.LeftSideMenu;

import java.time.Duration;

public class ApplicationManager {

    static WebDriver driver;
    String browser;
    AlertsPage alertsPage;
    HomePage homePage;
    LeftSideMenu leftSideMenu;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals("chrome")) {
            // with tools:
            //driver = new ChromeDriver();
            // with WebDriverManager
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--lang=en");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equals("firefox")) {
            // driver = new FirefoxDriver();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxOptions);
        } else if (browser.equals("edge")) {
            //driver  = new EdgeDriver();
            EdgeOptions edgeOptions = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeOptions);
        } else if (browser != null && browser != "chrome"
                && browser != "firefox" && browser != "edge") {
            throw new IllegalArgumentException("browser entered not correct");
        }

        // common settings for the browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.navigate().to("https://demoqa.com/");
        alertsPage = new AlertsPage(driver);
        homePage = new HomePage(driver);
        leftSideMenu = new LeftSideMenu(driver);

    }

    public AlertsPage getAlertsPage() {
        return alertsPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LeftSideMenu getLeftSideMenu() {
        return leftSideMenu;
    }

    public void quit() {
        driver.quit();
    }

}
