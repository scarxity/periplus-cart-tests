package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://www.periplus.com/checkout/cart");
    }

    public Integer getCartBadgeCount() {
        WebElement count = driver.findElement(By.id("cart_total"));
        return Integer.parseInt(count.getText());
    }

    public String getCartItemName() {
        List<WebElement> names = driver.findElements(By.className("product-name"));
        return names.getFirst().getText();
    }
}
