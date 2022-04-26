package shopping;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.sql.Timestamp;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
        //1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));

        //1.2 Mouse hover on the “Bestsellers”  link and click
        mouseHover(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        Thread.sleep(300);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));

        //1.3 Verify the text “Bestsellers”
       // Thread.sleep(300);
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Bestsellers']"));
        String expectedMessage = "Bestsellers";
        Assert.assertEquals("Not navigate to page", expectedMessage, actualMessage);

        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[text()='Sort by:']"));
        Thread.sleep(400);
        clickOnElement(By.xpath("//li[@class='list-type-grid ']//a[@data-sort-by='translations.name' and @data-sort-order='asc']"));
        Thread.sleep(300);

        //1.5 Click on “Add to cart” button of the product “Ollie - The App Controlled Robot”
        mouseHover(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[1]/a[1]/img[1]"));
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-42']"));

        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        String actualMessage1 = getTextFromElement(By.xpath("//li[text()='Product has been added to your cart']"));
        String expectedMessage1 = "Product has been added to your cart";
        Assert.assertEquals("Not navigate to page", expectedMessage1, actualMessage1);

        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));

        //1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(400);
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));

        //1.9 Verify the text “Your shopping cart - 1 item”
        String actualMessage2 = getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 1 item']"));
        String expectedMessage2 = "Your shopping cart - 1 item";
        Assert.assertEquals("Not navigate to page", expectedMessage2, actualMessage2);

        //1.10 Verify the Subtotal $299.00
        String actualMessage5_1 = getTextFromElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/span[1]/span[1]/span[1]"));
        String actualMessage5_3 = getTextFromElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/span[1]/span[1]/span[3]"));
        String actualMessage5_2 = getTextFromElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/span[1]/span[1]/span[2]"));
        String actualMessage5_4 = getTextFromElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[1]/span[1]/span[1]/span[1]/span[4]"));
        String actualMessage3 = actualMessage5_1 + actualMessage5_2 + actualMessage5_3 + actualMessage5_4; // Combining price to single string
        String expectedMessage3 = "$299.00";
        Assert.assertEquals("Not navigate to page", expectedMessage3, actualMessage3);

        //1.11 Verify the total $309.73
        String actualMessage6_1 = getTextFromElement(By.xpath("//li[@class='total']//span/span[@class='surcharge-cell']/span[@class ='part-prefix']"));
        String actualMessage6_2 = getTextFromElement(By.xpath("//li[@class='total']//span/span[@class='surcharge-cell']/span[@class ='part-integer']"));
        String actualMessage6_3 = getTextFromElement(By.xpath("//li[@class='total']//span/span[@class='surcharge-cell']/span[@class ='part-decimalDelimiter']"));
        String actualMessage6_4 = getTextFromElement(By.xpath("//li[@class='total']//span/span[@class='surcharge-cell']/span[@class ='part-decimal']"));
        String actualMessage4 = actualMessage6_1 + actualMessage6_2 + actualMessage6_3 + actualMessage6_4;// Combining price to single string
        String expectedMessage4 = "$309.73";
        Assert.assertEquals("Not navigate to page", expectedMessage4, actualMessage4);

        //1.12 Click on “Go to checkout” button
        clickOnElement(By.xpath("//button[@class='btn  regular-button regular-main-button checkout']"));

        //1.13 Verify the text “Log in to your account”
        String actualMessage5 = getTextFromElement(By.xpath("//h3[text()='Log in to your account']"));
        String expectedMessage5 = "Log in to your account";
        Assert.assertEquals("Not navigate to page", expectedMessage5, actualMessage5);

        //1.14 Enter Email address
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String emailAddress = "ram"+timestamp.getTime()+"@domain.com";

        sendTextToElement(By.xpath("//input[@id='email']"), emailAddress);//ram@gmail.com

        //1.15 Click on “Continue” Button
        clickOnElement(By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']"));

        //1.16 Verify the text “Secure Checkout”
        String actualMessage6 = getTextFromElement(By.xpath("//h1[contains(text(),'Secure Checkout')]"));//
        String expectedMessage6 = "Secure Checkout";
        Assert.assertEquals("Not navigate to page", expectedMessage6, actualMessage6);

        //1.17 Fill all the mandatory fields
        sendTextToElement(By.xpath("//input[@name='shippingAddress[firstname]']"), "Sita");//sending first name
        sendTextToElement(By.xpath("//input[@name='shippingAddress[lastname]']"), "Ram");//sending last name
        sendTextToElement(By.xpath("//input[@name='shippingAddress[street]']"), "10, B");//sending address

        clearElement1(By.xpath("//input[@name='shippingAddress[city]']"));
        sendTextToElement(By.xpath("//input[@name='shippingAddress[city]']"), "Derby");//sending city name

        selectByVisibleTextFromDropDown(By.xpath("//select[@name='shippingAddress[country_code]']"), "France");//selecting country

        sendTextToElement(By.xpath("//input[@name='shippingAddress[custom_state]']"), "Borough");//sending state name

        clearElement1(By.xpath("//input[@name='shippingAddress[zipcode]']"));
        sendTextToElement(By.xpath("//input[@name='shippingAddress[zipcode]']"), "100-200");//sending zip code

        //sendTextToElement(By.xpath("//input[@name='email']"), "");



        //1.18 Check the check box “Create an account for later use”
        clickOnElement(By.xpath("//input[@id='create_profile']"));

        //1.19 Enter the password
        sendTextToElement(By.xpath("//input[@name='password']"), "PassPassword0123");
        Thread.sleep(800);

        //1.20 Select the Delivery Method to “Local Shipping”
        clickOnElement(By.xpath("//input[@id='method128']"));

        //1.21 Select Payment Method “COD”
        clickOnElement(By.xpath("//input[@id='pmethod6']"));
        Thread.sleep(800);

        //1.22 Verify the total $309.73
        String actualMessage9_1 = getTextFromElement(By.xpath("//div[@class='total clearfix']//span/span[@class='surcharge-cell']/span[@class ='part-prefix']"));
        String actualMessage9_2 = getTextFromElement(By.xpath("//div[@class='total clearfix']//span/span[@class='surcharge-cell']/span[@class ='part-integer']"));
        String actualMessage9_3 = getTextFromElement(By.xpath("//div[@class='total clearfix']//span/span[@class='surcharge-cell']/span[@class ='part-decimalDelimiter']"));
        String actualMessage9_4 = getTextFromElement(By.xpath("//div[@class='total clearfix']//span/span[@class='surcharge-cell']/span[@class ='part-decimal']"));
        String actualMessage7 = actualMessage9_1 + actualMessage9_2 + actualMessage9_3 + actualMessage9_4;
        String expectedMessage7 = "$309.73";
        Assert.assertEquals("Not navigate to page", expectedMessage7, actualMessage7);

        //1.23 Click on “Place Order” Button
        clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
        Thread.sleep(1000);

        //1.24 Verify the text “Thank you for your order”
        String actualMessage8 = getTextFromElement(By.xpath("//h1[text()='Thank you for your order']"));
        String expectedMessage8 = "Thank you for your order";
        Assert.assertEquals("Not navigate to page", expectedMessage8, actualMessage8);

    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        //1.1 Mouse hover on the “Hot deals” link
        mouseHover(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));

        //1.2 Mouse hover on the “Bestseller”  link and click
       // Thread.sleep(300);
        mouseHover(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));
        Thread.sleep(300);
        clickOnElement(By.xpath("//li[@class='leaf has-sub']//span[text()='Bestsellers']"));

        //1.3 Verify the text “Bestsellers”
         Thread.sleep(400);
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Bestsellers']"));
        String expectedMessage = "Bestsellers";
        Assert.assertEquals("Not navigate to page", expectedMessage, actualMessage);

        //1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHover(By.xpath("//span[text()='Sort by:']"));
        Thread.sleep(400);
        clickOnElement(By.xpath("//li[@class='list-type-grid ']//a[@data-sort-by='translations.name' and @data-sort-order='asc']"));

        //1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
        mouseHover(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]/div[1]/div[1]/a[1]"));
        Thread.sleep(400);
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));

        //1.6 Verify the message “Product has been added to your cart” display in  green bar
        Thread.sleep(400);
        String actualMessage1 = getTextFromElement(By.xpath("//li[text()='Product has been added to your cart']"));
        String expectedMessage1 = "Product has been added to your cart";
        Assert.assertEquals("Not navigate to page", expectedMessage1, actualMessage1);

        //1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));

        //1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));

        //1.9 Verify the text “Your shopping cart - 1 item”
        String actualMessage2 = getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 1 item']"));
        String expectedMessage2 = "Your shopping cart - 1 item";
        Assert.assertEquals("Not navigate to page", expectedMessage2, actualMessage2);

        //1.10 Click on “Empty your cart” link
        clickOnElement(By.xpath("//a[@class='clear-bag']"));

        //1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        String actualMessage3 = alertText();
        String expectedMessage3 = "Are you sure you want to clear your cart?";
        Assert.assertEquals("Not navigate to page", expectedMessage3, actualMessage3);

        //1.12 Click “Ok” on alert
        alertHandle();
        Thread.sleep(1000);

        //1.13 Verify the message “Item(s) deleted from your cart”
        String actualMessage4 = getTextFromElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        String expectedMessage4 = "Item(s) deleted from your cart";
        Assert.assertEquals("Not navigate to page", expectedMessage4, actualMessage4);

        //1.15 Verify the text “Your cart is empty”
        Thread.sleep(800);
        String actualMessage5 = getTextFromElement(By.xpath("//h1[text()='Your cart is empty']"));
        String expectedMessage5 = "Your cart is empty";
        Assert.assertEquals("Not navigate to page", expectedMessage5, actualMessage5);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
