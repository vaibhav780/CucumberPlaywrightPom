package Pages;

import Utils.ComLogger;
import Utils.ConfigReader;
import Utils.Datagen;
import Utils.Testconfig;
import com.microsoft.playwright.Page;

import javax.xml.crypto.Data;

public class Register {
    Page page;
    public Datagen datagen = new Datagen();

    public Register(Page page) {
        this.page = page;
    }

    public void enterData(){
        String email = datagen.getEmail();
        String pass= datagen.getPassword();
        page.fill(Testconfig.getprop("register.firstname"), datagen.getFnam());
       // page.fill(Testconfig.getpro("register.middlename"), datagen.getMiddlename());
        page.fill(Testconfig.getprop("register.lastname"), datagen.getLastname());
        page.fill(Testconfig.getprop("register.email"), email);
        ComLogger.info(datagen.getEmail());
        page.fill(Testconfig.getprop("register.telephone"), datagen.getTelephone());
        page.fill(Testconfig.getprop("register.password"), pass);
        page.fill(Testconfig.getprop("register.confirmpass"), pass);
        page.check(Testconfig.getprop("register.agree"));
        page.click(Testconfig.getprop("register.continue"));
        page.click(Testconfig.getprop("register.complete"));
        Testconfig.setpro("email",email);
        Testconfig.setpro("password1",pass);
        ComLogger.info(Testconfig.getprop("email")+" "+Testconfig.getprop("password1"));
    }

}
