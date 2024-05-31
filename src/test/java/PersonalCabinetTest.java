import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class PersonalCabinetTest {
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
    public void checkMoveToClickPersonalCabinet() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.BASE_URI);

        new LoginPage(driver)
                .clickLoginButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButtonOnLoginPage();
        boolean isMoveSuccessful = new PersonalCabinetPage(driver)
                .clickPersonalCabinetButton()
                .waitProfileText();

        assertTrue("Вход в Личный Кабинет не выполнен", isMoveSuccessful);
    }

    @Test
    public void checkMoveToClickLogo() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.BASE_URI);

        new LoginPage(driver)
                .clickLoginButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButtonOnLoginPage();
        boolean isMoveSuccessful = new PersonalCabinetPage(driver)
                .clickPersonalCabinetButton()
                .clickLogo()
                .waitOrderButton();

        assertTrue("Переход на Главную страницу не выполнен", isMoveSuccessful);
    }

    @Test
    public void checkMoveToClickConstructorButton() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.BASE_URI);

        new LoginPage(driver)
                .clickLoginButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButtonOnLoginPage();
        boolean isMoveSuccessful = new PersonalCabinetPage(driver)
                .clickPersonalCabinetButton()
                .clickConstructorButton()
                .waitOrderButton();

        assertTrue("Переход на Главную страницу не выполнен", isMoveSuccessful);
    }

    @Test
    public void checkLogoutSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.BASE_URI);

        new LoginPage(driver)
                .clickLoginButton()
                .setEmail(email)
                .setPassword(password)
                .clickSignInButtonOnLoginPage();
        boolean isLogoutSuccessful = new PersonalCabinetPage(driver)
                .clickPersonalCabinetButton()
                .clickLogoutButton()
                .waitEntranceText();

        assertTrue("Выход из Личного Кабинета не выполнен", isLogoutSuccessful);
    }
}
