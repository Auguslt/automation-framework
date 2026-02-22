package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']/following-sibling::button")).click();
    }
}