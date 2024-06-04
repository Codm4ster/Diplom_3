package user;

import configure.EnvConfig;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

public class StepUser extends EnvConfig {

    @Step("Создание пользователя")
    public ValidatableResponse createUser(CreateUser user) {
        return spec()
                .body(user)
                .when()
                .post(EnvConfig.REGISTER)
                .then().log().all();
    }

    @Step("Авторизация пользователя")
    public ValidatableResponse loginUser(CreateUser user) {
        return spec()
                .body(user)
                .when()
                .post(EnvConfig.LOGIN)
                .then().log().all();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return spec()
                .header("Authorization", accessToken)
                .when()
                .delete(EnvConfig.USER)
                .then().log().all();
    }

}
