//package classroomSeven;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pageObjects.Footer;
//import pageObjects.LoginPage;
//import pageObjects.ProductPage;
//
//import java.time.Duration;
//import java.util.List;
//
//public class SwagLabsTest {
//    WebDriver driver;
//    public final String SWAGLABS_URL = "https://www.saucedemo.com/";
//    private final String LOCAL_URL = "file://C:\\LaineDreismaneTestAutomation_2\\elements.html";
//
//
//
//    @BeforeMethod (alwaysRun = true)
//    public void openBrowser(){
//        //atveram browseri
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//
//    }
//
//    @Test
//    public void testErrorMessage() throws InterruptedException {
//        //veiksim visas darbības, lai notestētu error message
//        driver.get(SWAGLABS_URL);
//        WebElement userNameInputField =  driver.findElement(By.id("user-name"));
//        userNameInputField.sendKeys("Laine_TEST");
//        WebElement userPasswordInputField =  driver.findElement(By.id("password"));
//        userPasswordInputField.sendKeys("Laine_TEST");
//
//
//        //atradisim Lopin pogu
//        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
//        loginButton.click();
//
//        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        String actualErrorMessage = errorMessage.getText();
//        String expectedErrorMessage = "Epic sadface: Password is required";
//
//        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
//
//
//        Thread.sleep (5000); // šo reāli neliek testos, bet tas palīdz redzēt, lai nav viss zibenīgi ātri
//    }
//
//
//    @Test
//    public void testErrorMessageWithPOM(){
//        driver.get(SWAGLABS_URL);
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("Juris","");
//        loginPage.getLoginButton().click();
//        String actualText = loginPage.getErrorMessageTextField().getText();
//        String expectedErrorMessage = "Epic sadface: Password is required";
//        Assert.assertEquals(actualText,expectedErrorMessage);
//
//    }
//
//    @Test
//    public void testSuccessfulLogin(){
//        driver.get(SWAGLABS_URL);
//        WebElement userNameInputField =  driver.findElement(By.id("user-name"));
////        WebElement userNameInputField =  driver.findElement(By.cssSelector("input[id='user-name']"));
//        userNameInputField.sendKeys("standard_user");
//
//        //tagad uzrakstam paroles lauku un ievadam tur vertibu
//        WebElement passwordInputField = driver.findElement(By.name("password"));
//        passwordInputField.sendKeys("secret_sauce");
//
//        //atradisim Login pogu
//
//        WebElement loginButton = driver.findElement(By.cssSelector("input#login-button"));
//        loginButton.click();
//
//        WebElement titleText = driver.findElement(By.cssSelector("span[class='title']"));
//        Assert.assertEquals(titleText.getText(),"PRODUCTS"); //apliecina, ka ir ielogots iekšā
//
//        WebElement linkedInLink = driver.findElement(By.linkText("LinkedIn"));
//        // varēja arī šādi to pašu --> WebElement linkedInLink = driver.findElement(By.cssSelector("li[class='social_linkedin'] > a"));
//        //linkedInLink.click();
//
//        WebElement addFleeceJacketToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']"));
//        addFleeceJacketToCartButton.click();
//
//
//        WebElement addFleeceJackeToChartButton;
//
//
//        @Test
//        public void testSuccessLogin(){
//            driver.get(SWAGLABS_URL);
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.login("standard_user","secret_sauce");
//            ProductPage productsPage = new ProductPage(driver);
//            Assert.assertEquals(productsPage.getPageTitle().getText(),"PRODUCTS");
//        }
//
//
//        @Test
//        public void testFooterCopyRightText() {
//            driver.get(SWAGLABS_URL);
//            LoginPage loginPage = new LoginPage(driver);
//            loginPage.login("standard_user", "secret_sauce");
//            Footer footer = new Footer(driver);
//            String actualString = footer.getCopyRightTextField().getText();
//            String expectedString = "©️ 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
//            Assert.assertEquals(actualString, expectedString);
//        }
//
//
//
//
//
//    }
//
//@Test
//public void testSamplePage() throws InterruptedException {
//        driver.get(LOCAL_URL);
//    WebElement vards = driver.findElement(By.id("fNameID"));
//    vards.sendKeys("Laine");
//
//    WebElement uzvards = driver.findElement(By.id("lNameID"));
//    uzvards.sendKeys("Liepa");
//
//    WebElement informacija = driver.findElement(By.name("description"));
//    informacija.clear();
//    informacija.sendKeys("Šis ir info par mani");
//
//    WebElement studenCheckbox = driver.findElement(By.id("studentID"));
//    studenCheckbox.click();
//
//    WebElement radioButtonJava = driver.findElement(By.id("javaID"));
//    System.out.println(radioButtonJava.isSelected());
//    radioButtonJava.click();
//    System.out.println(radioButtonJava.isSelected());
//
//    Select milakaKrasaDropdown = new Select(driver.findElement(By.id("colorsID")));
//    milakaKrasaDropdown.selectByIndex(0);
//    milakaKrasaDropdown.selectByIndex(1);
//
//    List<WebElement> saraksts = milakaKrasaDropdown.getOptions();
//
//    for (int i = 0; i < saraksts.size(); i++) {
//        System.out.println(saraksts.get(i).getText());
//    }
//
//
//    Thread.sleep(5000);
//
//
//}
//
//    @AfterMethod(alwaysRun = true)
//    public void closeBrowser(){
//        //aizveram browseri
//        driver.close();
//    }
//}
