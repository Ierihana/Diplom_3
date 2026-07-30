package Steps;

import Models.UserModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static Data.UserData.*;
import static io.restassured.RestAssured.*;

public class UserSteps {

    @Step("Создание пользователя: {user}")
    public static void userCreating(UserModel user) {
        given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(USER_REGISTER_API);
    }

    @Step
    public static Response userLogin(UserModel userModel){
        String jsonBody = String.format("{\"email\":\"%s\",\"password\":\"%s\"}", USER_EMAIL, CORRECT_USER_PASSWORD);
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonBody)
                .when()
                .post(USER_LOGIN_API)
                .then()
                .extract().response();
    }

    @Step
    public static void userDelete(UserModel userModel){
        String fullAccessToken = userLogin(userModel).path("accessToken").toString();
        String accessToken = fullAccessToken.substring(7);
        given()
                .auth().oauth2(accessToken)
                .when()
                .delete(USER_DELETE_API)
                .then()
                .extract().response();
    }
}

