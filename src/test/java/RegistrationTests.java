import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Test;

import static Data.UserData.*;
import static org.junit.Assert.assertTrue;
public class RegistrationTests extends BaseUiTest{

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Проверка, что пользователь может зарегистрироваться, " +
            "используя валидные данные.")
    public void successfulRegistration(){
        mainPage.open();
        mainPage.personalAccountButtonClick();
        assertTrue(loginPage.isOpened());
        loginPage.registerButtonClick();
        assertTrue(registrationPage.isOpened());
        registrationPage.fillUserDataFields(USER_NAME, USER_EMAIL, CORRECT_USER_PASSWORD);
//        System.out.println(USER_NAME +"   "+  USER_EMAIL +"   "+ CORRECT_USER_PASSWORD);
        registrationPage.registerButtonClick();
        assertTrue(loginPage.isOpened());
    }

    @Test
    @DisplayName("Ошибка при вводе некорректного пароля")
    @Description("Проверка, что при длине пароля меньше 6 символов появляется ошибка 'некорректный пароль'.")
    public void enteringIncorrectPasswordError(){
        mainPage.open();
        mainPage.personalAccountButtonClick();
        assertTrue(loginPage.isOpened());
        loginPage.registerButtonClick();
        assertTrue(registrationPage.isOpened());
        registrationPage.fillUserDataFields(USER_NAME, USER_EMAIL, INCORRECT_USER_PASSWORD);
        assertTrue(registrationPage.isPasswordIncorrect());

    }

}
