package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmMyOrder {
    WebDriver driver;

    public ConfirmMyOrder(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//p/button[@type='submit'][@class='button btn btn-default button-medium']" + "/span[contains(text(),'I confirm my order')]")
    WebElement confirmOrder;
    public WebElement getConfirmOrder() {
        return confirmOrder;
    }
    public void confirmOrderClick(){
        confirmOrder.click();
    }
}
