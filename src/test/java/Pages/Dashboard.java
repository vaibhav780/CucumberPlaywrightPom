package Pages;

import Utils.ComLogger;
import com.microsoft.playwright.Page;

public class Dashboard {
    Page page;
    String pagehead= "//h6";
    String userdrpdwn="//*[@class='oxd-userdropdown-name']";
    String logout ="//*[@class=\"oxd-dropdown-menu\"]/li[4]";
    String adminSection="//*[@class=\"oxd-main-menu\"]/li[1]/a";
    String PIMSection="//*[@class=\"oxd-main-menu\"]/li[2]/a";
    String sectionHead ="//h6[1]";

    public Dashboard(Page page) {
        this.page = page;
    }

    public String getPageHeader() {
        return headerText(pagehead);
    }

    public void user_logout(){
        page.click(userdrpdwn);
        page.click(logout);
    }

    public void go_adminSection(){
        page.click(adminSection);
    }

    public String getSectionHeader(){
        return headerText(sectionHead);
    }
    public String headerText(String locator){
        return page.locator(locator).textContent();
    }

    public void movetoPIM(){
        page.click(PIMSection);
    }
}
