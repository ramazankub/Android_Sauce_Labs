package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.appium.SelenideAppium.$;

public class MainPage {
    public final SelenideElement
            burgerMenu = $(AppiumBy.accessibilityId("test-Menu"));
}
