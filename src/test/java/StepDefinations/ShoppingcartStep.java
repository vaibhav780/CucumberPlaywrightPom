package StepDefinations;

import Factory.PlaywrightFactory;
import Pages.ShoppingCart;
import Utils.Testconfig;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShoppingcartStep {

    public ShoppingCart shoppingCart= new ShoppingCart(PlaywrightFactory.getPage());


    @Then("verify item name in cart")
    public void verifyItemNameInCart() {
        Assert.assertEquals(Testconfig.getprop("itemMAC"),shoppingCart.getitemName());

    }

    @When("user removes cart item")
    public void userRemovesCartItem() {
        shoppingCart.removeProduct();
    }
}
