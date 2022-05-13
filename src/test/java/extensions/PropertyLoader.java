package extensions;

import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/databitrix.properties")
public interface PropertyLoader extends Config {
    String urlMain();
    String login();
    String password();
    String browserChrome();
}
