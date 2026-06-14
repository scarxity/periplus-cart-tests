package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void addToCart(Integer count) {
        WebElement quantityField = driver.findElement(By.cssSelector("[id^='qty_']"));
        WebElement addToCartButton = driver.findElement(By.className("btn-add-to-cart"));

        quantityField.sendKeys(Keys.CONTROL + "a");
        quantityField.sendKeys(count.toString());

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ti-check")));
    }
}
