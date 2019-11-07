package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProceedToCheckout {
    WebDriver driver;

    public ProceedToCheckout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceed;

    public WebElement getProceed(){
        return proceed;
    }
    public void proceedClick() {
        proceed.click();
    }
    @FindBy(xpath = "//a[@title='Proceed to checkout'][@style='']")
    WebElement proceed2;

    public WebElement getProceed2() {
        return proceed2;
    }

    public void proceed2Click() {
       proceed2.click();
    }
}
