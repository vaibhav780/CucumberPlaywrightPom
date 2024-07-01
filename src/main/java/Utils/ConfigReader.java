package Utils;


import org.apache.commons.configuration.*;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;

import java.io.File;

public class ConfigReader {

    org.apache.commons.configuration2.Configuration config;
    FileBasedConfigurationBuilder<FileBasedConfiguration> builder;
    public static Configuration readProp() {
//        Configurations configs = new Configurations();
//        Configuration config;
//        try {
//            config= configs.properties(new File("src/test/resources/Application.properties"));
//            config= configs.properties(new File("src/test/resources/locator.properties"));
//        } catch (ConfigurationException e) {
//            throw new RuntimeException(e);
////        }
        CompositeConfiguration config = new CompositeConfiguration();
        config.addConfiguration(new SystemConfiguration());
        try {
            config.addConfiguration(new PropertiesConfiguration("src/test/resources/locator.properties"));
            config.addConfiguration(new PropertiesConfiguration("src/test/resources/Application.properties"));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }



        return config;
    }

    public static String getProperty(String key) {
        return readProp().getString(key);
    }

    public static void setproperty(String key , String value){
        System.out.println(key +" "+value);
        readProp().setProperty(key,value);

    }
}
