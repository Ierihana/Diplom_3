package data;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;

public class UserData {

    public static final String BASE_URI = RestAssured.baseURI = "https://stellarburgers.education-services.ru/";
    static Faker user = new Faker();
    public static final String USER_NAME = user.name().username() + System.currentTimeMillis();
    public static final String USER_EMAIL = user.internet().emailAddress();
    public static final String CORRECT_USER_PASSWORD = user.internet().password(6, 10);
    public static final String INCORRECT_USER_PASSWORD = user.internet().password(1, 5);

    public static final String USER_REGISTER_API = "/api/auth/register";
    public static final String USER_LOGIN_API = "/api/auth/login";
    public static final String USER_DELETE_API = "/api/auth/user";
}
