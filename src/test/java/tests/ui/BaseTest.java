package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import listeners.TestListener;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utils.AllureUtils;
import utils.PropertyReader;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    protected final String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected final String password = System.getProperty("password", PropertyReader.getProperty("password"));

    protected HomePage homePage;
    protected LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {

        closeWebDriver();

        Configuration.timeout = 20000;
        Configuration.clickViaJs = true;
        Configuration.headless = true;
        Configuration.pageLoadStrategy = "eager";

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromePrefs = new HashMap<>();
            chromePrefs.put("credentials_enable_service", false);
            chromePrefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", chromePrefs);
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");
            //options.addArguments("--start-maximized");
            options.addArguments("--headless");
            Configuration.browserCapabilities = options;
            Configuration.browser = "chrome";
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--headless");
            Configuration.browserCapabilities = options;
            Configuration.browser = "firefox";
        }

        initializePages();
        setupAllure();

        open("https://trello.com/");
    }

    private void initializePages() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    private void setupAllure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            AllureUtils.takeScreenshot();
        }

        if (getWebDriver() != null) {
            closeWebDriver();
        }
    }
}
