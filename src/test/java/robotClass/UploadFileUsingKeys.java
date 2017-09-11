package robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileUsingKeys {


	// Declaring global variable
	WebDriver driver;

		
	// BeforeTest - The annotated method will be run before any Test methods belonging to classes is run
	@BeforeTest
	public void start() {

		// Provide the path of driver location
		System.setProperty("webdriver.firefox.marionette", "./BrowserDrivers/geckodriver.exe");

		// Driver instance is created
		driver = new FirefoxDriver();

	}
	
	@Test
	public void uploadFile() throws InterruptedException, AWTException {
		
		// Specify the file location with extension
		StringSelection s = new StringSelection("E:\\ECLIPSE ENV\\Selenium_Excercises\\AutoIT_RobotClass\\src\\test\\resources\\testResources\\Resume.doc");
		
		// Copy to clip board
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		
		// Open Monsterindia website
		driver.get("http://my.monsterindia.com/create_account.html"); 
		
		// This will scroll down the page using JavaScript Executor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,350)");
		
		// This will click on Browse button
		driver.findElement(By.id("wordresume")).click();
		
		
		Robot robot = new Robot(); 
	
		Thread.sleep(2000);	
		
		// Pressing Enter
		robot.keyPress(KeyEvent.VK_ENTER);

		// Releasing Enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		// Pressing CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// Releasing CTRL+V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		
		// Pressing Enter 
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);	
		
	}
	
	// AfterTest - The annotated method will be run after all the Test methods belonging to the classes have run
	@AfterTest
	public void end() {

		// The below method will close the current browser window
		driver.close();
	}



}
