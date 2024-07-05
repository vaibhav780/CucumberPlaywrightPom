package Pages;

import Utils.ConfigReader;
import Utils.EventsUtils;
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

    public void removeProduct(){
        page.click(ConfigReader.getProperty("shoppingcart.remove"));
        EventsUtils.pause(3000);
    }

}
