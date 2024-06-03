package pages;

import configure.EnvConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    // кнопка "Войти в аккаунт"
    private final By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    // кнопка "Личный Кабинет"
    private final By personalCabinetButton = By.xpath(".//p[text()='Личный Кабинет']");
    // кнопка "Войти" в Личном кабинете
    private final By signInButtonOnLoginPage = By.xpath(".//button[text()='Войти']");
    // кнопка "Войти" в форме восстановления и регистрации пароля
    private final By signInButton = By.xpath(".//a[text()='Войти']");
    // поле "Email" в Личном кабинете
    private final By emailInput = By.xpath(".//fieldset[1]//input[@name='name']");
    // поле "Пароль" в Личном кабинете
    private final By passwordInput = By.xpath(".//fieldset[2]//input[@name='Пароль']");
    // кнопка "Оформить заказ"
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");

    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку <Войти в аккаунт> на главной")
    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return this;
    }

    @Step("Нажимаем на кнопку <Личный Кабинет>")
    public LoginPage clickPersonalCabinetButton(){
        driver.findElement(personalCabinetButton).click();
        return this;
    }

    @Step("Нажимаем на кнопку <Войти> в форме регистрации/восстановления пароля")
    public LoginPage clickSignInButton(){
        driver.findElement(signInButton).click();
        return this;
    }

    @Step("Заполняем поле <Email>")
    public LoginPage setEmail(String inputEmail) {
        driver.findElement(emailInput).sendKeys(inputEmail);
        return this;
    }

    @Step("Заполняем поле <Пароль>")
    public LoginPage setPassword(String inputPassword) {
        driver.findElement(passwordInput).sendKeys(inputPassword);
        return this;
    }

    @Step("Нажимаем на кнопку <Войти>")
    public LoginPage clickSignInButtonOnLoginPage(){
        driver.findElement(signInButtonOnLoginPage).click();
        return this;
    }

    @Step("Ожидаем появления кнопки <Оформить заказ>")
    public boolean waitOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        return driver.findElement(orderButton).isDisplayed();
    }
}
