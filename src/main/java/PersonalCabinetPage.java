import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    private final WebDriver driver;
    public PersonalCabinetPage(WebDriver driver) {
        this.driver = driver;
    }

    //Нажимаем на кнопку "Личный Кабинет" на главной
    public PersonalCabinetPage clickPersonalCabinetButton(){
        driver.findElement(personalCabinetButton).click();
        return this;
    }

    //Нажимаем на логотип "Stellar Burgers"
    public PersonalCabinetPage clickLogo(){
        driver.findElement(logo).click();
        return this;
    }

    //Нажимаем на кнопку "Конструктор"
    public PersonalCabinetPage clickConstructorButton(){
        driver.findElement(constructorButton).click();
        return this;
    }

    //Нажимаем на кнопку "Выйти" в Личном кабинете
    public PersonalCabinetPage clickLogoutButton(){
        driver.findElement(logoutButton).click();
        return this;
    }
}
