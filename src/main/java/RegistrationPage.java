import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    // надпись "Регистрация"
    private final By registerText = By.xpath(".//h2[text() = 'Регистрация']");
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

    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
    }

    //Заполняем поле "Имя"
    public RegistrationPage setName(String inputName) {
        driver.findElement(name).sendKeys(inputName);
        return this;
    }

    //Заполняем поле "Email"
    public RegistrationPage setEmail(String inputEmail) {
        driver.findElement(email).sendKeys(inputEmail);
        return this;
    }

    //Заполняем поле "Пароль"
    public RegistrationPage setPassword(String inputPassword) {
        driver.findElement(password).sendKeys(inputPassword);
        return this;
    }

    //Нажимаем на кнопку "Зарегистрироваться"
    public RegistrationPage clickRegisterButton(){
        driver.findElement(registerButton).click();
        return this;
    }

    //Получаем текст ошибки при некорректном пароле
    public String getErrorMessage(){

        return driver.findElement(wrongPasswordText).getText();
    }
}
