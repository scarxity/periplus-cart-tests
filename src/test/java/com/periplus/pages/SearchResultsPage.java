package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {
    private final WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String keyword) {
        WebElement searchField = driver.findElement(By.id("filter_name_desktop"));

        searchField.sendKeys(keyword);
        searchField.sendKeys(Keys.RETURN);
    }

    public void clickFirstResult() {
        List<WebElement> books = driver.findElements(By.cssSelector(".single-product"));
        books.getFirst().click();
    }
    
}
