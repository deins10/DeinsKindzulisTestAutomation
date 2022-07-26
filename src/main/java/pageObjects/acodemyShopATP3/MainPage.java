package pageObjects.acodemyShopATP3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MainPage {

    public WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public static final String NO_SEARCH_RESULTS = "No products were found matching your selection.";

    private By searchInputField = By.id("woocommerce-product-search-field-0");
    private By resultCountLabel = By.cssSelector("header[class='woocommerce-products-header']+div[class='storefront-sorting'] p");
    private By searchResults = By.cssSelector("li[class*='product']");
    private By noResultsInfoText = By.cssSelector("p.woocommerce-info");

    public String getNoSearchResultText(){
        return driver.findElement(noResultsInfoText).getText();
    }

    public WebElement getSearchInputField(){
        return driver.findElement(searchInputField);
    }

    public List<WebElement> getSearchResults(){
        return driver.findElements(searchResults);
    }

    public String getSearchResultText(){
        return driver.findElement(resultCountLabel).getText();
    }

    //nodefinē search metodi, lai testā nav nepārskatāmi un padod tikai vērtības no testa
    public void searchProduct(String search){
        getSearchInputField().clear();
        getSearchInputField().sendKeys(search);
        Actions actions = new Actions (driver);
        actions.sendKeys(Keys.ENTER).perform();
    }



}
