package rahulshettyacademy;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Rahulshettyacademy.pageobjects.LandingPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		LandingPage landingPage = new LandingPage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("chandujadhav96k+1204@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hello123@");
		driver.findElement(By.id("login")).click();
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		// product selection by name
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		// add to cart button
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		// finding toast message
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// loading bar icon to disappear
		// explicit wait
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		// clicking on cart button
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		// findElements returns a List so we can stream over multiple cart item headings
		List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class=\"cartSection\"]/h3"));

		// check if any cart product matches the expected product name
		boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		// assertion to verify the product is in the cart
		Assert.assertTrue(match);

		// clicking on checkout button
		driver.findElement(By.cssSelector(".totalRow button")).click();

		// entering country name
		// Actions a =new Actions(driver);
		// a.sendKeys(driver.findElement(By.cssSelector("*[placeholder='Select
		// Country']")), "india").build().perform();

		// SCrolling to the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");

		// entering country name
		driver.findElement(By.cssSelector("*[placeholder='Select Country']")).sendKeys("india");

		// explicit wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		// selecting the country from the dropdown
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();

		// clicking on place order button
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		//Confirmation message assertion
		String ConfirmationMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(ConfirmationMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		// closing the driver
		driver.quit();

	}

}