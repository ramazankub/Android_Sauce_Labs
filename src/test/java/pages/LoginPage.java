package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

import io.appium.java_client.AppiumBy;
import utils.GesturesHelper;
import utils.NavigationUiHelper;

public class LoginPage {

    private NavigationUiHelper navigationUiHelper = new NavigationUiHelper();
    private GesturesHelper gesturesHelper = new GesturesHelper();
    private MainPage mainPage = new MainPage();

    public final SelenideElement
            userNameField = $(AppiumBy.accessibilityId("test-Username")),
            passwordField = $(AppiumBy.accessibilityId("test-Password")),
            loginButton = $(AppiumBy.accessibilityId("test-LOGIN")),
            credsListTitle = $(AppiumBy.androidUIAutomator("new UiSelector().text(\"The currently accepted usernames for this application are (tap to autofill):\")"));

    public void login(String name, String password) {
        navigationUiHelper.setDataInField(name, userNameField);
        navigationUiHelper.setDataInField(password, passwordField);
        navigationUiHelper.clickOnElementById(loginButton);
    }

    public void pasteCredentialsByPress(SelenideElement selenideElement, String login, String password) {
        gesturesHelper.scrollDownUntilElementVisible(selenideElement, 4);
        navigationUiHelper.clickOnBtnByText(login);
        navigationUiHelper.clickOnBtnByText(password);
        gesturesHelper.scrollUpUntilElementVisible(userNameField, 4);
        navigationUiHelper.checkTextVisible(login);
        navigationUiHelper.clickOnElementById(loginButton);
        navigationUiHelper.checkElementVisible(mainPage.burgerMenu);
    }
}
