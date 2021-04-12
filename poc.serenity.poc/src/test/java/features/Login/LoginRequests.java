package features.Login;

import apis.ServicePaths;
import io.restassured.http.ContentType;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;

public class LoginRequests {

  public void postLogin(String email, String password)
      throws MalformedURLException {

    Map<String, Object> validateBody = new HashMap<>();
    validateBody.put("email", email);
    validateBody.put("password", password);

    given().relaxedHTTPSValidation().contentType(ContentType.JSON)
        .body(validateBody)
        .when().post(ServicePaths.postLogin());

  }
}
