package Rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponet;

public class OrderPage extends AbstractComponet {
	WebDriver driver;
	
	@FindBy(css= "tr td:nth-child(3)")
	List<WebElement> productNames;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyOrderDisplay(String productName) {
		boolean match = productNames.stream()
				.anyMatch(Product -> Product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
}
