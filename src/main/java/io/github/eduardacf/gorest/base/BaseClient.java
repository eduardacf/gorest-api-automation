package io.github.eduardacf.gorest.base;


import io.github.cdimascio.dotenv.Dotenv;
import io.github.eduardacf.gorest.config.ConfiguracaoApi;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public abstract class BaseClient {

    private static final Dotenv dotenv = Dotenv.load();

    protected RequestSpecification obterSpecPadrao() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfiguracaoApi.obterBaseUrl())
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .build();
    }

    protected RequestSpecification comAutenticacao() {
        String token = dotenv.get("GOREST_TOKEN");

        if (token == null || token.isBlank()) {
            throw new IllegalStateException("Token não encontrado.");
        }

        return given()
                .spec(obterSpecPadrao())
                .auth()
                .oauth2(token);
    }

    protected RequestSpecification semAutenticacao() {
        return given().spec(obterSpecPadrao());
    }
}
