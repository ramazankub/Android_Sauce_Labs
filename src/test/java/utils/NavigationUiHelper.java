package utils;

import com.codeborne.selenide.SelenideElement;

import java.awt.*;
import java.time.Duration;

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
