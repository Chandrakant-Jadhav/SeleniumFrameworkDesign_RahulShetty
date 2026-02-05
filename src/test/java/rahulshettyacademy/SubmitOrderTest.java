package rahulshettyacademy;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Rahulshettyacademy.pageobjects.CartPage;
import Rahulshettyacademy.pageobjects.CheckoutPage;
import Rahulshettyacademy.pageobjects.ConfirmationPage;
import Rahulshettyacademy.pageobjects.LandingPage;
import Rahulshettyacademy.pageobjects.ProductCatelogue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		// To login to the application
		ProductCatelogue ProductCatelogue = landingPage.loginApplication("chandujadhav96k+1204@gmail.com", "Hello123@");
		// add to cart button
		ProductCatelogue.addProductToCart(productName);
		// going to cart page
		CartPage cartPage = ProductCatelogue.goToCartPage();
		boolean match = cartPage.VerifyProductDisplay(productName);
		// assertion to verify the product is in the cart
		Assert.assertTrue(match);
		// clicking on checkout button
		CheckoutPage CheckoutPage = cartPage.goToCheckout();

		// SCrolling to the element
		CheckoutPage.scrollToElement();
		// Select Country
		CheckoutPage.selectCountry("India");
		ConfirmationPage ConfirmationPage = CheckoutPage.submitOrder();

		// Confirmation message assertion
		String ConfirmationMsg = ConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(ConfirmationMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		// closing the driver
		driver.quit();

	}

}