package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AmazonCardPage {

    public AmazonCardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='a-size-base a-color-base sc-price sc-white-space-nowrap sw-subtotal-amount a-text-bold']")
    public WebElement totalCardPrice;
}
