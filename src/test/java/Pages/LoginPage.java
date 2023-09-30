package Pages;//

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	 
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	//Locators for Username, Password and Login Button
	By Un = By.xpath("//*[@name='username']");
	By Pwd = By.xpath("//*[@name='password']");
	By Btn = By.xpath("//form[@class='oxd-form']/div/button");

	
	//Method to enter username value
	public void username(String un)
	{

		try {
			 Thread.sleep(2000);
			 driver.findElement(Un).sendKeys(un);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Method to enter password value
	public void password(String pwd) throws InterruptedException
	{
		driver.findElement(Pwd).sendKeys(pwd);
	}
	//Method to click on Login Button
	public void button() throws InterruptedException
	{
		driver.findElement(Btn).click();
	}
	
	
}
