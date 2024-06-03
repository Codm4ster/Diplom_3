package pages;

import configure.EnvConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {

    // кнопка "Булки"
    private final By bunsButton = By.xpath(".//span[text()='Булки']");
    // кнопка "Соусы"
    private final By sauceButton = By.xpath(".//span[text()='Соусы']");
    // кнопка "Начинки"
    private final By fillingButton = By.xpath(".//span[text()='Начинки']");
    // раздел "Булки"
    private final By bunsSection = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
    // раздел "Соусы"
    private final By sauceSection = By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
    // раздел "Начинки"
    private final By fillingSection = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");
    // выбранный раздел
    private final By currentSection = By.xpath(".//div[contains(@class,'tab_tab_type_current')]");

    private final WebDriver driver;
    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку <Булки>")
    public ConstructorPage clickBunsButton(){
        driver.findElement(bunsButton).click();
        return this;
    }

    @Step("Нажимаем на кнопку <Соусы>")
    public ConstructorPage clickSauceButton(){
        driver.findElement(sauceButton).click();
        return this;
    }

    @Step("Нажимаем на кнопку <Начинки>")
    public ConstructorPage clickFillingButton(){
        driver.findElement(fillingButton).click();
        return this;
    }

    @Step("Ожидаем выбранный раздел <Булки>")
    public ConstructorPage waitBunsSection() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(bunsSection, "class", "current"));
        return this;
    }

    @Step("Ожидаем выбранный раздел <Соусы>")
    public ConstructorPage waitSauceSection() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(sauceSection, "class", "current"));
        return this;
    }

    @Step("Ожидаем выбранный раздел <Начинки>")
    public ConstructorPage waitFillingSection() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(fillingSection, "class", "current"));
        return this;
    }

    @Step("Получение названия текущего раздела")
    public String getCurrentSectionText() {
        return driver.findElement(currentSection).getText();
    }
}
