import Models.UserModel;
import Pages.ForgotPasswordPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static Data.UserData.*;
import static Steps.UserSteps.*;
import static org.junit.Assert.assertTrue;

@Slf4j
public class LoginAccountTests extends BaseUiTest {
    @Override
    @Before
    public void setUp(){
        UserModel userModel = new UserModel(USER_EMAIL, CORRECT_USER_PASSWORD, USER_NAME);
        userCreating(userModel);
        startChromeBrowser();
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
    @Description("")
    public void loginUsingButtonOnTheMainPage() {
        mainPage.loginAccountButtonClick();
        loginPage.fillUserDataFieldsAndEnter(USER_EMAIL, CORRECT_USER_PASSWORD);
//        System.out.println(USER_NAME +"   "+  USER_EMAIL +"   "+ CORRECT_USER_PASSWORD);
        mainPage.personalAccountButtonClick();
        assertTrue(loginPage.isAccountLoggedIn());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет».")
    public void loginFromThePersonalAccountPage(){
        mainPage.personalAccountButtonClick();
        loginPage.fillUserDataFieldsAndEnter(USER_EMAIL, CORRECT_USER_PASSWORD);
        mainPage.personalAccountButtonClick();
        assertTrue(loginPage.isAccountLoggedIn());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации.")
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
    public void loginFromThePasswordRecoveryPage(){
        mainPage.personalAccountButtonClick();
        loginPage.PasswordRecoveryButtonClick();
        forgotPasswordPage.enterButtonClick();
        loginPage.fillUserDataFieldsAndEnter(USER_EMAIL, CORRECT_USER_PASSWORD);
        mainPage.personalAccountButtonClick();
        assertTrue(loginPage.isAccountLoggedIn());


    }


}
