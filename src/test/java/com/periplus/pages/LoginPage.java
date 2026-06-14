package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get("https://www.periplus.com/account/Login");
    }

    public void login(String email, String password) {
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.id("ps"));
        WebElement submitButton = driver.findElement(By.id("button-login"));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        submitButton.click();
    }
}
