package apis;

import data.Environment;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class ServicePaths {

    private static final Environment environment;

    static {
        environment = ConfigFactory.create(Environment.class);
    }

    private ServicePaths() {
        throw new IllegalStateException("Utility class");
    }

    public static URL postLogin()
        throws MalformedURLException {
        return new URL(environment.baseUrl() + "/login");
    }

}
