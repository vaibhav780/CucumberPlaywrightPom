package StepDefinations;

import Factory.PlaywrightFactory;
import Pages.ProductDetails;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;

public class ProductDetailsStep {

    public ProductDetails productDetails = new ProductDetails(PlaywrightFactory.getPage());


    @When("user goto product details")
    public void userGotoProductDetails() {

        productDetails.gotoProduct();
    }

    @When("user perform operation")
    public void userPerformOperation() {
        productDetails.Checkbox();
    }
}
