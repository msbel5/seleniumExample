package org.sExample.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage {

    @FindBy(how = How.CSS, using = "#priceNew")
    public WebElement productPrice;

    @FindBy(how = How.CLASS_NAME, using = "o-productDetail__description")
    public WebElement productName;
    @FindBy(how = How.CLASS_NAME, using = "m-variation__item")
    List<WebElement> sizes;
    @FindBy(how = How.CSS, using = "#addBasket")
    private WebElement addToCartButton;
    @FindBy(how = How.CLASS_NAME, using = "icon icon-cart")
    private WebElement goToCartButton;


    public ProductPage() {
        super();
    }

    public String getProductName() {
        productName = wait.until(ExpectedConditions.visibilityOf(productName));
        return productName.getText();
    }

    public String getProductPrice() {
        productPrice = wait.until(ExpectedConditions.visibilityOf(productPrice));
        return productPrice.getText();
    }

    public void selectRandomSize() {
        Random random = new Random();
        int randomSizeIndex = random.nextInt(sizes.size());
        WebElement randomSize = sizes.get(randomSizeIndex);
        wait.until(ExpectedConditions.elementToBeClickable(randomSize)).click();
    }

    public void addToCart() {
        addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        selectRandomSize();
        addToCartButton.click();
    }

    public void goToCart() {
        goToCartButton = wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
        goToCartButton.click();
    }
}
