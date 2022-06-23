package utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.configuration.SystemPropertiesConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;

public final class EnvironmentProperties {

    private static final Configuration configuration = new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
    private static final EnvironmentVariables environmentVariables = configuration.getEnvironmentVariables();

    private EnvironmentProperties() {
    }

    public static String getProperty(String nameProperty) {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(nameProperty);
    }

}
