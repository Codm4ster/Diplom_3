import configure.DriverRule;
import configure.EnvConfig;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ConstructorPage;

import static junit.framework.TestCase.assertEquals;

public class ConstructorTest {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Проверка работы перехода к разделу «Булки»")
    public void checkBunsSectionSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.BASE_URI);

        String actualResponse = new ConstructorPage(driver)
                .clickFillingButton()
                .waitFillingSection()
                .clickBunsButton()
                .waitBunsSection()
                .getCurrentSectionText();

        assertEquals("Булки", actualResponse);
    }

    @Test
    @DisplayName("Проверка работы перехода к разделу «Соусы»")
    public void checkSauceSectionSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.BASE_URI);

        String actualResponse = new ConstructorPage(driver)
                .clickSauceButton()
                .waitSauceSection()
                .getCurrentSectionText();

        assertEquals("Соусы", actualResponse);
    }

    @Test
    @DisplayName("Проверка работы перехода к разделу «Начинки»")
    public void checkFillingSectionSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.BASE_URI);

        String actualResponse = new ConstructorPage(driver)
                .clickFillingButton()
                .waitFillingSection()
                .getCurrentSectionText();

        assertEquals("Начинки", actualResponse);
    }
}
