package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class InventoryPage {
    private final WebDriver driver;

    @FindBy(xpath = "//button[contains(@class, 'btn')]")
    List<WebElement> toBeAddedList;

    @FindBy(className = "shopping_cart_badge")
    WebElement numberOnCart;

    public InventoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String addItems() {
        for (WebElement item:toBeAddedList){
            item.click();
        }
        return numberOnCart.getText();
    }
    public void enterCart(){
        numberOnCart.click();

    }
}
