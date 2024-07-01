package StepDefinations;

import Factory.PlaywrightFactory;
import Pages.HomePage;
import Utils.EventsUtils;
import Utils.Testconfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomePageSteps {
    public HomePage homePage = new HomePage(PlaywrightFactory.getPage());
    public EventsUtils eventsUtils = new EventsUtils(PlaywrightFactory.getPage());

    @When("user navigate to register page")
    public void userNavigateToRegisterPage() {
        homePage.goto_register();
        eventsUtils.getScreenshot(new Throwable().getStackTrace()[0].getMethodName());
    }

    @When("user verify Home Page")
    public void userVerifyHomePage() {
        Assert.assertEquals("Your Store", homePage.gettitle());
    }


    @When("user navigate to mac")
    public void userNavigateToMac() {
        homePage.gotomac();
    }

    @When("user add MAC to cart")
    public void userAddMACToCart() {
        homePage.addcartMac();
    }

    @Then("verify success message")
    public void verifySuccessMessage() {
        String successmsg=Testconfig.getprop("success.msg.txt");
        Assert.assertTrue(homePage.getSuccesmsg().contains(successmsg));
        Assert.assertEquals(Testconfig.getprop("itemMAC"),homePage.cartitemname());
    }

    @When("user navigate to login page")
    public void userNavigateToLoginPage() {
        homePage.goto_login();
    }


    @When("user got to cart")
    public void userGotToCart() {
        homePage.goto_cart();
    }


}
