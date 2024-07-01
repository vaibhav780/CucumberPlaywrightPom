package StepDefinations;

import Pages.LoginPage;
import Factory.PlaywrightFactory;
import Utils.ComLogger;
import Utils.ConfigReader;
import Utils.EventsUtils;
import Utils.Testconfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;

public class LoginStep {
    public LoginPage loginPage=  new LoginPage(PlaywrightFactory.getPage());


    @Given("user launched application")
    public void userLaunchedApplication() {
        ComLogger.info("Launched browser");
    }


    @When("user login in application")
    public void userLoginInApplication() {
        loginPage.doLogin(Testconfig.getprop("email"),Testconfig.getprop("password1"));
    }
}
