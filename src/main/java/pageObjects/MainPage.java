package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final WebDriver driver;
    private final String url = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    WebElement enterUsername;

    @FindBy(id = "password")
    WebElement enterPassword;

    @FindBy(id = "login-button")
    WebElement login_button;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void logIn(){
        enterUsername.sendKeys("standard_user");
        enterPassword.sendKeys("secret_sauce");
        login_button.click();
    }

    public String getUrl() {
        return url;
    }
}