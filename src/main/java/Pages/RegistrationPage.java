package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;
    WebDriverWait wait;
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By userNameField = By.xpath("//label[text()='Имя']/../input");
    private final By userEmailField = By.xpath(".//label[text()='Email']/../input");
    private final By userPasswordField = By.xpath(".//input[@name='Пароль']");
    private final By incorrectPasswordMessage = By.xpath("//*[text()='Некорректный пароль']");
    private final By enterButton = By.xpath(".//a[text()='Войти']");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpened(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement registerButtonVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton));
        return registerButtonVisible.isDisplayed();
    }

    public void fillUserDataFields(String userName, String userEmail, String userPassword){
        setUserName(userName);
        setUserEmail(userEmail);
        setUserPassword(userPassword);
    }

    public void setUserName(String userName){
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void setUserEmail(String userEmail){
        driver.findElement(userEmailField).sendKeys(userEmail);
    }

    public void setUserPassword(String userPassword){
        driver.findElement(userPasswordField).sendKeys(userPassword);
    }

    public void registerButtonClick(){
        elementClick(registerButton);
    }

    public void enterButtonClick(){
        elementClick(enterButton);
    }
    public void elementClick(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public boolean isPasswordIncorrect(){
        elementClick(userEmailField);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement incorrectPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordMessage));
        return incorrectPassword.isDisplayed();
    }





}
