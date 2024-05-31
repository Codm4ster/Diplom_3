import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertEquals;

public class ConstructorTest {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void checkBunsSectionSuccessful() {
        WebDriver driver = driverRule.getDriver();
        driver.get(EnvConfig.BASE_URI);

        String actualResponse = new ConstructorPage(driver)
                .clickFillingButton()
                .clickBunsButton()
                .waitBunsSection()
                .getCurrentSectionText();

        assertEquals("Булки", actualResponse);
    }

    @Test
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
