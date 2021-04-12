package features.Login;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginAssertions {

  @Step("Verificacion si el cliente pudo obtener su token")
  public void verifyTokenGeneration() {
    assertThat(SerenityRest.then().extract().body().jsonPath().getString("token"), is(notNullValue()));
  }

}
