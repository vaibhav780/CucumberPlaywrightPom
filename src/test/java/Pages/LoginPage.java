package Pages;

import Utils.ConfigReader;
import Utils.Testconfig;
import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;
    public LoginPage(Page page) {
        this.page = page;
    }

    public void fillusername(String uname){
        page.fill(Testconfig.getprop("login.username"),uname);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void fillpassword(String pass){
        page.fill(Testconfig.getprop("login.password"),pass);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void doLogin(String username, String password){
        fillusername(username);
        fillpassword(password);
        page.click(Testconfig.getprop("login.loginbtn"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
