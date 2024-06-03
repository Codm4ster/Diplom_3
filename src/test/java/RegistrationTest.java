import configure.DriverRule;
import configure.EnvConfig;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;
import user.CreateUser;
import user.StepUser;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private final StepUser user = new StepUser();
    String accessToken;

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Проверка успешной регистрации")
    public void checkRegistrationSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.REGISTER_URI);
        String name = RandomStringUtils.randomAlphabetic(4, 10);
        String email = RandomStringUtils.randomAlphabetic(4, 10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);

        boolean isRegistrationSuccessful = new RegistrationPage(driver)
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickRegisterButton()
                .registrationSuccessful();

        assertTrue("Регистрация не прошла", isRegistrationSuccessful);

        accessToken = user.loginUser(new CreateUser(email, password)).extract().path("accessToken");
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля")
    public void checkRegistrationFailed() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.REGISTER_URI);
        String name = RandomStringUtils.randomAlphabetic(4, 10);
        String email = RandomStringUtils.randomAlphabetic(4, 10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(5);

        String actualResponse = new RegistrationPage(driver)
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickRegisterButton()
                .getErrorMessage();

        assertEquals("Некорректный пароль", actualResponse);

        accessToken = user.loginUser(new CreateUser(email, password)).extract().path("accessToken");
    }

    @After
    public void deleteUser() {
        if (accessToken != null) {
            user.deleteUser(accessToken);
        }
    }
}
