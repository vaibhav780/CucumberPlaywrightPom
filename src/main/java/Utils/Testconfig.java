package Utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class Testconfig {
    static Configuration config;
    static FileBasedConfigurationBuilder<FileBasedConfiguration> builder;

    public static Configuration readProp() {
        Parameters params = new Parameters();
        builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class).configure(params.properties().setFileName("src/test/resources/locator.properties"));
        try {
            config = builder.getConfiguration();
            builder.save();

        } catch (ConfigurationException cex) {
            // loading of the configuration file failed
        }
        return config;
    }

    public static String getprop(String key) {
        return readProp().getString(key);
    }

    public static void setpro(String key, String value) {
        try {
        readProp().setProperty(key,value);
            builder.save();
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }


}
