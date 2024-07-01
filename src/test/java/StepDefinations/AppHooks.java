package StepDefinations;

import Factory.PlaywrightFactory;
import Utils.ComLogger;
import Utils.ConfigReader;
import Utils.Testconfig;
import com.microsoft.playwright.*;

import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.TestInstance;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;


public class AppHooks  extends PlaywrightFactory {
    public PlaywrightFactory playwrightFactory;
    public   Page page;

    @BeforeAll
    public static void clearReports(){
        String currentDir = System.getProperty("user.dir");
        try {
            FileUtils.cleanDirectory(new File(String.format("%s/screenshots/", currentDir)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setup(Scenario scenario){


        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initbrowser();
        ComLogger.info(Testconfig.getprop("url"));
        page.navigate(Testconfig.getprop("url"));
        ComLogger.info("+++++++++++++++++++++++++SCENARIO STARTED+++++++++++++++++++++++++");
        ComLogger.info("+++++++++++++++++++++++++" + scenario.getName() + "+++++++++++++++++++++++++");
        ComLogger.info("Driver initied");
        System.out.println(scenario.getLine());
    }

    @AfterStep
    public void recordsteps(Scenario scenario){
        String scenarioName=scenario.getName();
        String step=scenarioName+"-"+scenario.getLine();
        String currentDir = System.getProperty("user.dir");
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(currentDir + "/screenshots/"+step+System.currentTimeMillis()+".png"))
                .setFullPage(true));
        ComLogger.info("Got Screenshot");
    }


    @After
    public void teardown(Scenario scenario){
        page.context().browser().close();
        ComLogger.info("Page Driver Closed");
        ComLogger.info("Driver Closed");
        ComLogger.info("+++++++++++++++++++++++++SCENARIO END+++++++++++++++++++++++++");
    }
}
