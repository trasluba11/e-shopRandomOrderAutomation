package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenChoice {
    WebDriver driver;

    public WomenChoice(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a")
    WebElement women;
    public void clickWomenMenu (){
        women.click();
    }
}
