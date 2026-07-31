package steps;

import models.UserLoginModel;
import models.UserModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static data.UserData.*;
import static io.restassured.RestAssured.*;

public class UserSteps {

    @Step("Создание пользователя.")
    public static void userCreating(UserModel user) {
        given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(USER_REGISTER_API);
    }

    @Step("Авторизация пользователя.")
    public static Response userLogin(){
        UserLoginModel userLoginModel = new UserLoginModel(USER_EMAIL, CORRECT_USER_PASSWORD);
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userLoginModel)
                .when()
                .post(USER_LOGIN_API)
                .then()
                .extract().response();
    }

    @Step("Удаление пользователя")
    public static void userDelete(UserModel userModel){
        String fullAccessToken = userLogin().path("accessToken").toString();
        String accessToken = fullAccessToken.substring(7);
        given()
                .auth().oauth2(accessToken)
                .when()
                .delete(USER_DELETE_API)
                .then()
                .extract().response();
    }
}

