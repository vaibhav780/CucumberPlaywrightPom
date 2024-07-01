package Pages;

import Utils.Testconfig;
import com.microsoft.playwright.Page;

public class HomePage {
    Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void goto_register() {
        page.click(Testconfig.getprop("homepage.myaccount"));
        page.click(Testconfig.getprop("homepage.register"));
    }
    public void goto_login(){
        page.click(Testconfig.getprop("homepage.myaccount"));
        page.click(Testconfig.getprop("homepage.login"));
    }

    public void goto_cart(){
        page.click(Testconfig.getprop("homepage.shoopingcart"));
    }
    public String gettitle(){
        return page.title();
    }

    public void gotomac(){
        page.hover(Testconfig.getprop("home.menu1"));
        page.click(Testconfig.getprop("home.desktop.mac"));
    }
    public String  cartitemname(){
       return page.locator(Testconfig.getprop("success.itemname")).textContent();
    }
    public void addcartMac(){
        page.click(Testconfig.getprop("home.item1.addcart"));
        Testconfig.setpro("itemMAC",page.locator(Testconfig.getprop("home.item1.name")).textContent());
    }
    public String getSuccesmsg(){
        System.out.println(page.locator(Testconfig.getprop("success.msg")).textContent());
       return page.locator(Testconfig.getprop("success.msg")).textContent();
    }
}


