package pages;

import configure.EnvConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    // поле "Имя" на странице регистрации
    private final By name = By.xpath(".//fieldset[1]//input[@name='name']");
    // поле "Email" на странице регистрации
    private final By email = By.xpath(".//fieldset[2]//input[@name='name']");
    // поле "Пароль" на странице регистрации
    private final By password = By.xpath(".//fieldset[3]//input[@name='Пароль']");
    // кнопка "Зарегистрироваться" на странице регистрации
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // надпись "Некорректный пароль"
    private final By wrongPasswordText = By.xpath(".//p[text() = 'Некорректный пароль']");
    // надпись "Вход" в Личном кабинете
    private final By entranceText = By.xpath(".//h2[text()='Вход']");

    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполняем поле «Имя»")
    public RegistrationPage setName(String inputName) {
        driver.findElement(name).sendKeys(inputName);
        return this;
    }

    @Step("Заполняем поле «Email»")
    public RegistrationPage setEmail(String inputEmail) {
        driver.findElement(email).sendKeys(inputEmail);
        return this;
    }

    @Step("Заполняем поле «Пароль»")
    public RegistrationPage setPassword(String inputPassword) {
        driver.findElement(password).sendKeys(inputPassword);
        return this;
    }

    @Step("Нажимаем на кнопку «Зарегистрироваться»")
    public RegistrationPage clickRegisterButton(){
        driver.findElement(registerButton).click();
        return this;
    }

    @Step("Получаем текст ошибки при некорректном пароле")
    public String getErrorMessage(){

        return driver.findElement(wrongPasswordText).getText();
    }

    @Step("Ожидаем появления надписи «Вход»")
    public boolean registrationSuccessful() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(entranceText));
        return driver.findElement(entranceText).isDisplayed();
    }
}
