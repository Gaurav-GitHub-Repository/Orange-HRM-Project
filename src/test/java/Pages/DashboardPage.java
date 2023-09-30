package Pages;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends Utility{

	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	} 
 
	//Locators for Admin Module, Button, Username, User Role, Status, Search Button and Reset Button in User Management 
	By Admin = By.xpath("//ul[@class='oxd-main-menu']/li");
	By Btn = By.xpath("//button[@class='oxd-icon-button oxd-main-menu-button']");
	By Username = By.xpath("//form[@class='oxd-form']/div/div/div/div/div/input");
	By UserRole = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']/div/i");
	By SelectAdmin = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
	By EmployeeName = By.xpath("//div[@class='oxd-autocomplete-wrapper']/div/input");
	By Status = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i");
	By SelectStatus = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]");
	By SearchBtn = By.xpath("//button[@type='submit']");
//	By resetBtn = By.xpath("//div[@class='oxd-form-actions']/button[@type='button']");
	
	
	//Locators for Job Module, Job Title Module, Add Button, Job Title, Job Description, Specification, Note and Save button 
	By Job = By.xpath("//span[text()='Job ']");
	By Title = By.xpath("//a[@href='#' and text()='Job Titles']");
	By AddBtn = By.xpath("//button[@type='button' and @class='oxd-button oxd-button--medium oxd-button--secondary']");
	By JobTitle = By.xpath("//form[@class='oxd-form']/div/div/div/input[@class='oxd-input oxd-input--active']");
	By JobDescription = By.xpath("//*[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical' and @placeholder='Type description here']");
	By Specification = By.xpath("//div[text()='Browse' and @class='oxd-file-button']");
	By NoteDescription = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical' and @placeholder='Add note']");
	By SaveButton = By.xpath("//button[@type='submit' and text()=' Save ']");
	By Workshift = By.xpath("//a[@href='#' and text()='Work Shifts']");
	By WorkAdd = By.xpath("//button[@type='button' and @class='oxd-button oxd-button--medium oxd-button--secondary']");
	By Shiftname = By.xpath("//form[@class='oxd-form']/div/div/div/div/div/input");
    By From = By.xpath("//div[@class='oxd-time-wrapper']/div/i");	
    By FromDropdown = By.xpath("//i[@class='oxd-icon bi-chevron-up oxd-icon-button__icon oxd-time-hour-input-up']");
	By To = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/i");
    By ToDropdown = By.xpath("//i[@class='oxd-icon bi-chevron-up oxd-icon-button__icon oxd-time-hour-input-up']");
    By AssignedEmployees = By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']/input");
    By btn = By.xpath("//button[@type='submit' and text()=' Save ']");
    
    
    //Locators for Qualification Module, Skills Module, Add Button, Name and Save Button
    By Qualification = By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li[4]");
    By Skills = By.xpath("//a[@href='#' and text()='Skills']");
    By QualificationButton = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
    By QualificationName = By.xpath("//form[@class='oxd-form']/div/div/div/input");
    By QualificationSave = By.xpath("//button[@type='submit' and @class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    
    
    
    //Method to click on Admin Module
	public void admin() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Admin).click();
	}
	//Method to click on Button
	public void button() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.presenceOfElementLocated(Btn));
		driver.findElement(Btn).click();
	}
	//Method to enter username value in Admin/User Management
	public void username(String un) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.presenceOfElementLocated(Username));
		driver.findElement(Username).sendKeys(un);
	}
	
/*	public void role() throws InterruptedException 
	{
		
		try {
			Thread.sleep(5000);
			driver.findElement(UserRole).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000);
			driver.findElement(UserRole).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);
			driver.findElement(UserRole).sendKeys(Keys.ENTER);
		} catch (ElementNotInteractableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}  */
	
	
	//Method to click on User Role dropdown and select admin option
	public void role() throws InterruptedException
	{
	 
	  Thread.sleep(5000);	
	  driver.findElement(UserRole).click();		
	  
	  WebDriverWait Admin_wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
	  Admin_wait.until(ExpectedConditions.presenceOfElementLocated(SelectAdmin));
	  driver.findElement(SelectAdmin).click();
	}
	//Method to enter employee name value in User Management
	public void employee(String name) throws InterruptedException
	{
		driver.findElement(EmployeeName).sendKeys(name);
		Thread.sleep(5000);
		driver.findElement(EmployeeName).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		driver.findElement(EmployeeName).sendKeys(Keys.ENTER);
	}
	//Method to click on status dropdown and select enabled option
	public void status() throws InterruptedException
	{
		Thread.sleep(5000);	
		driver.findElement(Status).click();
	
		WebDriverWait status_wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		status_wait.until(ExpectedConditions.presenceOfElementLocated(SelectStatus));
		driver.findElement(SelectStatus).click();
    }	
	//Method to click on search button
	public void search() throws InterruptedException
	{
		WebDriverWait status_wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		status_wait.until(ExpectedConditions.presenceOfElementLocated(SearchBtn));
		driver.findElement(SearchBtn).click();
	}   
	
	
	//Method to click on reset button
