package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {
    private final WebDriver driver;

    @FindBy(className = "title")
    WebElement successMessage;

    public SuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifySuccess(){
        return successMessage.isDisplayed();
    }
}
