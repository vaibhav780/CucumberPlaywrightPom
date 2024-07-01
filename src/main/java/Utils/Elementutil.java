//package Utils;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//public class Elementutil {
//    private WebDriver driver;
//    int min = 16600;
//    int max = 16800;
//
//    public Elementutil(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public WebElement findElement(By locator) {
//        ComLogger.info("Searching for Element" + locator);
//        return driver.findElement(locator);
//    }
//
//    public WebElement waitForElement(By locator, long Secconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Secconds);
//        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//    }
//
//    public Boolean isDisplayed(By locator) {
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        ComLogger.info(locator + " Element is present");
//        return true;
//    }
//
//    public void enter_text(By locator, String text) {
//        try {
//            if (isDisplayed(locator)) {
//                findElement(locator).sendKeys(text);
//                ComLogger.info(locator + "for Element " + text + " entered");
//            } else {
//                ComLogger.error(locator + "element not found");
//            }
//        } catch (NoSuchElementException e) {
//            e.getStackTrace();
//        }
//    }
//
//    public void Click(By locator) {
//        try {
//            if (isDisplayed(locator)) {
//                findElement(locator).click();
//                ComLogger.info("clicked on element" + locator);
//            } else {
//                System.out.println("element not found");
//            }
//        } catch (NoSuchElementException e) {
//            e.getStackTrace();
//        }
//    }
//
//
//    public void takeSS() {
//
//        try {
//            Thread.sleep(5000);
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String currentDir = System.getProperty("user.dir");
//            FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
//        } catch (InterruptedException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public String getText(By locator) {
//        String gotText = null;
//        try {
//            if (isDisplayed(locator)) {
//                gotText = findElement(locator).getText();
//                ComLogger.info(locator + " has text " + gotText);
//            }
//
//        } catch (NoSuchElementException e) {
//            e.getStackTrace();
//        }
//        return gotText;
//    }
//
//    public void pause(long sec) {
//        try {
//            Thread.sleep(sec);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public String getTtile() {
//        return driver.getTitle();
//    }
//
//    public void clear_text(By locator) {
//        try {
//            if (isDisplayed(locator)) {
//                findElement(locator).clear();
//                ComLogger.info(locator + "for Element cleared text");
//            } else {
//                ComLogger.error(locator + "element not found");
//            }
//        } catch (NoSuchElementException e) {
//            e.getStackTrace();
//        }
//    }
//
//    public int getRandomport() {
//        return (int) ((Math.random() * (max - min)) + min);
//    }
//
//    public void ClickWithText(String text) {
//        try {
//            WebElement text_ele = driver.findElement(By.xpath("//*[contains(text(), " + text + ")]"));
//            ComLogger.info("Searching element with Text " +text);
//        } catch (NoSuchElementException | ElementNotVisibleException e) {
//            e.getStackTrace();
//            ComLogger.info("Element with text " + text + " Not Found");
//        }
//    }
//    public String generateString(int length){
//        return "host"+RandomStringUtils.randomAlphanumeric(length);
//    }
//    public void refresh(String hostname ,String expectedStatus){
//        while(getStatus(hostname).contains(expectedStatus)){
//            System.out.println(getStatus(hostname));
//           ComLogger.info("Waiting for Expected Status: " +expectedStatus+" current Status: " +getStatus(hostname));
//            Click(By.xpath("//*[@label='btnRefresh']"));
//        }
//    }
//    public String getStatus(String hostname) {
//        String status = null;
//        List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"_jsx_0_2ojsx_0\"]/tbody/tr"));
//
//        for (int i = 0; i <= row.size(); i++) {
//            List<WebElement> hostn = driver.findElements(By.xpath("//*[@id=\"_jsx_0_2ojsx_0\"]/tbody/tr["+ i +"]/td[1]/div"));
//            for (WebElement ele : hostn) {
//                System.out.println(ele.getText());
//                if (ele.getText().contains(hostname)){
//
//                     status =driver.findElement(By.xpath("//*[@id=\"_jsx_0_2ojsx_0\"]/tbody/tr["+ i +"]/td[6]/div/span")).getText();
//                    ComLogger.info("Current Status: "+status);
//                }
//            }
//        }
//        return status;
//    }
//    public void doRefresh(){
//        for(int i=0;i<3;i++){
//            Click(By.xpath("//*[@label='btnRefresh']"));
//            pause(2000);
//        }
//    }
//
//    public WebElement getElements(By locator,int index){
//        ComLogger.info("Searching for Element" + locator);
//        List<WebElement> elements= driver.findElements(locator);
//        System.out.println(elements.size());
//        return elements.get(index);
//    }
//
//    public void Click_Linktext(String text){
//        try {
//            List<WebElement> elements = driver.findElements(By.linkText(text));
//            if(!elements.isEmpty()){
//                for (WebElement ele:elements) {
//                   if(ele.getText().contains(text)) {
//                       ele.click();
//                   }
//                }
//            }
//        }catch (NoSuchElementException | ElementNotVisibleException e){
//            e.getStackTrace();
//        }
//    }
//    public void SwitchIframe(String name){
//      try {
//          List<WebElement> iframes= driver.findElements(By.tagName("iframe"));
//            ComLogger.info("Iframe Found "+iframes.size());
//          if (!iframes.isEmpty()){
//              ComLogger.info("Switiching to Iframe "+name);
//              driver.switchTo().frame(name);
//          }
//      }catch (NoSuchElementException | ElementNotVisibleException e){
//          e.getStackTrace();
//      }
//
//
//    }
//}
