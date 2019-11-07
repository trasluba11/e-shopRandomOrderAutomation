package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitionVerification {
    WebDriver driver;

    public SubmitionVerification(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement successfullSubmit;
    public WebElement getSuccessfullSubmit() {
        return successfullSubmit;
    }

    public String submitVerify(){
        String submitMessage = successfullSubmit.getText();
        return submitMessage;
    }
}
