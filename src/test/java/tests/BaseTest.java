package tests;

import com.codeborne.selenide.WebDriverRunner;
import drivers.AndroidDriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    private AndroidDriver androidDriver;

    public void openApp() {
        androidDriver = AndroidDriverFactory.createDriver();

        if (androidDriver != null) {
            WebDriverRunner.setWebDriver(androidDriver);
        }
    }

    @BeforeEach
    public void setup() {
        openApp();
    }

    @AfterEach
    public void quit() {

        if (androidDriver != null) {
            androidDriver.quit();
            WebDriverRunner.closeWebDriver();
        }
    }
}
