package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriverWait wait;
    private final WebDriver driver;
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By passwordRecoveryButton = By.xpath(".//a[text()='Восстановить пароль']");
    private final By userPasswordField = By.xpath(".//input[@name='Пароль']");
    private final By userEmailField = By.xpath(".//label[text()='Email']/../input");
    private final By exitButton = By.xpath(".//button[text()='Выход']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка открытия главной страницы")
    public boolean isOpened(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement enterButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(enterButton));
        return enterButtonElement.isDisplayed();
    }

    @Step("Проверка входа в аккаунт")
    public boolean isAccountLoggedIn(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement exitButtonOnLoginPage = wait.until(ExpectedConditions.elementToBeClickable(exitButton));
        return exitButtonOnLoginPage.isDisplayed();

    }
    @Step("Клик по элементу {locator}")
    public void elementClick(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void registerButtonClick(){
        elementClick(registerButton);
    }
    @Step("Клик по кнопке 'Войти'")
    public void enterButtonClick(){
        elementClick(enterButton);
    }
    @Step("Клик по кнопке 'Восстановить пароль'")
    public void PasswordRecoveryButtonClick(){
        elementClick(passwordRecoveryButton);
    }
    @Step("Заполнение всех полей данных пользователя и вход.")
    public void fillUserDataFieldsAndEnter(String userEmail, String userPassword){
        setUserEmail(userEmail);
        setUserPassword(userPassword);
        enterButtonClick();
    }
    @Step("Заполнение поля данных email.")
    public void setUserEmail(String userEmail){
        driver.findElement(userEmailField).sendKeys(userEmail);
    }
    @Step("Заполнение поля данных Пароль.")
    public void setUserPassword(String userPassword){
        driver.findElement(userPasswordField).sendKeys(userPassword);
    }








}
