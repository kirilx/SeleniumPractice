import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {

    @Test
    public static void login() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.cssSelector("[type=text]"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type=password]"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[type=submit]"));
        loginButton.click();

        WebElement productsPageTitle = driver.findElement(By.className("title"));
        Assert.assertEquals(productsPageTitle.getText(), "Products");



    }

    @Test
    public static void loginFailed() {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.cssSelector("[type=text]"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type=password]"));

        usernameField.sendKeys("locked_out_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[type=submit]"));
        loginButton.click();


        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
        Assert.assertTrue (errorMessage.isDisplayed());


        WebElement errorTextElement = driver.findElement(By.cssSelector(".error-message-container"));




        String errorText = errorTextElement.getText();
        assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.");

        String color = errorTextElement.getCssValue("color");
        Assert.assertEquals(color,"rgba(19, 35, 34, 1)");



    }
}
