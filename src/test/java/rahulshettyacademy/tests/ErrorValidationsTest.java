package rahulshettyacademy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Rahulshettyacademy.pageobjects.CartPage;
import Rahulshettyacademy.pageobjects.CheckoutPage;
import Rahulshettyacademy.pageobjects.ConfirmationPage;
import Rahulshettyacademy.pageobjects.ProductCatelogue;
import rahulshettyacademy.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void loginErrorValidation() throws IOException, InterruptedException {
		landingPage.loginApplication("chandujadhav+WrongEmail+QA@gmail.com", "HelloQAA");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");

	}

	@Test
	public void productErrorValidation() throws IOException, InterruptedException {
		String productName = "ADIDAS ORIGINAL";
		ProductCatelogue ProductCatelogue = landingPage.loginApplication("chandujadhav96k+1204@gmail.com", "Hello123@");
		ProductCatelogue.addProductToCart(productName);
		CartPage cartPage = ProductCatelogue.goToCartPage();
		boolean match = cartPage.VerifyProductDisplay("TestWrong_ADIDAS");
		Assert.assertFalse(match);
	}

}