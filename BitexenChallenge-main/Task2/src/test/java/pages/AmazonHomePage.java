package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class AmazonHomePage {


    public AmazonHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//span[@class='nav-action-inner'])[1]")
    public WebElement girisYapButton;



    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchTextbox;

    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public List<WebElement> productList;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement accountButton;

}
