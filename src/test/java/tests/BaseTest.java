package tests;

import com.codeborne.selenide.WebDriverRunner;
import drivers.AndroidDriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import pages.LoginPage;

public class BaseTest {

    public void openApp() {
        AndroidDriver androidDriver = AndroidDriverFactory.createDriver();
        WebDriverRunner.setWebDriver(androidDriver);
    }

    @BeforeEach
    public void setup() {
        openApp();
    }

    @AfterEach
    public void quit() {
        WebDriverRunner.closeWebDriver();
    }
}
