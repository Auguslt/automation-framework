package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.CartPage;

public class ProductTest extends BaseTest {

    @Test(description = "Agregar producto al carrito")
    public void addProductToCart() {
        driver.get("https://www.saucedemo.com/inventory.html");
        
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductToCart("Sauce Labs Backpack");

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"));
    }
}