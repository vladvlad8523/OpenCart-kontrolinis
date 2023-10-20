import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static java.awt.SystemColor.window;


public class OpenCartTest extends BaseDriverSettings {
    @Test
    void testKontrolinis () throws InterruptedException {
        WebElement search = driver.findElement(By.name("search"));
        search.sendKeys("Palm Treo Pro");
        driver.findElement(By.cssSelector(".btn.btn-light.btn-lg")).click();

        WebElement clickElement = driver.findElement(By.xpath("//h4/a[text()='Palm Treo Pro']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", clickElement);

        WebElement addPalmTreoPro = driver.findElement(By.cssSelector("button#button-cart"));
        addPalmTreoPro.click();

        driver.findElement(By.cssSelector("button.btn-close")).click();

        WebElement openCardShopping = driver.findElement(By.xpath("//a[@title='Shopping Cart']"));
        openCardShopping.click();

        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //scroll down
        Thread.sleep(1000);
        WebElement checkout = driver.findElement(By.xpath("//div[@class='col text-end']/a"));
        checkout.click();

        //Thread.sleep(2000);
        driver.findElement(By.xpath("/html//input[@id='input-guest']")).click();
        /**
         * pildom forma
         */
        Thread.sleep(2000);
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("Tom");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Jery");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("Jyour@email.com");

        WebElement inputShippingAddress = driver.findElement(By.id("input-shipping-address-1"));
        inputShippingAddress.sendKeys("savanoriu");

        WebElement inputShippingCity = driver.findElement(By.id("input-shipping-city"));
        inputShippingCity.sendKeys("vilnius");
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //scroll down

        WebElement inputIhippingPostcode = driver.findElement(By.cssSelector("#input-shipping-postcode"));
        inputIhippingPostcode.sendKeys("LT-01100");


        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //scroll down
        driver.findElement(By.xpath("//*[@id='input-shipping-zone']/option[5]")).click();

        Thread.sleep(5000);
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //scroll down
        WebElement agree = driver.findElement(By.xpath("/html//button[@id='button-register']"));
        agree.click();

        driver.findElement(By.cssSelector("button.btn-close")).click();

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript("window.scrollTo(0, 1000)"); //scroll up

        driver.findElement(By.xpath("//button[@id='button-shipping-methods']")).click();

        driver.findElement(By.xpath("/html//input[@id='input-shipping-method-flat-flat']")).click();
        driver.findElement(By.xpath("/html//button[@id='button-shipping-method']")).click();
        driver.findElement(By.xpath("/html//button[@id='button-payment-methods']")).click();
        driver.findElement(By.xpath("/html//input[@id='input-payment-method-cod-cod']")).click();
        driver.findElement(By.xpath("/html//input[@id='input-payment-method-cod-cod']")).click();

        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //scroll down
        driver.findElement(By.xpath("/html//button[@id='button-confirm']")).click();


        driver.findElement(By.linkText("Continue")).click();

    }
}
