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
import pages.PersonalCabinetPage;
import user.CreateUser;
import user.StepUser;

import static org.junit.Assert.assertTrue;

public class PersonalCabinetTest {
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
    @DisplayName("Проверка перехода в личный кабинет по клику на «Личный кабинет»")
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

        assertTrue("Вход в «Личный кабинет» не выполнен", isMoveSuccessful);
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на логотип Stellar Burgers")
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
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на «Конструктор»")
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
    @DisplayName("Проверка выхода из аккаунта по кнопке «Выйти» в личном кабинете")
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

        assertTrue("Выход из «Личный кабинет» не выполнен", isLogoutSuccessful);
    }
}
