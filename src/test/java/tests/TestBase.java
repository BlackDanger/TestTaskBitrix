package tests;

import extensions.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {


    @BeforeMethod
    public void initWebDriver() {
        Configuration.browser = Config.get().browserChrome();
        open(Config.get().urlMain());
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
    @AfterMethod
    public void closingSession() {
        closeWebDriver();
    }
}
