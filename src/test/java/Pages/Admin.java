package Pages;

import com.microsoft.playwright.Page;

public class Admin {
    Page page;

    String addbtn="//*[@class=\"orangehrm-header-container\"]/button";
    String selectRole="//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]";

    public Admin(Page page) {
        this.page = page;
    }

    public void Click_add(){
    page.click(addbtn);
    }
    public void Add_details(){
        page.locator("//label[contains(., 'User Role')]//following::div[1]//div[@class='oxd-select-text-input']").click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.locator("(//div[@role='listbox']//child::div)[2]").click();
    }
}
