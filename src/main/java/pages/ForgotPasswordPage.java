package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {

    WebDriverWait wait;
    private final WebDriver driver;
    private final By enterButton = By.linkText("Войти");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по элементу {locator}")
    public void elementClick(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
    @Step("Клик по кнопке 'Войти'.")
    public void enterButtonClick(){
        elementClick(enterButton);
    }


}
