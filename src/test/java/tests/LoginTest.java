package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import pages.MainPage;
import testData.AppMessages;
import testData.Credentials;
import utils.NavigationUiHelper;

import java.time.Duration;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;

public class LoginTest extends BaseTest{
    private static LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();
    private NavigationUiHelper navigationUiHelper = new NavigationUiHelper();
    private Credentials credentials = new Credentials();
    private AppMessages appMessages = new AppMessages();

   @Test
    public void successLogin() {
        loginPage.login(Credentials.FIRST_USER, Credentials.CORRECT_PASSWORD);
        mainPage.burgerMenu.shouldBe(visible, Duration.ofSeconds(4));
    }

    @Test
    public void incorrectLogin() {
        loginPage.login(credentials.INCORRECT_LOGIN, credentials.INCORRECT_PASSWORD);
        navigationUiHelper.checkTextVisible(appMessages.INCORRECT_DATA_ERROR);
    }

    @ParameterizedTest
    @MethodSource("invalidUsers")
    void loginWithInvalidDataShowsError(String username, String password) {
        loginPage.login(username, password);
        navigationUiHelper.checkTextVisible(appMessages.INCORRECT_DATA_ERROR);
    }

    private static Stream<Arguments> invalidUsers() {
        return Stream.of(
                Arguments.of(Credentials.INCORRECT_LOGIN, Credentials.INCORRECT_PASSWORD),
                Arguments.of(Credentials.FIRST_USER, Credentials.INCORRECT_PASSWORD)
        );
    }
}
