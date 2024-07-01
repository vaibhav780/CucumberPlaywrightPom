package Utils;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class EventsUtils {
     Page page;

    public EventsUtils(Page page) {
        this.page = page;
    }

    public static String getTitle(Page page){
        return page.title();
    }

    public void getScreenshot(String name){
        String currentDir = System.getProperty("user.dir");
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(currentDir + "/screenshots/"+name+""+System.currentTimeMillis()+".png"))
                        .setFullPage(true));
        ComLogger.info("Got Screenshot");
    }

}
