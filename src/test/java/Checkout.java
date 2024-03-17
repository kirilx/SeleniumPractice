import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Checkout extends MainDriver {

    @Test
    public static void checkoutWithMissingFirstName() {

        WebElement usernameField = driver.findElement(By.cssSelector("[type=text]"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type=password]"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[type=submit]"));
        loginButton.click();

        WebElement tshirtLink = driver.findElement(By.partialLinkText("T-Shirt"));
        //WebElement tshirtLink = driver.findElement(By.cssSelector("a#item_1_title_link"));
        tshirtLink.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector("[name=add-to-cart-sauce-labs-bolt-t-shirt]"));
        addToCartButton.click();


        WebElement shoppingCartLink= driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartLink.click();

        WebElement shoppingCartCheckout= driver.findElement(By.cssSelector("#checkout"));
        shoppingCartCheckout.click();


        WebElement firstNameField = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastNameField = driver.findElement(By.cssSelector("#last-name"));
        WebElement postalCode = driver.findElement(By.cssSelector("#postal-code"));

         firstNameField.sendKeys("");
        lastNameField.sendKeys("Angelov");
        postalCode.sendKeys("9000");

        WebElement buttonContinue = driver.findElement(By.cssSelector("[type=submit]"));
        buttonContinue.click();


WebElement errorMessage =driver.findElement(By.cssSelector(".error-message-container"));
        String errorText = errorMessage.getText();
        Assert.assertEquals(errorText, "Error: First Name is required");



    }
    @Test
    public  void checkoutWithMissingLastName (){

        WebElement usernameField = driver.findElement(By.cssSelector("[type=text]"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type=password]"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[type=submit]"));
        loginButton.click();

        WebElement tshirtLink = driver.findElement(By.partialLinkText("T-Shirt"));
        //WebElement tshirtLink = driver.findElement(By.cssSelector("a#item_1_title_link"));
        tshirtLink.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector("[name=add-to-cart-sauce-labs-bolt-t-shirt]"));
        addToCartButton.click();


        WebElement shoppingCartLink= driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartLink.click();

        WebElement shoppingCartCheckout= driver.findElement(By.cssSelector("#checkout"));
        shoppingCartCheckout.click();


        WebElement firstNameField = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastNameField = driver.findElement(By.cssSelector("#last-name"));
        WebElement postalCode = driver.findElement(By.cssSelector("#postal-code"));

        firstNameField.sendKeys("Kiril");
        lastNameField.sendKeys("");
        postalCode.sendKeys("9000");

        WebElement buttonContinue = driver.findElement(By.cssSelector("[type=submit]"));
        buttonContinue.click();


        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
        String errorText = errorMessage.getText();
        Assert.assertEquals(errorText, "Error: Last Name is required");


    }
    @Test
    public static void checkoutWithMissingPostalCode () {

        WebElement usernameField = driver.findElement(By.cssSelector("[type=text]"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type=password]"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[type=submit]"));
        loginButton.click();

        WebElement tshirtLink = driver.findElement(By.partialLinkText("T-Shirt"));
        //WebElement tshirtLink = driver.findElement(By.cssSelector("a#item_1_title_link"));
        tshirtLink.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector("[name=add-to-cart-sauce-labs-bolt-t-shirt]"));
        addToCartButton.click();


        WebElement shoppingCartLink= driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartLink.click();

        WebElement shoppingCartCheckout= driver.findElement(By.cssSelector("#checkout"));
        shoppingCartCheckout.click();


        WebElement firstNameField = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastNameField = driver.findElement(By.cssSelector("#last-name"));
        WebElement postalCode = driver.findElement(By.cssSelector("#postal-code"));

        firstNameField.sendKeys("Kiril");
        lastNameField.sendKeys("Angelov");
        postalCode.sendKeys("");

        WebElement buttonContinue = driver.findElement(By.cssSelector("[type=submit]"));
        buttonContinue.click();


        WebElement errorMessage =driver.findElement(By.cssSelector(".error-message-container"));
        String errorText = errorMessage.getText();
        Assert.assertEquals(errorText, "Error: Postal Code is required");


    }
    @Test
    public void successCheckOut () {

        WebElement usernameField = driver.findElement(By.cssSelector("[type=text]"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type=password]"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[type=submit]"));
        loginButton.click();

        WebElement tshirtLink = driver.findElement(By.partialLinkText("T-Shirt"));
        //WebElement tshirtLink = driver.findElement(By.cssSelector("a#item_1_title_link"));
        tshirtLink.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector("[name=add-to-cart-sauce-labs-bolt-t-shirt]"));
        addToCartButton.click();


        WebElement shoppingCartLink= driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartLink.click();

        WebElement shoppingCartCheckout= driver.findElement(By.cssSelector("#checkout"));
        shoppingCartCheckout.click();


        WebElement firstNameField = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastNameField = driver.findElement(By.cssSelector("#last-name"));
        WebElement postalCode = driver.findElement(By.cssSelector("#postal-code"));

        firstNameField.sendKeys("Kiril");
        lastNameField.sendKeys("Angelov");
        postalCode.sendKeys("9000");

        WebElement buttonContinue = driver.findElement(By.cssSelector("[type=submit]"));
        buttonContinue.click();

        WebElement paymentInformation = driver.findElement(By.cssSelector(".summary_info_label"));

        String getPaymentInfo = paymentInformation.getText();
        assertEquals(getPaymentInfo,"Payment Information");

        WebElement buttonFinish = driver.findElement(By.cssSelector("#finish"));
        buttonFinish.click();

    }
    @Test
    public void completedOrder () {

        WebElement usernameField = driver.findElement(By.cssSelector("[type=text]"));
        WebElement passwordField = driver.findElement(By.cssSelector("[type=password]"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[type=submit]"));
        loginButton.click();

        WebElement tshirtLink = driver.findElement(By.partialLinkText("T-Shirt"));
        //WebElement tshirtLink = driver.findElement(By.cssSelector("a#item_1_title_link"));
        tshirtLink.click();

        WebElement addToCartButton = driver.findElement(By.cssSelector("[name=add-to-cart-sauce-labs-bolt-t-shirt]"));
        addToCartButton.click();


        WebElement shoppingCartLink= driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartLink.click();

        WebElement shoppingCartCheckout= driver.findElement(By.cssSelector("#checkout"));
        shoppingCartCheckout.click();


        WebElement firstNameField = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastNameField = driver.findElement(By.cssSelector("#last-name"));
        WebElement postalCode = driver.findElement(By.cssSelector("#postal-code"));

        firstNameField.sendKeys("Kiril");
        lastNameField.sendKeys("Angelov");
        postalCode.sendKeys("9000");

        WebElement buttonContinue = driver.findElement(By.cssSelector("[type=submit]"));
        buttonContinue.click();

        WebElement buttonFinish = driver.findElement(By.cssSelector("#finish"));
        buttonFinish.click();

        WebElement completedOrder = driver.findElement(By.cssSelector(".complete-header"));

        String thankYou = completedOrder.getText();
        assertEquals(thankYou,"Thank you for your order!");
    }
}
