import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // кнопка "Войти в аккаунт"
    private final By loginButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    // кнопка "Личный Кабинет"
    private final By personalCabinetButton = By.xpath(".//p[text()='Личный Кабинет']");
    // надпись "Вход"
    private final By loginText = By.xpath(".//h2[text() = 'Вход']");
    // кнопка "Войти" в Личном кабинете
    private final By signInButtonOnLoginPage = By.xpath(".//button[text()='Войти']");
    // кнопка "Войти" в форме восстановления и регистрации пароля
    private final By signInButton = By.xpath(".//a[text()='Войти']");
    // поле "Email" в Личном кабинете
    private final By emailInput = By.xpath(".//fieldset[1]//input[@name='name']");
    // поле "Пароль" в Личном кабинете
    private final By passwordInput = By.xpath(".//fieldset[2]//input[@name='Пароль']");
    // надпись "Вход" в Личном кабинете
    private final By entranceText = By.xpath(".//h2[text()='Вход']");

    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Нажимаем на кнопку "Войти в аккаунт" на главной
    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return this;
    }

    //Нажимаем на кнопку "Личный Кабинет"
    public LoginPage clickPersonalCabinetButton(){
        driver.findElement(personalCabinetButton).click();
        return this;
    }

    //Нажимаем на кнопку "Войти" в форме регистрации/восстановления пароля
    public LoginPage clickSignInButton(){
        driver.findElement(signInButton).click();
        return this;
    }

    //Заполняем поле "Email"
    public LoginPage setEmail(String inputEmail) {
        driver.findElement(emailInput).sendKeys(inputEmail);
        return this;
    }

    //Заполняем поле "Пароль"
    public LoginPage setPassword(String inputPassword) {
        driver.findElement(passwordInput).sendKeys(inputPassword);
        return this;
    }

    //Нажимаем на кнопку "Войти"
    public LoginPage clickSignInButtonOnLoginPage(){
        driver.findElement(signInButtonOnLoginPage).click();
        return this;
    }
}
