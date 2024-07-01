package StepDefinations;

import Factory.PlaywrightFactory;
import Utils.ComLogger;
import Utils.ConfigReader;
import Utils.Testconfig;
import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class AppHooks  extends PlaywrightFactory {
    public PlaywrightFactory playwrightFactory;
    public   Page page;


    @Before
    public void setup(Scenario scenario){
        String currentDir = System.getProperty("user.dir");
        try {
            FileUtils.cleanDirectory(new File(String.format("%s/screenshots/", currentDir)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initbrowser();
        ComLogger.info(Testconfig.getprop("url"));
        page.navigate(Testconfig.getprop("url"));
        ComLogger.info("+++++++++++++++++++++++++SCENARIO STARTED+++++++++++++++++++++++++");
        ComLogger.info("+++++++++++++++++++++++++" + scenario.getName() + "+++++++++++++++++++++++++");
        ComLogger.info("Driver initied");
    }



    @After
    public void teardown(Scenario scenario){
        page.context().browser().close();
        ComLogger.info("Page Driver Closed");
        ComLogger.info("Driver Closed");
        ComLogger.info("+++++++++++++++++++++++++SCENARIO END+++++++++++++++++++++++++");
    }
}
