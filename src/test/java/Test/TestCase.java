package Test;

import java.awt.AWTException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


import Pages.DashboardPage;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import Pages.LoginPage;
import Pages.LogoutPage;

public class TestCase  {

	 
		public static void main(String[] args) throws InterruptedException, IOException, AWTException
		{
		    //Test Case 1
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			//Test Case 2
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));			
			//Test Case 3
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");					
			//Test Case 4 & 6
			//Verify Page Title and Current URL of application
			String Actual_URL = "https://opensource-demo.orangehrmlive.com/web/gindex.php/auth/login";
			String Actual_Title = "OrangeHRM";		
	 		if(driver.getCurrentUrl().equals(Actual_URL) && driver.getTitle().equals(Actual_Title))
			{
				System.out.println("Current URL of Orange HRM application is:" + Actual_URL);
				System.out.println("Page Title of Orange HRM application is:" + Actual_Title);
			}	 		
	 		//Create object of Login page
			LoginPage loginpage = new LoginPage(driver);
			//Test Case 7
			loginpage.username("Admin");
			loginpage.password("admin123");
			//Test Case 40
			loginpage.button();			
			//Click on My Info
			try {
				 Thread.sleep(5000);
				 driver.findElement(By.xpath("//span[text()='My Info']")).click();
				
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Create excel file and enter first and last name values
			String Filename = "C:\\Selenium Temp\\Dumps\\OrangeHRM.xlsx";
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Credentials");
            XSSFRow rowhead = sheet.createRow((int)0); 
            rowhead.createCell(0).setCellValue("First Name");
            rowhead.createCell(1).setCellValue("Last Name");			
            XSSFRow row = sheet.createRow((int)1);
            row.createCell(0).setCellValue("@Test");
            row.createCell(1).setCellValue("Auto_5408995");			
            String First_NameSheet = sheet.getRow(1).getCell(0).getStringCellValue();
            System.out.println("First Name from the excel sheet is:" + First_NameSheet);
            String Last_NameSheet = sheet.getRow(1).getCell(1).getStringCellValue();
            System.out.println("Last Name from the excel sheet is:" + Last_NameSheet);
            //Enter first name in My Info from excel sheet
            WebElement First_Name = driver.findElement(By.xpath("//input[@name='firstName' and @placeholder='First Name']"));
            First_Name.clear();
            First_Name.sendKeys(First_NameSheet);            
            //Enter last name in My Info from excel sheet
            WebElement Last_Name = driver.findElement(By.xpath("//input[@name='lastName' and @placeholder='Last Name']"));
            Last_Name.clear();
            Last_Name.sendKeys(Last_NameSheet);                    
            //Concatenation of first name and last name of excel sheet
            String first_name = First_NameSheet;
            String last_name = Last_NameSheet;
            String Employee_Name = first_name.concat(last_name);
            System.out.println("Employee_Name from excel sheet is:" + Employee_Name);          
            //Verify first name and last name values entered in personal details with excel sheet values and take screenshot
            if(First_Name.equals(First_NameSheet) && Last_Name.equals(Last_NameSheet))
            {
            	System.out.println("Employee FullName is successfully saved");
            }	
            else
            {
            	System.out.println("Employee FirstName and LastName in personal details are not correct");
            	Thread.sleep(5000);
            	TakesScreenshot srceenshot = ((TakesScreenshot)driver);
           	    File srcfile = srceenshot.getScreenshotAs(OutputType.FILE);
                File Destination = new File("C:\\Users\\Gaurav\\Documents\\Srceenshot\\OrangeHRMInfo.png");
                FileHandler.copy(srcfile, Destination);
            }     
            //Click on save button
            WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit' and text()=' Save ']")); 
            Thread.sleep(5000);
            saveButton.click();                
            //Close workbook
	    FileOutputStream fileOut = new FileOutputStream(Filename);
	    workbook.write(fileOut);
	    fileOut.close();
	    workbook.close();			
	    //Create object of dashboard page
	    DashboardPage dashboardpage = new DashboardPage(driver);
	    //Test Case 47 & 48
	    dashboardpage.admin();
	    dashboardpage.button();
	    //Test Case 57
	    dashboardpage.username("Admin");
	    //Test Case 60
	    dashboardpage.role();
	    //Test Case 72
	    dashboardpage.employee(Employee_Name);
	    //Test Case 76
	    dashboardpage.status();
	    dashboardpage.search();
	    //dashboardpage.reset();
	    //Verify Employee Name from excel sheet with Employee Name in Admin/User Management and take screenshot 
	    WebElement EmployeeName = driver.findElement(By.xpath("//div[@class='oxd-autocomplete-wrapper']/div/input"));
			if(EmployeeName.equals(Employee_Name))
			{
			   System.out.println("Employee Name in admin is correct");
			}
			else
			{
				System.out.println("Employee Name in admin is not correct. Unable to fetch employee full name from my info details ");
				TakesScreenshot srceenshot = ((TakesScreenshot)driver);
           	  	        File srcfile = srceenshot.getScreenshotAs(OutputType.FILE);
                                File Destination = new File("C:\\Users\\Gaurav\\Documents\\Srceenshot\\OrangeHRMAdmin.png");
                                FileHandler.copy(srcfile, Destination);
			}
			//Test Case 107
			dashboardpage.job();
			dashboardpage.title();
			dashboardpage.addBtn();
			//Test Case 108
			dashboardpage.jobTitle("Automation Testing Engineer");
			//Test Case 110
			dashboardpage.jobDescription("Candidate must have knowledge on Selenium and Framework");
			//Test Case 112
			dashboardpage.jobSpecification();
			//Test Case 114
			dashboardpage.fileUpload();
			//Test Case 115
			dashboardpage.noteDescription("Candidate must have skills in Automation_Testing");
			dashboardpage.saveButton();
			//Test Case 116
			dashboardpage.job();
			dashboardpage.work();
			dashboardpage.workButton();
			dashboardpage.shiftName("Work From Office");
			//Test Case 117
			dashboardpage.fromTime();
			dashboardpage.from();
			dashboardpage.toTime();
			dashboardpage.to();
			//Test Case 119
			dashboardpage.Employees(Employee_Name);
			dashboardpage.Btn();
			//Test Case 120
			dashboardpage.qualification();
			dashboardpage.skills();
			dashboardpage.qualificationButton();
			//Test Case 121
			dashboardpage.qualificationName("Selenium");
			dashboardpage.qSaveButton();
			//Create object of Logout Page
			LogoutPage logoutpage = new LogoutPage(driver);
			//Test Case 123
			logoutpage.logoutOptions();
			//Test Case 124
			logoutpage.logout();
			
			}
		
		}

