package Factory;

import Utils.ComLogger;
import com.microsoft.playwright.*;

public class PlaywrightFactory {
    public Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static ThreadLocal<Page> threadLocalDriver = new ThreadLocal<>(); //For Parallel execution
    public static ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();

    //Launches Browser as set by user in config file
    public Page initbrowser() {
        BrowserType browserType = null;
        browserType = Playwright.create().chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        threadLocalDriver.set(page);
        threadLocalContext.set(context);
        ComLogger.info("Init Page Driver");
        return page;

    }

    public static synchronized Page getPage() {
        return threadLocalDriver.get(); // Will return Initialized Thread Local Driver
    }

    public static synchronized BrowserContext getContext() {
        return threadLocalContext.get(); // Will return Initialized Thread Local Context
    }

}
