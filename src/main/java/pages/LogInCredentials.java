package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInCredentials {
    WebDriver driver;

    public LogInCredentials(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement password;

    public void setUserName() {
        email.clear();
        email.sendKeys("trasluba11@gmail.com");
    }

    public void setPassword() {
        password.clear();
        password.sendKeys("test111111");
    }

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement submitButton;

    public void clickSubmit() {
        submitButton.click();
    }
}
