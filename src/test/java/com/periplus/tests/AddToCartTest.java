package com.periplus.tests;

import com.periplus.base.BaseTest;
import com.periplus.pages.CartPage;
import com.periplus.pages.LoginPage;
import com.periplus.pages.ProductPage;
import com.periplus.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class AddToCartTest extends BaseTest {
    @Test
    public void addToCartTest() {
        // Get credentials from env
        Properties config = new Properties();
        try {
            config.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties", e);
        }

        String email = config.getProperty("email");
        String password = config.getProperty("password");

        LoginPage loginPage = new LoginPage(driver);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, wait);
        ProductPage productPage = new ProductPage(driver, wait);
        CartPage cartPage = new CartPage(driver);

        loginPage.navigateTo();
        loginPage.login(email, password);

        searchResultsPage.search("Atomic Habits");
        searchResultsPage.clickFirstResult();

        productPage.addToCart(1);

        cartPage.navigateTo();
        String itemName = cartPage.getCartItemName();
        Integer count = cartPage.getCartBadgeCount();

        // Assertions
        Assert.assertEquals(itemName, "Atomic Habits");
        Assert.assertEquals(count, 1);
    }
}
