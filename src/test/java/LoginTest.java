import configure.DriverRule;
import configure.EnvConfig;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import user.CreateUser;
import user.StepUser;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    private final StepUser user = new StepUser();
    String email;
    String password;
    String accessToken;

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void createUser() {
        var client = CreateUser.random();
        ValidatableResponse createResponse = user.createUser(client);
        email = client.getEmail();
        password = client.getPassword();
        accessToken = createResponse.extract().path("accessToken");
    }

    @After
    public void deleteUser() {
        if (accessToken != null) {
            user.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Проверка входа по кнопке «Войти в аккаунт» на главной")
    public void checkLoggedInOnMainPageSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.BASE_URI);

        boolean isLoggedInSuccessful = new LoginPage(driver)
                .clickLoginButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButtonOnLoginPage()
                .waitOrderButton();

        assertTrue("Вход не выполнен", isLoggedInSuccessful);
    }

    @Test
    @DisplayName("Проверка входа через кнопку «Личный кабинет»")
    public void checkLoggedInPersonalCabinetSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.BASE_URI);

        boolean isLoggedInSuccessful = new LoginPage(driver)
                .clickPersonalCabinetButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButtonOnLoginPage()
                .waitOrderButton();

        assertTrue("Вход не выполнен", isLoggedInSuccessful);
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме регистрации")
    public void checkLoggedInOnRegistrationPageSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.REGISTER_URI);

        boolean isLoggedInSuccessful = new LoginPage(driver)
                .clickSignInButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButtonOnLoginPage()
                .waitOrderButton();

        assertTrue("Вход не выполнен", isLoggedInSuccessful);
    }

    @Test
    @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
    public void checkLoggedInOnForgotPasswordPageSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.FORGOT_PASSWORD_URI);

        boolean isLoggedInSuccessful = new LoginPage(driver)
                .clickSignInButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButtonOnLoginPage()
                .waitOrderButton();

        assertTrue("Вход не выполнен", isLoggedInSuccessful);
    }
}
