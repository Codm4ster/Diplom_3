import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class StepUser extends EnvConfig {

    @Step("Создание пользователя")
    public ValidatableResponse createUser(CreateUser user) {
        return spec()
                .body(user)
                .when()
                .post(REGISTER)
                .then().log().all();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return spec()
                .header("Authorization", accessToken)
                .when()
                .delete(USER)
                .then().log().all();
    }

}
