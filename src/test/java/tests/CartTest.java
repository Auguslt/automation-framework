package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test(description = "Verificar contenido del carrito")
    public void verifyCartContent() {
        driver.get("https://www.saucedemo.com/cart.html");
        
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"));
    }
}