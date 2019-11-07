package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BackToOrder {
    WebDriver driver;

    public BackToOrder(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@title='Back to orders']")
    WebElement backToOrder;
    @FindBy(xpath = "//table[@id='order-list']/tbody/tr[1]/td[1]/a[@class='color-myaccount']")
    WebElement orderDetails;
    @FindBy(xpath = "//*[@id=\"order-detail-content\"]/table/tfoot/tr[4]/td[2]/span")
    WebElement price;
    @FindBy (xpath = "//a[@class='logout'][@title='Log me out']")
    WebElement signOut;

    public void clickBackToOrder (){
        backToOrder.click();
    }
    public void clickOrderDetails (){
        orderDetails.click();
    }
    public String getTotalPrice (){
        String totalPrice = price.getText();
        return totalPrice;
    }
    public void clickSignOut(){
        signOut.click();
    }

}
