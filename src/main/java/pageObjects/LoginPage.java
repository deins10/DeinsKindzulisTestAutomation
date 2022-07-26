package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userInputField = By.id("user-name"); //mINĪGOA TAisa kā private bet apaksā metodes public ar kurām tad arī piekļūstam klāt mainīgajiem, šis ir laba prakse
    private By passwordInputField = By.id("password");
    private By loginButton = By.cssSelector("input#login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public void login(String username,String password){
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }


    public WebElement getErrorMessageTextField(){
        return driver.findElement(errorMessage);
    }

    public WebElement getUsernameField(){
        return driver.findElement(userInputField);
    }
    public WebElement getPasswordField(){
        return driver.findElement(passwordInputField);
    }
    public WebElement getLoginButton(){
        return driver.findElement(loginButton);
    }
    public WebElement getErrorText() {
        return driver.findElement(errorText);
    }
    private By errorText = By.cssSelector("h3[data-test='error']");


}
