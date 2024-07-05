package Pages;

import Utils.ConfigReader;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.io.File;
import java.nio.file.Paths;

public class ProductDetails {

    Page page;

    public ProductDetails(Page page) {
        this.page = page;
    }

    public String getitemName(){
        return page.locator(ConfigReader.getProperty("home.item.name.txt")).textContent();
    }

    public void gotoProduct() {
        String itemloctor = "//img[@alt='" + getitemName() + "']";
         page.locator(itemloctor).click();
    }

    public void Checkbox(){
        page.check(ConfigReader.getProperty("product.checkbox1"));
        page.click(ConfigReader.getProperty("product.radiobtn1"));
        page.fill(ConfigReader.getProperty("product.txt"),"testingvalue");
        page.selectOption(ConfigReader.getProperty("product.dropdwn"),"4");
        page.fill(ConfigReader.getProperty("product.textara"),"This is test to check playwright");
       FileChooser fileChooser = page.waitForFileChooser(() -> {  page.getByText("Upload File").click();});
        fileChooser.setFiles(Paths.get("src/test/data/uploadfile.txt"));
//        page.setInputFiles(ConfigReader.getProperty("product.fileupload"),Paths.get("src/test/data/uploadfile.txt"));
        page.fill(ConfigReader.getProperty("product.date"),"2024-07-21");
        page.fill(ConfigReader.getProperty("product.time"),"15:21");
        page.fill(ConfigReader.getProperty("product.datetime"),"2024-07-21 15:21");
        page.fill(ConfigReader.getProperty("product.qty"),"4");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.click(ConfigReader.getProperty("product.addcart"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
