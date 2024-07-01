package StepDefinations;

import Factory.PlaywrightFactory;
import Pages.ShoppingCart;
import Utils.Testconfig;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ShoppingcartStep {

    public ShoppingCart shoppingCart= new ShoppingCart(PlaywrightFactory.getPage());


    @Then("verify item name in cart")
    public void verifyItemNameInCart() {
        Assert.assertEquals(Testconfig.getprop("itemMAC"),shoppingCart.getitemName());

    }
}
