package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.CommonFunctions.*;
import static utils.Constants.*;

public class SearchPage {
    public SearchPage enterProduct(String name) {
        typeText(name, findElement(8, 0, 1));
        return new SearchPage();
    }

    public SearchPage verifyInputValueEntered(String product) {
        //assertValue(product, searchInput);
        assertProduct(product, findElement(8, 0, 1), "value");
        return new SearchPage();
    }

    public SearchPage Search() {
        click(findElement(9, 0, 1));
        return new SearchPage();
    }

    public SearchPage scrollProduct() {
        scrollDown(SCROLL_HEIGHT);
        return new SearchPage();
    }

    public SearchPage verifyProductDisplayedOrNot(String productName) {
        //asssertTitle(productName, product);
        assertProduct(productName, findElement(10, 0, 1), "title");
        return new SearchPage();
    }

    public SearchPage verifyNoProductMessageDisplayed(String message) {

        //asssertText(message, HondaProductMesaage);
        assertProduct(message, findElement(11, 0, 1), "productText");
        return new SearchPage();
    }


}
