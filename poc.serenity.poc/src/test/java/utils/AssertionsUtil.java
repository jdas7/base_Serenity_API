package utils;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.httpclient.HttpStatus;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertionsUtil {


    @Step("Verificacion de status code 200")
    public void shouldSeeSuccessfulStatusCode() {
        assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Step("Verificacion de status code 206")
    public void shouldSeePartialContentStatusCode() {
        assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_PARTIAL_CONTENT));
    }

    @Step("Verificacion de status code 303")
    public void shouldSeeExceptionStatusCode() {
        assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_SEE_OTHER));
    }

    @Step("Verificacion de status code 404")
    public void shouldSeeNotFoundStatusCode() {
        assertThat(SerenityRest.then().extract().statusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }

    @Step("Verificacion de status code 500")
    public void shouldSeeInternalErrorStatusCode() {
        assertThat(SerenityRest.then().extract().statusCode(),
            equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
    }

    @Step("Verificacion del campo: {0} contenga el valor: {1}")
    public void validateProperty(String property, String value) {
        assertThat(SerenityRest.then().extract().body().jsonPath().getString(property), is(value));
    }

    @Step("Validacion Schema Correcto")
    public void validateJSONSchema(String pathToSchema) {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
            .setValidationConfiguration(ValidationConfiguration
                .newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();
        SerenityRest.then().assertThat()
            .body(matchesJsonSchemaInClasspath(pathToSchema).using(jsonSchemaFactory));
    }

}
