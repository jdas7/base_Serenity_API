package conf;

import data.Environment;
import utils.AssertionsUtil;
import net.thucydides.core.annotations.Steps;
import org.aeonbits.owner.ConfigFactory;

public abstract class StepBase {

    private final Environment environment;

    protected StepBase() {
        environment = ConfigFactory.create(Environment.class);
    }

    protected Environment getEnvironment() {
        return environment;
    }

    @Steps
    public AssertionsUtil assertionsUtil;


}
