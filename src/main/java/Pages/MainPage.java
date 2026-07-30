package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriverWait wait;
    private final WebDriver driver;
    private final By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By bunConstructionSection = By.xpath(".//div[contains(@class, 'tab_tab') and .//span[normalize-space()='Булки']]");
    private final By saucesConstructionSection = By.xpath(".//div[contains(@class, 'tab_tab') and .//span[normalize-space()='Соусы']]");
    private final By fillingConstructionSection = By.xpath(".//div[contains(@class, 'tab_tab') and .//span[normalize-space()='Начинки']]");
    private final By bunSectionIsOpen = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc ') and .//span[normalize-space()='Булки']]");
    private final By saucesSectionIsOpen = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc ') and .//span[normalize-space()='Соусы']]");
    private final By fillingSectionIsOpen = By.xpath(".//div[contains(@class, 'tab_tab_type_current__2BEPc ') and .//span[normalize-space()='Начинки']]");


    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        String URL = "https://stellarburgers.education-services.ru";
        driver.get(URL);
    }

    public void elementClick(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }


    public void personalAccountButtonClick(){
        elementClick(personalAccountButton);
    }

    public void loginAccountButtonClick(){
        elementClick(loginAccountButton);
    }

    public void bunConstructionSectionClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(bunConstructionSection));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isBunSectionOpen(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement openedBunSection = wait.until(ExpectedConditions.visibilityOfElementLocated(bunSectionIsOpen));
        return openedBunSection.isDisplayed();
    }

    public void saucesConstructionSectionClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(saucesConstructionSection));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isSaucesSectionOpen(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement openedSaucesSection = wait.until(ExpectedConditions.visibilityOfElementLocated(saucesSectionIsOpen));
        return openedSaucesSection.isDisplayed();
    }

    public void fillingConstructionSectionClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(fillingConstructionSection));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isFillingSectionOpen(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement openedFillingSection = wait.until(ExpectedConditions.visibilityOfElementLocated(fillingSectionIsOpen));
        return openedFillingSection.isDisplayed();
    }
}
