package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigateTo() {
        driver.get("https://www.periplus.com/checkout/cart");
    }

    public void clearCart() {
        List<WebElement> removeButtons = driver.findElements(By.className("btn-cart-remove"));
        while (!removeButtons.isEmpty()) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
            removeButtons.getFirst().click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
            removeButtons = driver.findElements(By.className("btn-cart-remove"));
        }
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
