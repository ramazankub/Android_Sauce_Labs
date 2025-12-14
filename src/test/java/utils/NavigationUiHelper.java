package utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.awt.*;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class NavigationUiHelper {

    public void clickOnElementById(SelenideElement selenideElement) {
        selenideElement.shouldBe(visible, Duration.ofSeconds(4));
        selenideElement.click();
    }

    public void setDataInField(String data, SelenideElement selenideElement) {
        selenideElement.shouldBe(visible, Duration.ofSeconds(4));
        selenideElement.click();
        selenideElement.setValue(data);
    }

    public void checkTextVisible(String text) {
        $x("//*[contains(@text, \"" + text + "\")]")
                .shouldBe(visible, Duration.ofSeconds(3));
    }

    public void checkElementVisible(SelenideElement selenideElement) {
        selenideElement.shouldBe(visible, Duration.ofSeconds(4));
    }

    public void clickOnBtnByText(String textInBtn) {
        SelenideElement btn = $x("//*[contains(@text, '" + textInBtn + "')]");
        btn.shouldBe(visible, Duration.ofSeconds(4));
        btn.click();
    }
}
