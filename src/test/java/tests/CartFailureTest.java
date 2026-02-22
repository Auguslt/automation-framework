package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartFailureTest extends BaseTest {

    @Test(description = "Verificar que un producto no está en el carrito")
    public void verifyProductNotInCart() {
        driver.get("https://www.saucedemo.com/cart.html");
        
        CartPage cartPage = new CartPage(driver);
        Assert.assertFalse(cartPage.isProductInCart("Sauce Labs Onesie"));  // Este producto no fue añadido, por lo que debe fallar
    }
}