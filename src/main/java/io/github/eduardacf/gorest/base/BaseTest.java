package io.github.eduardacf.gorest.base;


import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest extends BaseClient {

    protected RequestSpecification spec;

    @BeforeMethod
    public void configurar() {
        spec = obterSpecPadrao();
    }

    protected void habilitarLogEmFalha() {
        spec.log().ifValidationFails(LogDetail.ALL);
    }
}
