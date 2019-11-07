package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Agreement {
    WebDriver driver;

    public Agreement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getAgree() {
        return agree;
    }

    public WebElement getProceed4() {
        return proceed4;
    }

    @FindBy(xpath = "//*[@id=\"cgv\"]")
    WebElement agree;
    @FindBy(xpath = "//button[@type='submit'][@name='processCarrier']")
    WebElement proceed4;

    public void agreementClick (){
        agree.click();
    }
    public void proceedToCheckout4(){
        proceed4.click();
    }
}
