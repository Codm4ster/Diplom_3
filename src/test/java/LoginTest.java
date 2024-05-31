import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    private final StepUser user = new StepUser();
    String email;
    String password;
    String token;

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Before
    public void createUser() {
        var client = CreateUser.random();
        ValidatableResponse createResponse = user.createUser(client);
        email = client.getEmail();
        password = client.getPassword();
        token = createResponse.extract().path("accessToken");
    }

    @After
    public void deleteUser() {
        if (token != null) {
            user.deleteUser(token);
        }
    }

    @Test
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
