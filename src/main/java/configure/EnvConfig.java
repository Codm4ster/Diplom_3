package configure;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class EnvConfig {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    public static final String REGISTER_URI = "https://stellarburgers.nomoreparties.site/register";
    public static final String FORGOT_PASSWORD_URI = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final int DEFAULT_TIMEOUT = 10;
    public static final String REGISTER = "/api/auth/register";
    public static final String LOGIN = "/api/auth/login";
    public static final String USER = "/api/auth/user";

    public RequestSpecification spec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI);
    }
}
