package pages;

import configure.EnvConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalCabinetPage {

    // логотип "Stellar Burgers"
    private final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    // кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    // кнопка "Личный Кабинет"
    private final By personalCabinetButton = By.xpath(".//p[text()='Личный Кабинет']");
    // кнопка "Выйти" в Личном кабинете
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    // надпись "Профиль" в Личном кабинете
    private final By profileText = By.xpath(".//a[text()='Профиль']");
    // кнопка "Оформить заказ"
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    // надпись "Вход" в Личном кабинете
    private final By entranceText = By.xpath(".//h2[text()='Вход']");

    private final WebDriver driver;
    public PersonalCabinetPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку «Личный Кабинет» на главной")
    public PersonalCabinetPage clickPersonalCabinetButton(){
        driver.findElement(personalCabinetButton).click();
        return this;
    }

    @Step("Ожидаем появления надписи «Профиль»")
    public boolean waitProfileText() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(profileText));
        return driver.findElement(profileText).isDisplayed();
    }

    @Step("Нажимаем на логотип «Stellar Burgers»")
    public PersonalCabinetPage clickLogo(){
        driver.findElement(logo).click();
        return this;
    }

    @Step("Нажимаем на кнопку «Конструктор»")
    public PersonalCabinetPage clickConstructorButton(){
        driver.findElement(constructorButton).click();
        return this;
    }

    @Step("Ожидаем появления кнопки «Оформить заказ»")
    public boolean waitOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        return driver.findElement(orderButton).isDisplayed();
    }

    @Step("Нажимаем на кнопку «Выйти» в Личном кабинете")
    public PersonalCabinetPage clickLogoutButton(){
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
        return this;
    }

    @Step("Ожидаем появления надписи «Вход»")
    public boolean waitEntranceText() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(entranceText));
        return driver.findElement(entranceText).isDisplayed();
    }
}
