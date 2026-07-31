import models.UserModel;
import pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUiTest {
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    UserModel userModel;
    ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp(){
        String browser = System.getProperty("browser", "chrome");
        if (browser.equalsIgnoreCase("chrome")){
            startChromeBrowser();
        }else {
            startYandexBrowser();
        }
    }

    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    public void startYandexBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/julia/Downloads/yandexdriver-26.6.0.1742-win64/yandexdriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
