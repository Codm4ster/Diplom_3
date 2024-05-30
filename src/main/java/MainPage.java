import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    // надпись "Соберите бургер"
    private final By homeText = By.xpath(".//h1[text()='Соберите бургер']");
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

    private final WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Нажимаем на кнопку "Булки"
    public MainPage clickBunsButton(){
        driver.findElement(bunsButton).click();
        return this;
    }

    //Нажимаем на кнопку "Соусы"
    public MainPage clickSauceButton(){
        driver.findElement(sauceButton).click();
        return this;
    }

    //Нажимаем на кнопку "Начинки"
    public MainPage clickFillingButton(){
        driver.findElement(fillingButton).click();
        return this;
    }

    //Ожидаем выбранный раздел "Булки"
    public MainPage waitBunsSection() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(bunsSection, "class", "current"));
        return this;
    }

    //Ожидаем выбранный раздел "Соусы"
    public MainPage waitSauceSection() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(sauceSection, "class", "current"));
        return this;
    }

    //Ожидаем выбранный раздел "Начинки"
    public MainPage waitFillingSection() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.attributeContains(fillingSection, "class", "current"));
        return this;
    }
}
