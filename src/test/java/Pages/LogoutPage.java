package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

	WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
	} 
	 
	
	//Locators for Logout dropdown and Logout
	By options = By.xpath("//div[@class='oxd-topbar-header']/div/ul/li/span");
	By logout = By.xpath("//a[@href='/web/index.php/auth/logout' and @class='oxd-userdropdown-link']");

	
	//Method to click on Logout dropdown
	public void logoutOptions() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.presenceOfElementLocated(options));
		driver.findElement(options).click();	
	}
	//Method to click on Logout
	public void logout() throws InterruptedException
	{
		driver.findElement(logout).click();
	
	}
	
}
