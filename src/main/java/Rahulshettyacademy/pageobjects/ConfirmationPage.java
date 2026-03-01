package Rahulshettyacademy.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rahulshettyacademy.AbstractComponents.AbstractComponet;

public class ConfirmationPage extends AbstractComponet {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// driver.findElement(By.cssSelector(".hero-primary")).getText();

	@FindBy(css= ".toast-bottom-right")
	WebElement confirmationmsg;

	public String getConfirmationMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // Wait until the toast message is VISIBLE 
        wait.until(ExpectedConditions.visibilityOf(confirmationmsg));
        String msg = confirmationmsg.getText().trim();
		return msg;
	}

}
