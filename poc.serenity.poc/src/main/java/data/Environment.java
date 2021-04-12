package data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:dev.properties"})

public interface Environment extends Config {

    String baseUrl();

    String cliente();
}


