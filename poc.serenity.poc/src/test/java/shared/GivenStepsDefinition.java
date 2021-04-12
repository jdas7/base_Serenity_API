package shared;

import data.ScenarioFactory;
import exceptions.UserNotFoundException;
import io.cucumber.java.en.Given;
import utils.DataUserInstance;
import com.google.gson.JsonObject;

public class GivenStepsDefinition {

    @Given("que {word} es un {string}")
    public void userRole(String actor, String userRole) {
        ScenarioFactory scenarioFactory = new ScenarioFactory();
        JsonObject data = null;
        try {
            data = scenarioFactory.getData(userRole);
            DataUserInstance.getInstance().setData(data);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

}
