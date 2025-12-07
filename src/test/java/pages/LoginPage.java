package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import tests.BaseTest;


public class LoginPage extends BaseTest {

    private static final String
            FIRST_USER = "standard_user",
            CORRECT_PASSWORD = "secret_sauce";

    private final SelenideElement
            userNameField = $(AppiumBy.accessibilityId("test-Username")),
            passwordField = $(AppiumBy.accessibilityId("test-Password")),
            loginButton = $(AppiumBy.accessibilityId("test-LOGIN"));

    @Test
    public void login() {
        userNameField.click();
        userNameField.setValue(FIRST_USER);
        passwordField.setValue(CORRECT_PASSWORD);
        loginButton.click();
    }
}
