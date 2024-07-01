package Pages;

import com.microsoft.playwright.Page;

public class PIM {
    Page page;

    String addbtn="//*[@class=\"orangehrm-header-container\"]/button";
    String fname="//*[@name='firstName']";
    String midname="//*[@name='middleName']";
    String lastname="//*[@name='lastName']";
    String savebtn ="//*[@type='submit']";
    //li[@class='oxd-topbar-body-nav-tab --visited']
    public PIM(Page page) {
        this.page = page;
    }

    public void ClickAdd(){
        page.click(addbtn);
    }

    public void add_emp(){
        page.fill(fname,"empfname");
        page.fill(midname,"empmidname");
        page.fill(lastname,"emplastname");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.click(savebtn);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        page.click("//*[@class=\"oxd-topbar-body-nav\"]/ul/li[2]");
    }
}
