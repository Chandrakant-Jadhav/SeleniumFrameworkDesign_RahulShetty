package rahulshettyacademy.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Rahulshettyacademy.pageobjects.CartPage;
import Rahulshettyacademy.pageobjects.CheckoutPage;
import Rahulshettyacademy.pageobjects.ConfirmationPage;
import Rahulshettyacademy.pageobjects.LandingPage;
import Rahulshettyacademy.pageobjects.ProductCatelogue;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;

public class StepDefinationImpl extends BaseTest {
	public LandingPage landingPage;
	ProductCatelogue productCatelogue;
	ConfirmationPage ConfirmationPage;
	
	
	@Given("I landed on Ecommerce website page")
	public void i_landed_on_ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}
	
	@Given ("^Logged in with username (.+) and (.+)$")
	public void logged_in_with_username_and_Password(String username, String password) {
		productCatelogue=landingPage.loginApplication(username, password);

	}
	
	@When ("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = productCatelogue.getProductList();
		productCatelogue.addProductToCart(productName);
	}
	
	@When ("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_the_order(String productName) throws InterruptedException
	{
		// going to cart page
		CartPage cartPage=productCatelogue.goToCartPage();
		boolean match =cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage CheckoutPage = cartPage.goToCheckout();
		// SCrolling to the element
		CheckoutPage.scrollToElement();
		CheckoutPage.selectCountry("India");
		ConfirmationPage = CheckoutPage.submitOrder();
		
	}
	
	//Then "Order Placed Successfully" message is displayed on confirmation
	@Then("{string} message is displayed on confirmation page")
	public void message_is_displayed_on_confirmation_page(String string) {
		String ConfirmationMsg = ConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(ConfirmationMsg.equalsIgnoreCase(string));
	}
	
}

