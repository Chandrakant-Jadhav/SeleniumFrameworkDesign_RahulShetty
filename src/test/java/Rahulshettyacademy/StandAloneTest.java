package Rahulshettyacademy;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("chandujadhav96k+1204@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hello123@");
		driver.findElement(By.id("login")).click();
		//explicit wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(05));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		//product selection by name
		WebElement prod= products.stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		//add to cart button
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//finding toast message
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//loading bar icon to disappear
		//explicit wait
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//clicking on cart button
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		System.out.println("cart page is opened");
		
	}

}
