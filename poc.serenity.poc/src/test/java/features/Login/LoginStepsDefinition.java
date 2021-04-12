package features.Login;

import conf.StepBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import utils.DataUserInstance;
import com.google.gson.JsonObject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginStepsDefinition extends StepBase {

    LoginRequests authenticationRequests = new LoginRequests();

    @Steps
    LoginAssertions loginAssertions;

    @When("realiza el login")
    public void sendRequestLogin() throws Throwable {
        JsonObject data = DataUserInstance.getInstance().getData();
        authenticationRequests.postLogin(data.get("email").getAsString(),
            data.get("password").getAsString());
    }

    @Then("se obtiene un token de autorizacion")
    public void responseLoginSuccess() {
        assertionsUtil.shouldSeeSuccessfulStatusCode();
        assertionsUtil.validateJSONSchema("schemas/Login.json");
        loginAssertions.verifyTokenGeneration();
        assertionsUtil.validateProperty("token","QpwL5tke4Pnpja7X4");
    }

}
