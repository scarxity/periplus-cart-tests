package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SearchResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void search(String keyword) {
        WebElement searchField = driver.findElement(By.id("filter_name_desktop"));

        searchField.sendKeys(keyword);
        searchField.sendKeys(Keys.RETURN);
    }

    public void clickFirstResult() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("preloader")));
        List<WebElement> books = driver.findElements(By.cssSelector(".single-product"));
        books.getFirst().click();
    }

}
