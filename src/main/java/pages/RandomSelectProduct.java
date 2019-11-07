package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class RandomSelectProduct {
    WebDriver driver;
    Random random = new Random();

    public RandomSelectProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindAll(@FindBy(xpath = "//ul[@class='product_list grid row']/li"))
    List<WebElement> products;
    public void selectRandomProduct () throws InterruptedException {
        int num = random.nextInt(products.size());
        WebElement randomProduct = products.get(num);
        Thread.sleep(3000);
        randomProduct.findElement(By.tagName("img")).click();

        // randomProduct.click();
    }
    @FindBy(xpath = "//button[@type='submit'][@name='Submit']")
    WebElement addToCart;

    public void addToCart (){
        addToCart.click();
    }
}
