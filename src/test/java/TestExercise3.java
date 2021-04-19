import pageObjects.*;
import io.qameta.allure.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestExercise3 extends Base {
    private MainPage mainPage;
    private InventoryPage inventoryPage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutStep1Page checkoutStep1Page;
    private SuccessPage successPage;

    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
        mainPage = new MainPage(driver);
        inventoryPage= new InventoryPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkoutStep1Page = new CheckoutStep1Page(driver);
        successPage = new SuccessPage(driver);
        driver.get(mainPage.getUrl());
    }

    @Test(dataProvider = "checkout data", dataProviderClass = DataProvider.class)
    @Description("Test of the Exercise 3")
    public void testExercise3 (String firstName,String lastName, String postalCode) {
        String items;
        mainPage.logIn();
        items = inventoryPage.addItems();
        Assert.assertEquals(items,"6");
        inventoryPage.enterCart();
        shoppingCartPage.checkPrice();
        checkoutStep1Page.sendInformation(firstName,lastName,postalCode);
        Assert.assertEquals(checkoutStep1Page.subTotalprice(),"$129.94");
        checkoutStep1Page.finish();
        Assert.assertTrue(successPage.verifySuccess());
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}