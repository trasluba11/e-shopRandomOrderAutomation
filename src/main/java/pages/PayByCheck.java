package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayByCheck {
    WebDriver driver;

    public PayByCheck(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@id='total_price']")
    WebElement amount;

    public String amountToPay(){
        String amountToPay = amount.getText();
        return amountToPay;
    }
    @FindBy(xpath = "//a[@title='Pay by check.']")
    WebElement payByCheckButton;

    public void ClickPayByCheck(){
        payByCheckButton.click();
    }
}
