package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckAddress {
    WebDriver driver;

    public CheckAddress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//ul[@id='address_delivery']/li[3]")
    WebElement streetDelivery;
    @FindBy(xpath = "//ul[@id='address_delivery']/li[4]")
    WebElement cityDelivery;
    @FindBy(xpath = "//ul[@id='address_delivery']/li[5]")
    WebElement countryDelivery;
    @FindBy(xpath = "//ul[@id='address_invoice']/li[3]")
    WebElement streetBilling;
    @FindBy(xpath = "//ul[@id='address_invoice']/li[4]")
    WebElement cityBilling;
    @FindBy(xpath = "//ul[@id='address_invoice']/li[5]")
    WebElement countryBilling;

    public  String strDelText (){
        String strDel = streetDelivery.getText();
        return strDel;
    }
    public  String cityDelText (){
        String cityDel = cityDelivery.getText();
        return cityDel;
    }
    public String countryDelText (){
        String countryDel = countryDelivery.getText();
        return countryDel;
    }
    public String strBillText (){
        String strBill = streetBilling.getText();
        return strBill;
    }
    public String cityBillText (){
        String cityBill = cityBilling.getText();
        return cityBill;
    }
    public String countryBillText (){
        String countryBill = countryBilling.getText();
        return countryBill;
    }
    @FindBy(xpath = "//p/button[@type='submit'][@name='processAddress']")
    WebElement proceed3;

    public void clickProceed(){
        proceed3.click();
    }

}
