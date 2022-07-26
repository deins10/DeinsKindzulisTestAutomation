package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebPage {
    WebDriver webDriver;

    @BeforeMethod
    public void openBrowser(){
        webDriver = new ChromeDriver();
    }
    @Test
    public void validateHomepageTitle(){
        webDriver.navigate().to ("https://en.wikipedia.org/wiki/List_of_ISO_3166_country_codes");
        webDriver.manage().window().maximize();
        String expectedTitle = "List of ISO 3166 country codes - Wikipedia";
        String actualTitle  = webDriver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void verifyHomepageTitleTwo(){
        webDriver.navigate().to ("https://www.royalmail.com");
        webDriver.manage().window().maximize();
        String expectedTitle = "Royal Mail | Royal Mail Group Ltd";
        String actualTitle  = webDriver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
