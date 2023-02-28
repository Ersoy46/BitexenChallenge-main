package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utils.ConfigReader;
import utils.Driver;
import utils.Methods;

public class Case02StepDefinitions {
    AmazonHomePage amazonHomePage = new AmazonHomePage();
    AmazonLoginPage amazonLoginPage = new AmazonLoginPage();
    AmazonProductDetailPage amazonProductDetailPage = new AmazonProductDetailPage();
    AmazonCardPage amazonCardPage = new AmazonCardPage();
    public String productPrice ="";

    public String selectedProductTitle = "";

    @Given("User visits {string}")
    public void user_visits(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }
    @When("Login with a registered user")
    public void login_with_a_registered_user() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(amazonHomePage.accountButton).perform();

        amazonHomePage.girisYapButton.click();
        amazonLoginPage.emailTextbox.sendKeys(ConfigReader.getProperty("ValidEmail"));
        amazonLoginPage.continueButton.click();
        amazonLoginPage.passwordTextbox.sendKeys(ConfigReader.getProperty("ValidPassword"));
        amazonLoginPage.signInButton.click();


    }
    @When("User searches {string}")
    public void user_searches(String productName) {
        amazonHomePage.searchTextbox.sendKeys(productName+Keys.ENTER);
    }
    @When("Select any product and go to the detail page of the product")
    public void select_any_product_and_go_to_the_detail_page_of_the_product() {
        WebElement product = Methods.selectRandomProduct(amazonHomePage.productList);
        selectedProductTitle  = product.getText();
        product.click();

    }
    @When("It is checked that the selected product is the same as the detailed product")
    public void it_is_checked_that_the_selected_product_is_the_same_as_the_detailed_product() {
        Assert.assertEquals(selectedProductTitle,amazonProductDetailPage.productTitle.getText());
    }
    @When("It is added to the add to cart button in the product detail")
    public void it_is_added_to_the_add_to_cart_button_in_the_product_detail() {
        productPrice = amazonProductDetailPage.productPriceElement.getText();
        amazonProductDetailPage.addToCardButton.click();
    }
    @Then("The basket is checked, it is checked that the price of the added product is the same as the added product")
    public void the_basket_is_checked_it_is_checked_that_the_price_of_the_added_product_is_the_same_as_the_added_product() {
        String cardPrice = amazonCardPage.totalCardPrice.getText();
        Assert.assertEquals(productPrice,cardPrice);
    }

    @And("User closes the browser")
    public void userClosesTheBrowser() {
        Driver.closeDriver();
    }
}
