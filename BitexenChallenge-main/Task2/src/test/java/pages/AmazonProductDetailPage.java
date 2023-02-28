package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AmazonProductDetailPage {

    public AmazonProductDetailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement productTitle;



    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToCardButton;

    @FindBy(xpath = "//*[@id='corePrice_feature_div']/div/span/span[2]")
    public WebElement productPriceElement;



}