/*	public void reset() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(resetBtn).click();
	}  */  
	
	
	
	//Method to click on Job Module
	public void job() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Job).click();
	}
	//Method to click on Job Title Module
	public void title() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Title).click();
	}
	//Method to click on Add Button in Job Title
	public void addBtn() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.presenceOfElementLocated(AddBtn));
		driver.findElement(AddBtn).click();
	}
	//Method to enter Job Title Description
	public void jobTitle(String profile) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.presenceOfElementLocated(JobTitle));
		driver.findElement(JobTitle).sendKeys(profile);
	}
	//Method to enter Job Description
    public void jobDescription(String Description) throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.presenceOfElementLocated(JobDescription));
    	driver.findElement(JobDescription).sendKeys(Description);
    }
    //Method to click on Browse Button
    public void jobSpecification() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.presenceOfElementLocated(Specification));
    	driver.findElement(Specification).click();
    }    
    //Method to upload file using Robot Class
    public void uploadFile() throws InterruptedException
    {
    	try {
    		Thread.sleep(5000);
			fileUpload();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //Method to enter Note Description
    public void noteDescription(String description) throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.presenceOfElementLocated(NoteDescription));
    	driver.findElement(NoteDescription).sendKeys(description); 	
    }
    //Method to click on Save Button
    public void saveButton() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.presenceOfElementLocated(SaveButton));
    	driver.findElement(SaveButton).click();
    }  
    //Method to click on Work Shift Module
    public void work() throws InterruptedException
    {
    	Thread.sleep(5000);
    	driver.findElement(Workshift).click();	
    }  
    //Method to click on Add Button in Work Shift Module
    public void workButton() throws InterruptedException
    {
     	Thread.sleep(5000);
    	driver.findElement(WorkAdd).click();
    } 
    //Method to enter shift name in Work Shift Module
    public void shiftName(String SfiftName) throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
  	    wait.until(ExpectedConditions.presenceOfElementLocated(Shiftname));	
    	driver.findElement(Shiftname).sendKeys(SfiftName);
    } 
    //Method to click on "from" time dropdown
    public void fromTime() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
  	    wait.until(ExpectedConditions.presenceOfElementLocated(From));	
    	driver.findElement(From).click();
    }  
    //Method to select working hours in from time dropdown
    public void from() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
  	    wait.until(ExpectedConditions.presenceOfElementLocated(FromDropdown));	
    	driver.findElement(FromDropdown).click();
    }   
    //Method to click on "to" time dropdown
    public void toTime() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
  	    wait.until(ExpectedConditions.presenceOfElementLocated(To));	
    	driver.findElement(To).click();
    }   
    //Method to select working hours in to time dropdown
    public void to() throws InterruptedException
    {
    	
    	driver.findElement(ToDropdown).click();
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
  	    wait.until(ExpectedConditions.presenceOfElementLocated(To));
    	driver.findElement(To).click();
    }   
    //Method to enter Assigned Employee Name
    public void Employees(String assignedEmployee) throws InterruptedException 
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.presenceOfElementLocated(AssignedEmployees));
    	driver.findElement(AssignedEmployees).sendKeys(assignedEmployee);
    	
    	try {
			 Thread.sleep(2000);
			 driver.findElement(AssignedEmployees).sendKeys(Keys.ARROW_DOWN);
			 Thread.sleep(2000);
			 driver.findElement(AssignedEmployees).sendKeys(Keys.ENTER);	
    	}
    	 catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Assigned Employee in work shift is not correct. Unable to fetch employee full name from my info details.");
		}
    }    
    //Method to click on Save Button
    public void Btn() throws InterruptedException
    {
    
    	Thread.sleep(5000);
    	driver.findElement(Btn).click();
    }    
    //Method to click on Qualification Module
    public void qualification() throws InterruptedException
    {
    	Thread.sleep(5000);
    	driver.findElement(Qualification).click();
    }   
    //Method to click on Skills in Qualification Module
    public void skills() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
  	    wait.until(ExpectedConditions.presenceOfElementLocated(Skills));
    	driver.findElement(Skills).click();
    }    
    //Method to click on Add Button in Qualification Module
    public void qualificationButton() throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
  	    wait.until(ExpectedConditions.presenceOfElementLocated(QualificationButton));
    	driver.findElement(QualificationButton).click(); 
    }    
    //Method to enter name in Qualification Module
    public void qualificationName(String Qname) throws InterruptedException
    {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
  	    wait.until(ExpectedConditions.presenceOfElementLocated(QualificationName));
    	driver.findElement(QualificationName).sendKeys(Qname);
    }    
    //Method to click on Save Button
    public void qSaveButton() throws InterruptedException
    {
    	Thread.sleep(5000);
    	driver.findElement(QualificationSave).click();
    }
}
