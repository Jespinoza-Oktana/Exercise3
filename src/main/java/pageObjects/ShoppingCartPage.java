package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {
    private final WebDriver driver;

    @FindBy(className = "inventory_item_price")
    List<WebElement> priceList;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void checkPrice(){
        float sum=0;
        System.out.println("price of the 6 items");
        for(WebElement price:priceList){
            System.out.println(price.getText());
            sum = sum+Float.valueOf(price.getText().substring(1));
        }
        System.out.println("\nThe total sum of the prices is");
        System.out.println("$" +sum);
        checkoutButton.click();
    }
}
