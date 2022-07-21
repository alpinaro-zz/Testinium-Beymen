package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.BeymenPages;
import utilities.Auxiliary;
import utilities.Base;
import utilities.Driver;
import utilities.Excel;

import java.util.Random;

public class Beymen extends Base {

    BeymenPages beymen = new BeymenPages();
    Actions actions = new Actions(Driver.getDriver());

    String price = "";

    @Test
    @Order(1)
    void isTrueURL() {

        String expectedURL = "https://www.beymen.com";
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assertions.assertTrue(actualURL.equals(expectedURL) || actualURL.equals(expectedURL + "/"));
    }

    @Test
    @Order(2)
    void search() {

        String searchdata;
        Excel.open("searchdata.xlsx");
        searchdata = Excel.workbook.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
        beymen.searchBox.sendKeys(searchdata);
        Auxiliary.wait(1);
        actions.keyDown(Keys.LEFT_CONTROL).sendKeys("A").keyUp(Keys.LEFT_CONTROL).sendKeys(Keys.BACK_SPACE).perform();
        Auxiliary.wait(1);
        searchdata = Excel.workbook.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
        beymen.searchBox.sendKeys(searchdata + Keys.ENTER);
        Excel.close();
    }

    @Test
    @Order(3)
    void selectProduct() {

        int productCount = beymen.productList.size();
        Random random = new Random();

        do {
            int id = random.nextInt(productCount);
            beymen.productList.get(id).click();
            if (!(beymen.productSize.size() > 0)) Driver.getDriver().navigate().back();
        } while (!(beymen.productSize.size() > 0));
        // If there are not enough products in any size, we cannot increase the amount in the basket.
        // So if there is no productSize element, we go back and select a product again.
    }

    @Test
    @Order(4)
    void writeProduct() {

        String productData =
                            beymen.productBrandLink.getText() + "\n" +
                            beymen.productDescription.getText() + "\n" +
                            beymen.productPrice.getText() + "\n\n" +
                            beymen.productInfoList.getText();

        Auxiliary.writeOutputTXT("product.txt", productData);
    }

    @Test
    @Order(5)
    void selectSize() {

        beymen.productSize.get(0).click();
    }

    @Test
    @Order(6)
    void addToCart() {

        beymen.addBasket.click();
        price = beymen.productPrice.getText();
    }

    @Test
    @Order(7)
    void checkPriceInCart() {

        Auxiliary.wait(5);
        beymen.cartLink.click();
        Assertions.assertTrue(beymen.salePrice.getText().equals(price));
    }

    @Test
    @Order(8)
    void increaseQuantity() {

        Select select = new Select(beymen.selectQuantity);
        select.selectByValue("2");
        Auxiliary.wait(1);
        String expectedQuantity = "2 adet";
        String actualQuantity = select.getFirstSelectedOption().getText().trim();

        Assertions.assertTrue(actualQuantity.equals(expectedQuantity));
    }

    @Test
    @Order(9)
    void removeProductFromCart() {

        beymen.removeProduct.click();

        Assertions.assertTrue(beymen.emptyCart.isDisplayed());
    }
}