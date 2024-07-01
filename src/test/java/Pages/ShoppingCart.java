package Pages;

import Utils.Testconfig;
import com.microsoft.playwright.Page;

public class ShoppingCart {
    Page page;

    public ShoppingCart(Page page) {
        this.page = page;
    }

    public String getitemName(){
       return page.locator(Testconfig.getprop("cart.item.name")).textContent();
    }

}
