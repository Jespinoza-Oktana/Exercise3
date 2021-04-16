package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutStep1Page {
    private final WebDriver driver;

    @FindBy(id = "first-name")
    WebElement enterFirstName;

    @FindBy(id = "last-name")
    WebElement enterLastName;

    @FindBy(id = "postal-code")
    WebElement enterPostalCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(className = "summary_subtotal_label")
    WebElement subTotal;

    @FindBy(id = "finish")
    WebElement finishButton;

    public CheckoutStep1Page(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void sendInformation(String firstName,String lastName,String postalCode){
        enterFirstName.sendKeys(firstName);
        enterLastName.sendKeys(lastName);
        enterPostalCode.sendKeys(postalCode);
        continueButton.click();
    }

    public void finish(){
        finishButton.click();
    }

    public String subTotalprice(){
        return subTotal.getText().substring(12);
    }
}
