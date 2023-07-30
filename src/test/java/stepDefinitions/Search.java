package stepDefinitions;

import org.openqa.selenium.By;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchPage;

import static factory.DriverStore.driver;
import static utils.CommonFunctions.*;
import static utils.Constants.MIN_Wait_SEC;

public class Search {
	SearchPage searchPage;
	@Given("user is on any page")
	public void user_is_on_any_page() {
//		Assert.assertTrue(DriverStore.getDriver().getCurrentUrl().contains("account/login"));
		searchPage=new SearchPage();
		verifyURL("account/login");
	}

	@When("user enter a product {string} in search box")
	public void user_enter_a_product_in_search_box(String product) {
		
		searchPage.enterProduct(product).verifyInputValueEntered(product);
		
		
	}

	@When("user enter a invalid product {string} in search box")
	public void user_enter_a_invalid_product_in_search_box(String product) {
		driver.findElement(By.cssSelector("input[name='search']")).sendKeys(product);
	}

	@And("user clicks on search button")
	public void user_clicks_on_search_button() {
		searchPage.Search().scrollProduct();
		
	}

	@Then("product with name {string}  should display")
	public void product_with_name_should_display(String productName) {		
		try {
			waitForSec(MIN_Wait_SEC);
			searchPage.verifyProductDisplayedOrNot(productName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			

	}

	@Then("user should get proper message {string} should displayed")
	public void user_should_get_proper_message_should_displayed(String message) {
		searchPage.verifyNoProductMessageDisplayed(message);
	}

}
