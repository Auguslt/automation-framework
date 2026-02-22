package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    
    private By cartButton = By.id("shopping_cart_container");
   

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToCart() {
        driver.findElement(cartButton).click();
    }

    public boolean isProductInCart(String productName) {
        return driver.findElement(By.xpath("//div[text()='" + productName + "']")).isDisplayed();
    }
}
