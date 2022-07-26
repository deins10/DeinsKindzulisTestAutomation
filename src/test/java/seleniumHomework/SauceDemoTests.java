//Izveidojiet jaunu testa klasi ‘sauceDemoTests’ ar @BeforeMethod, @AfterMethod un vairākām @Test metodēm, kas notestēs sekojošos scenārijus

package seleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

public class SauceDemoTests {
    WebDriver driver;
    public final String SWAGLABS_URL = "https://www.saucedemo.com/";
    private final String LOCAL_URL = "file://C:\\LaineDreismaneTestAutomation_2\\elements.html";

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testSuccessfulLogin() throws InterruptedException {
        driver.get(SWAGLABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
//        WebElement userNameInputField =  driver.findElement(By.cssSelector("input[id='user-name']"));
        userNameInputField.sendKeys("standard_user");

        //tagad uzrakstam paroles lauku un ievadam tur vertibu
        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys("secret_sauce");

        //atradisim Login pogu

        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement titleText = driver.findElement(By.cssSelector("span[class='title']"));
        Assert.assertEquals(titleText.getText(), "PRODUCTS"); //apliecina, ka ir ielogots iekšā
        Thread.sleep(3000);


        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
        inventoryPage.addToCart();
        inventoryPage.openCart();
        Thread.sleep(3000);

        CartPage cartPage = new CartPage(driver);
        //Pārbaudīt vai produkts ir ievietots grozā
        Assert.assertEquals(cartPage.getItemName().getText(), "Sauce Labs Backpack");
        cartPage.getCheckoutButton().click();
        Thread.sleep(3000);

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.insertData("Laine", "Dreismane", "LV3018");
        checkoutPage.getContinueButton().click();
        Thread.sleep(3000);

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Assert.assertEquals(checkoutOverviewPage.getOverviewTitle().getText(),"CHECKOUT: OVERVIEW");
        Assert.assertEquals(checkoutOverviewPage.getInventoryItemName().getText(),"Sauce Labs Backpack");
        checkoutOverviewPage.getFinishButton().click();
        Thread.sleep(3000);

        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        Assert.assertEquals(checkoutSuccessPage.getPageCompleteTitle().getText(),"CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkoutSuccessPage.getThankYouText().getText(),"THANK YOU FOR YOUR ORDER");
        checkoutSuccessPage.getBackHomeButton().click();
        Thread.sleep(3000);
    }

    @Test
    public void testTwo() throws InterruptedException {
        driver.get(SWAGLABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
//        WebElement userNameInputField =  driver.findElement(By.cssSelector("input[id='user-name']"));
        userNameInputField.sendKeys("standard_user");

            //tagad uzrakstam paroles lauku un ievadam tur vertibu
        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys("secret_sauce");

            //atradisim Login pogu
        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
        loginButton.click();

        WebElement titleText = driver.findElement(By.cssSelector("span[class='title']"));
        Assert.assertEquals(titleText.getText(), "PRODUCTS"); //apliecina, ka ir ielogots iekšā
        Thread.sleep(3000);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getCheckoutButton().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.insertData("","Dreismane","LV3018");
        Thread.sleep(3000);
        checkoutPage.getContinueButton().click();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getErrorFirstName().getText(), "Error: First Name is required");
        Thread.sleep(3000);

        //Kāpēc clear nestrādā?
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.clear();
        Thread.sleep(3000);
        checkoutPage.insertData("Laine","","LV3018");
        Thread.sleep(3000);
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorLastName().getText(),"Error: Last Name is required");

        WebElement zipCode = driver.findElement(By.id("first-name"));
        zipCode.clear();
        Thread.sleep(3000);
        checkoutPage.insertData("","","");
        checkoutPage.getContinueButton().click();
        Assert.assertEquals(checkoutPage.getErrorZipPostalCode().getText(),"Error: Postal Code is required");
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        //aizveram browseri
        driver.close();
        }
}
