package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

import io.appium.java_client.AppiumBy;
import utils.NavigationUiHelper;

public class LoginPage {

    private NavigationUiHelper navigationUiHelper = new NavigationUiHelper();

    public final SelenideElement
            userNameField = $(AppiumBy.accessibilityId("test-Username")),
            passwordField = $(AppiumBy.accessibilityId("test-Password")),
            loginButton = $(AppiumBy.accessibilityId("test-LOGIN"));

    public void login(String name, String password) {
        navigationUiHelper.setDataInField(name, userNameField);
        navigationUiHelper.setDataInField(password, passwordField);
        navigationUiHelper.clickOnElementById(loginButton);
    }
}
