package rahulshettyacademy.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Rahulshettyacademy.pageobjects.CartPage;
import Rahulshettyacademy.pageobjects.CheckoutPage;
import Rahulshettyacademy.pageobjects.ConfirmationPage;
import Rahulshettyacademy.pageobjects.LandingPage;
import Rahulshettyacademy.pageobjects.OrderPage;
import Rahulshettyacademy.pageobjects.ProductCatelogue;
import rahulshettyacademy.TestComponents.BaseTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubmitOrderTest extends BaseTest {

	String productName ="ADIDAS ORIGINAL";

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException {
		
		//this.orderedProductName = productName;

		// To login to the application
		ProductCatelogue ProductCatelogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		// add to cart button
		ProductCatelogue.addProductToCart(input.get("product"));
		// going to cart page
		CartPage cartPage = ProductCatelogue.goToCartPage();
		boolean match = cartPage.VerifyProductDisplay(input.get("product"));
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

	}
	

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		ProductCatelogue ProductCatelogue = landingPage.loginApplication("chandujadhav96k+1204@gmail.com", "Hello123@");
		OrderPage OrderPage = ProductCatelogue.goToOrderPage();
		Assert.assertTrue(OrderPage.VerifyOrderDisplay(productName));
	}
	
	
	public String getScreenShot(String testCaseName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//" + testCaseName+ ".png" );
		FileUtils.copyFile(source, file);
		
		return System.getProperty("user.dir")+"//reports//" + testCaseName+ ".png";
		
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String, String>>data= getJsonDataToMap(System.getProperty("user.dir")+
				"\\src\\main\\java\\Rahulshettyacademy\\data\\PurchaseOrder.json");
		
		return new Object [] [] {{data.get(0)}, {data.get(1)}};
	}
	
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object [] [] {{"chandujadhav96k+1204@gmail.com","Hello123@", "ADIDAS ORIGINAL"}, {"chandujadhav96k+1204@gmail.com", "Hello123@", "iphone 13 pro"}};
//	}
	
	
//	HashMap<String,String>map=new HashMap<String,String>();
//	map.put("email", "chandujadhav96k+1204@gmail.com");
//	map.put("password", "Hello123@");
//	map.put("product", "ADIDAS ORIGINAL");
//	
//	HashMap<String,String>map1=new HashMap<String,String>();
//	map1.put("email", "chandujadhav96k+1204@gmail.com");
//	map1.put("password", "Hello123@");
//	map1.put("product", "ADIDAS ORIGINAL");

}