package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

/**
 * @author alpinaro (Alper Çınaroğlu)
 * https://github.com/alpinaro
 */
public class BeymenPages {

    public BeymenPages() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Main Page
    @FindBy(xpath = "/html/body/header//input")
    public WebElement searchBox;

    // Search Results Page
    @FindBy(xpath = "//*[@class=\"o-productList__item\"]")
    public List<WebElement> productList;

    // Product Page
    @FindBy(xpath = "//a[@class=\"o-productDetail__brandLink\"]")
    public WebElement productBrandLink;

    @FindBy(xpath = "//span[@class=\"o-productDetail__description\"]")
    public WebElement productDescription;

    @FindBy(xpath = "//*[@class=\"m-price__new\"]")
    public WebElement productPrice;

    @FindBy(xpath = "//div[@class=\"m-productDescription__infoList\"]")
    public WebElement productInfoList;

    @FindBy(xpath = "//button[@id=\"addBasket\"]")
    public WebElement addBasket;

    @FindBy(xpath = "//span[@class=\"m-variation__item\"]")
    public List<WebElement> productSize;

    @FindBy(xpath = "//a[@href=\"/cart\"]")
    public WebElement cartLink;

    // Cart Page
    @FindBy(xpath = "//span[@class=\"m-productPrice__salePrice\"]")
    public WebElement salePrice;

    @FindBy(xpath = "//select[@id=\"quantitySelect0-key-0\"]")
    public WebElement selectQuantity;

    @FindBy(xpath = "//button[@id=\"removeCartItemBtn0-key-0\"]")
    public WebElement removeProduct;

    @FindBy(xpath = "//div[@id=\"emtyCart\"]")
    public WebElement emptyCart;
}