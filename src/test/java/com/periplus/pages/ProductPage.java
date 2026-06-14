package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(Integer count) {
        WebElement quantityField = driver.findElement(By.cssSelector("[id^='qty_']"));
        WebElement addToCartButton = driver.findElement(By.className("btn-add-to-cart"));

        quantityField.clear();
        quantityField.sendKeys(count.toString());
        addToCartButton.click();
    }
}
