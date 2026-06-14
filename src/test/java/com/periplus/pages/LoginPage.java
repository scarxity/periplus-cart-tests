package com.periplus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-signin-text")));
    }
}
