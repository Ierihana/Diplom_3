import models.UserModel;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static data.UserData.*;
import static steps.UserSteps.*;
import static org.junit.Assert.assertTrue;

@Slf4j
public class LoginAccountTests extends BaseUiTest {
    @Override
    @Before
    public void setUp(){
        UserModel userModel = new UserModel(USER_EMAIL, CORRECT_USER_PASSWORD, USER_NAME);
        userCreating(userModel);
        String browser = System.getProperty("browser", "yandex");
        if (browser.equalsIgnoreCase("chrome")){
            startChromeBrowser();
        }else {
            startYandexBrowser();
        }
        mainPage.open();
    }

    @Override
    @After
    public void tearDown(){
        userDelete(userModel);
        driver.quit();
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной странице.")
    @Description("Проверка, что пользователь может авторизоваться, " +
            "используя кнопку «Войти в аккаунт» на главной странице.")
    public void loginUsingButtonOnTheMainPage() {
        mainPage.loginAccountButtonClick();
        loginPage.fillUserDataFieldsAndEnter(USER_EMAIL, CORRECT_USER_PASSWORD);
        mainPage.personalAccountButtonClick();
        assertTrue(loginPage.isAccountLoggedIn());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет».")
    @Description("Проверка, что пользователь может авторизоваться, " +
            "используя кнопку «Личный кабинет» на главной странице.")
    public void loginFromThePersonalAccountPage(){
        mainPage.personalAccountButtonClick();
        loginPage.fillUserDataFieldsAndEnter(USER_EMAIL, CORRECT_USER_PASSWORD);
        mainPage.personalAccountButtonClick();
        assertTrue(loginPage.isAccountLoggedIn());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации.")
    @Description("Проверка, что пользователь может авторизоваться, " +
            "используя кнопку «Войти» на странице регистрации пользователя.")
    public void loginFromTheRegistrationPage(){
        mainPage.personalAccountButtonClick();
        loginPage.registerButtonClick();
        registrationPage.enterButtonClick();
        loginPage.fillUserDataFieldsAndEnter(USER_EMAIL, CORRECT_USER_PASSWORD);
        mainPage.personalAccountButtonClick();
        assertTrue(loginPage.isAccountLoggedIn());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля.")
    @Description("Проверка, что пользователь может авторизоваться, " +
            "используя кнопку «Войти» на странице восстановления пароля.")
    public void loginFromThePasswordRecoveryPage(){
        mainPage.personalAccountButtonClick();
        loginPage.PasswordRecoveryButtonClick();
        forgotPasswordPage.enterButtonClick();
        loginPage.fillUserDataFieldsAndEnter(USER_EMAIL, CORRECT_USER_PASSWORD);
        mainPage.personalAccountButtonClick();
        assertTrue(loginPage.isAccountLoggedIn());
    }


}
