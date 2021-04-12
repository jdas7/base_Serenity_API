package data;

import exceptions.UserNotFoundException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.aeonbits.owner.ConfigFactory;

import java.util.HashMap;
import java.util.Optional;

public class ScenarioFactory {

    public JsonObject getData(String clientType) throws UserNotFoundException {

        Environment environment = ConfigFactory.create(Environment.class);
        JsonParser parser = new JsonParser();
        String data = null;

        HashMap<String, String> userScenario = new HashMap<>();

        userScenario.put("cliente", environment.cliente());

        data = userScenario.get(clientType);
        Optional<String> dataOptional = Optional.ofNullable(data);
        String dataVerified = dataOptional
            .orElseThrow(() -> new UserNotFoundException("Type of user does not exist in the system"));

        return parser.parse(dataVerified).getAsJsonObject();
    }

}
