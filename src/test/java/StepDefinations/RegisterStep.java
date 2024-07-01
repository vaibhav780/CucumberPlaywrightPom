package StepDefinations;

import Factory.PlaywrightFactory;
import Pages.Register;
import Utils.ConfigReader;
import Utils.EventsUtils;
import Utils.Testconfig;
import io.cucumber.java.an.E;
import io.cucumber.java.en.When;

public class RegisterStep {
    public Register register = new Register(PlaywrightFactory.getPage());
    public EventsUtils eventsUtils= new EventsUtils(PlaywrightFactory.getPage());


    @When("user Register in application")
    public void userRegisterInApplication() {
        register.enterData();
        eventsUtils.getScreenshot(new Throwable().getStackTrace()[0].getMethodName());

        eventsUtils.getScreenshot(new Throwable().getStackTrace()[0].getMethodName());
    }
}
