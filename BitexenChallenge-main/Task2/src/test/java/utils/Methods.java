package utils;

import org.openqa.selenium.WebElement;
import pages.AmazonHomePage;

import java.util.List;
import java.util.Random;

public class Methods {
    AmazonHomePage amazonHomePage = new AmazonHomePage();

    public static WebElement selectRandomProduct(List<WebElement> allProduct){
        int randomNumber = new Random().nextInt(allProduct.size());
        return allProduct.get(randomNumber);
    }

}
