package homepage;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {
        // 1.1 Click on the “Shipping” link
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Shipping']"));

        // 1.2 Verify the text “Shipping”
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Shipping']"));
        String expectedMessage = "Shipping";
        Assert.assertEquals("not navigate to shipping page", expectedMessage, actualMessage);
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        //2.1 Click on the “New!” link
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='New!']"));

        //2.2 Verify the text “New arrivals”
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='New arrivals']"));
        String expectedMessage = "New arrivals";
        Assert.assertEquals("not navigate to page", expectedMessage, actualMessage);

    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        //3.1 Click on the “Coming soon” link
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Coming soon']"));

        //3.2 Verify the text “Coming soon”
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Coming soon']"));
        String expectedMessage = "Coming soon";
        Assert.assertEquals("not navigate to page", expectedMessage, actualMessage);
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        //4.1 Click on the “Contact us” link
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Contact us']"));

        //4.2 Verify the text “Contact us''
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Contact us']"));
        String expectedMessage = "Contact us";
        Assert.assertEquals("not navigate to page", expectedMessage, actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
