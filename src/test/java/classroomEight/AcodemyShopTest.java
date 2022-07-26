package classroomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.acodemyShopATP3.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AcodemyShopTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setupBrowser() throws MalformedURLException {
        //šeit 2 rindiņās mēs startējam jauno remote driver
        ChromeOptions chromeOptions = new ChromeOptions();
        //var arī pēc tieši tāpat palaist no cita browser

//        driver = new WebDriver(
//                new URL("https://oauth-laine.dreismane-f9aaf:*****a6ba@ondemand.eu-central-1.saucelabs.com:443/wd/hub")
//        );
        driver = new RemoteWebDriver(new URL("https://oauth-laine.dreismane-f9aaf:*****a6ba@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), chromeOptions);

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test public void tesSearch() throws InterruptedException {
        driver.get("http://shop.acodemy.lv");
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Beanie");
        mainPage.searchProduct("t-shirt");
        Assert.assertEquals(mainPage.getSearchResultText(),"Showing all 3 results");
        mainPage.searchProduct("Hoodie");
        Assert.assertEquals(mainPage.getSearchResults().size(),3);
        Thread.sleep(5000);

        List<WebElement> results =  mainPage.getSearchResults();
        for (int i = 0; i < results.size(); i++) {
            System.out.println("##########################");
            System.out.println(results.get(i).findElement(By.cssSelector("span.woocommerce-Price-amount")).getText());
        }
    }

    @Test
    public void testEmptySearch()  {
        driver.get("http://shop.acodemy.lv/");
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("JurisJuris");
        Assert.assertEquals(mainPage.getNoSearchResultText(),MainPage.NO_SEARCH_RESULTS);
    }

    @Test
    public void testSwitchTabs() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());
        driver.findElement(By.cssSelector("div[class='site-info'] a")).click();
        System.out.println(driver.getTitle());
        System.out.println("Tabu skaits:" + driver.getWindowHandles().size());

        //komanda, kas pasaka pārslēgties uz 2. tab (sākas skaits ar 0)
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(5000);
    }

    //paskrullē lapu uz leju ar JavaScript
    @Test
    public void testJavascript() throws InterruptedException {
        driver.get("http://shop.acodemy.lv/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,600)");
        Thread.sleep(1000);

        //izsauc alert
        ((JavascriptExecutor) driver).executeScript("alert('JURIS JURIS')");
        Thread.sleep(1000);

        //aizskurlē līdz vajadzīgajam attēlam
        WebElement element = driver.findElement(By.cssSelector("li.post-18"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(4000);
    }

    @Test
    public void mouseActionsTests() throws InterruptedException {
        driver.findElement(By.id("accept-choices")).click();
        driver.findElement(By.linkText("Link 1")).click();
        Actions actions = new Actions(driver);
        WebElement hoverMeButton = driver.findElement(By.xpath("//button[text()='Hover Me']"));
        actions.moveToElement(hoverMeButton).perform();
        Thread.sleep(4000);
        driver.findElement(By.linkText("Link 1")).click();
        Thread.sleep(4000);

    }

    @Test
    public void keyBoardActionTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/actions_api/keyboard/");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("k").perform();
        Thread.sleep(5000);
    }


    @AfterMethod
    public void tearDownBrowser(){
        driver.quit();
    }


}

