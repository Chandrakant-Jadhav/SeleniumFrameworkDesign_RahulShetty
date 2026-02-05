package Rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponet;

public class CheckoutPage extends AbstractComponet {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action__submit")
	WebElement submit;

	@FindBy(css = "*[placeholder='Select Country']")
	WebElement Country;

	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;

	By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryname) {
		// Actions a = new Actions(driver);
		// a.sendKeys(Country, countryname).build().perform();

		Country.sendKeys(countryname);
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}

}
