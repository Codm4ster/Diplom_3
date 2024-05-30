import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void checkRegistrationSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.REGISTER_URI);

        boolean isRegistrationSuccessful = new RegistrationPage(driver)
                .setName(RandomStringUtils.randomAlphabetic(4, 10))
                .setEmail(RandomStringUtils.randomAlphabetic(4, 10) + "@yandex.ru")
                .setPassword(RandomStringUtils.randomAlphabetic(10))
                .clickRegisterButton()
                .registrationSuccessful();

        assertTrue("Регистрация не прошла", isRegistrationSuccessful);
    }

    @Test
    public void checkRegistrationFailed() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.REGISTER_URI);

        String actualResponse = new RegistrationPage(driver)
                .setName(RandomStringUtils.randomAlphabetic(4, 10))
                .setEmail(RandomStringUtils.randomAlphabetic(4, 10) + "@yandex.ru")
                .setPassword(RandomStringUtils.randomAlphabetic(5))
                .clickRegisterButton()
                .getErrorMessage();

        assertEquals("Некорректный пароль", actualResponse);
    }
}
