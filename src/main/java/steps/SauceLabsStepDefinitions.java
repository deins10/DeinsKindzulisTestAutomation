package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjectsHomework.InventoryPage;

import java.time.Duration;

public class SauceLabsStepDefinitions {

    WebDriver driver;
    LoginPage loginPage;

    @Before("@parluks")
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After("@parluks")
    public void tearDown(){
        driver.close();
    }


    @Given("user is navigated to {string}")
    public void user_is_navigated_to(String url) {

        driver.get(url);
    }


    @Then("user sees page title {string}")
    public void user_sees_page_title(String pageTitle) {
        Assert.assertEquals(driver.getTitle(), pageTitle);
    }


    @When("user enters username {string} and {string}")
    public void user_enters_username_and(String username, String password) {
        loginPage.getUsernameField().sendKeys(username);
        loginPage.getPasswordField().sendKeys(password);
    }

    @And("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.getLoginButton().click();
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
    }
    @Then("user sees error message {string}")
    public void userSeesErrorMessageErrorMessage(String errorMessage) {
        Assert.assertEquals(loginPage.getErrorText().getText(), errorMessage);
    }


}
