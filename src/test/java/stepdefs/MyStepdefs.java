package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;

public class MyStepdefs {

    public String baseURL = "http://automationpractice.com/";
    WebDriver driver;
    WebDriverWait wait;
    SignIn signIn;
    LogInCredentials login;
    WomenChoice womenChoice;
    RandomSelectProduct randomProduct;
    ProceedToCheckout proceedToCheckout;
    CheckAddress checkAddress;
    Agreement agreement;
    PayByCheck payByCheck;
    ConfirmMyOrder confirmMyOrder;
    SubmitionVerification submitionVerification;
    BackToOrder backToOrder;

    @Before
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        signIn = new SignIn(driver);
        login = new LogInCredentials(driver);
        womenChoice = new WomenChoice(driver);
        randomProduct = new RandomSelectProduct(driver);
        proceedToCheckout = new ProceedToCheckout(driver);
        checkAddress = new CheckAddress(driver);
        agreement = new Agreement(driver);
        payByCheck = new PayByCheck(driver);
        confirmMyOrder = new ConfirmMyOrder(driver);
        submitionVerification = new SubmitionVerification(driver);
        backToOrder = new BackToOrder(driver);
    }

    @After
    public void driverClose() {
         driver.quit();
    }


    @Given("^user navigates to the web page$")
    public void userNavigatesToTheWebPage() {
        driver.get(baseURL);
        Assert.assertEquals(driver.getTitle(), "My Store", "Assertion failed!");
        System.out.println("The Browser is opened! Title is correct!");
    }

    @When("^user SignIn into account$")
    public void userSignInIntoAccount() {
        signIn.clickSignIn();
        Assert.assertEquals(driver.getTitle(), "Login - My Store", "Assertion failed!");
        System.out.println("SignIn succesfull. Login-My Store page is loaded.");
        login.setUserName();
        login.setPassword();
        login.clickSubmit();
        Assert.assertEquals(driver.getTitle(), "My account - My Store", "Assertion failed!");
        System.out.println("Successfully Logged in");

    }

    @And("^select women from the top menu$")
    public void selectWomenFromTheTopMenu() {
        womenChoice.clickWomenMenu();
        Assert.assertEquals(driver.getTitle(), "Women - My Store", "Assertion failed!");
        System.out.println("Women - My Store is opened.");
    }

    @And("^click on a random item$")
    public void clickOnARandomItem() throws InterruptedException {
        randomProduct.selectRandomProduct();

        int numFrames = driver.findElements(By.tagName("iframe")).size();
        if (numFrames != 0) {
            driver.switchTo().frame(0);
            Thread.sleep(3000);
        }
    }

    @And("^add this item to the cart$")
    public void addThisItemToTheCart() throws InterruptedException {
        randomProduct.addToCart();
        int numFrames = driver.findElements(By.tagName("iframe")).size();
        if (numFrames != 0) {
            driver.switchTo().parentFrame();
            Thread.sleep(3000);
        }
    }

    @And("^click proceed to check out$")
    public void clickProceedToCheckOut() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout.getProceed()));
        proceedToCheckout.proceedClick();

    }

    @And("^click proceed to check out second$")
    public void clickProceedToCheckOutNd() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout.getProceed2()));
        proceedToCheckout.proceed2Click();
        Assert.assertEquals(driver.getTitle(), "Order - My Store", "Assertion failed!");
        System.out.println("Proceed to Checkout successful. Next step - Check address.");
    }

    @And("^compare delivery and billing addresses$")
    public void compareDeliveryAndBillingAddresses() {
        Assert.assertEquals(checkAddress.strDelText(), checkAddress.strBillText(), "Assertion failed!");
        Assert.assertEquals(checkAddress.cityDelText(), checkAddress.cityBillText(), "Assertion failed!");
        Assert.assertEquals(checkAddress.countryDelText(), checkAddress.countryBillText(), "Assertion failed!");
        System.out.println("Delivery and Billing address are mached!");
    }

    @And("^click proceed to check out third$")
    public void clickProceedToCheckOutRd() {
        checkAddress.clickProceed();

    }

    @And("^click agreement checkbox$")
    public void clickAgrementCheckbox() throws InterruptedException {

        agreement.agreementClick();

    }

    @And("^click proceed to check out forth$")
    public void clickProceedToCheckOutTh() {
        wait.until(ExpectedConditions.elementToBeClickable(agreement.getProceed4()));
        agreement.proceedToCheckout4();
    }

    String amount;

    @And("^choose pay by check method$")
    public void choosePayByCheckMethod() {
        amount = payByCheck.amountToPay();
        payByCheck.ClickPayByCheck();
    }

    @And("^click I confirm my order button$")
    public void clickIConfirmMyOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmMyOrder.getConfirmOrder()));
        confirmMyOrder.confirmOrderClick();
    }

    @Then("^oder successfully submitted$")
    public void oderSuccessfullySubmitted() {
        wait.until(ExpectedConditions.visibilityOf(submitionVerification.getSuccessfullSubmit()));
        Assert.assertEquals(submitionVerification.submitVerify(), "Your order on My Store is complete.", "Assertion failed!");
        System.out.println("Message: 'Your order on My Store is complete.' is appeared");
    }
}
