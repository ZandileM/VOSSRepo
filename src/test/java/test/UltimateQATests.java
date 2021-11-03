package test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class UltimateQATests {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	public WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@Parameters("browserName")
	@BeforeTest
	public void setUpTest(String browserName) {
		
		// start report
        htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);  
 
        // Set WebDriver
	
		
		/*
		 * System.out.println(projectPath); System.setProperty("webdriver.gecko.driver",
		 * projectPath + "/drivers/geckodriver/geckodriver.exe"); driver = new
		 * FirefoxDriver();
		 * 
		 * System.out.println(projectPath); System.setProperty("webdriver.gecko.driver",
		 * projectPath + "/drivers/geckodriver/geckodriver.exe"); driver = new
		 * FirefoxDriver();
		 */
		 
		
		System.out.println("Browser Name is :" + browserName);
		System.out.println("Thread id :" + Thread.currentThread().getId());

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.gecko.marionette", projectPath+"t\\drivers\\gickodriver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\Gickodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}

	}

	@Test
	public void launchBrowser() throws Exception {
		ExtentTest test = extent.createTest("Testing UltimateQA website", "Assessment test");
		
     	// Launch browser
		driver.get("https://ultimateqa.com/automation/");
		test.pass("Launch UltimateQA");
		
        // log with snapshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
		
		test.log(Status.INFO, "Starting Test Case");
		

		//Take screenshort and save to image folder
        this.takeSnapShot(driver, projectPath+"/image/test.png") ;  

		// Muximise browser
		driver.manage().window().maximize();

		// Launch Login page
		driver.findElement(By.xpath("//a[contains(text(),'Login automation')]")).click();
		test.pass("Launch Login page");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Capture Email
		driver.findElement(By.id("user[email]")).sendKeys("zandile.memka@gmail.com");
		test.pass("Enter registered email");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Capture Password
		driver.findElement(By.id("user[password]")).sendKeys("Zandile@11");
		test.pass("Enter rpassword");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Click Sign in
		driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]")).click();
		test.pass("Logged In successfully");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Open dropdown and select SignOut
	  	//driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]")).click();
	  	//System.out.println("Logout");
	  
	  	//Launch page again
	  	driver.get("https://ultimateqa.com/automation/");
	  	test.pass("Launch page again to open Fill fomrs page");
	  	
	  	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	
	  	//Open 'Fill out Forms' page
	  	driver.findElement(By.xpath("//a[contains(text(),'Fill out forms')]")).click();
	  	test.pass("Launched Fill forms page");
	  	
	  	//Enter Name of form1
	  	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/p[1]/input[1]")).sendKeys("Zandile Memka");
	  	test.pass("Captured Name");
	  	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	
	  	//Enter message of form1 
	  	driver.findElement(By.id("et_pb_contact_message_0")).sendKeys("This is for testing purposes for message one");
	  	test.pass("Captured Message of Form 1");
	  	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	
	  	//Submit Form1
	  	driver.findElement(By.xpath("//body/div[@id='page-container']/div[@id='et-boc']/div[@id='et-main-area']/div[@id='main-content']/article[@id='post-881']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/button[1]")).click();
	  	test.pass("Form 1 submitted successfully");
	  	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	
	  	//Enter Name of Form2
	   	driver.findElement(By.id("et_pb_contact_name_1")).sendKeys("Tittle of Message 2");
	   	test.pass("Captured Name on Form 2");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	
		//Enter Message of Form2
	  	driver.findElement(By.id("et_pb_contact_message_1")).sendKeys("This is captured message 2 for testing purposes");
	  	test.pass("Captured Message on Form 2");  	
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	  	//Submit Form2
	  	driver.findElement(By.xpath("//body/div[@id='page-container']/div[@id='et-boc']/div[@id='et-main-area']/div[@id='main-content']/article[@id='post-881']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/button[1]")).click();
	  	test.fail("Could not submit form 2 because of captcha");	  	
	  	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	
	  	//Order package
	  	driver.get("https://ultimateqa.com/automation/");
	  	test.pass("Launched Order Package page");
	  	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	
	  	//Fake Pricing Package
	  	driver.findElement(By.xpath("//a[contains(text(),'Fake Pricing Page')]")).click();
	  	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/a[1]")).click();
	  
     

	}

	public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		Files.copy(SrcFile, DestFile);

	}

	
	@AfterTest
	public void tearDownTest() {
		
		//Close Browser
		driver.close();
	
        // calling flush writes everything to the log file
        extent.flush();
        
		System.out.println("Test Completed Successfully");
		
	}
	
}
