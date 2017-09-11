package robotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFileUsingKeys {

	
	// Declaring global variable
	WebDriver driver;

		
	// BeforeTest - The annotated method will be run before any Test methods  belonging to classes is run
	@BeforeTest
	public void start() {

		// Provide the path of driver location
		System.setProperty("webdriver.firefox.marionette", "./BrowserDrivers/geckodriver.exe");

		// Driver instance is created
		driver = new FirefoxDriver();

	}

	@Test
	public void downloadFile() throws InterruptedException, AWTException {
		
		driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/"); 
		
		driver.findElement(By.xpath(".//a[@href=contains(text(),'clockchart.xls')]")).click();
		
		
		Robot robot = new Robot(); 
		
		Thread.sleep(2000);		
		// press arrow down key of keyboard to  navigate and select Save radio button
		robot.keyPress(KeyEvent.VK_DOWN);

		Thread.sleep(2000); 
		robot.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
				
		Thread.sleep(2000);
		// press enter key of keyboard to perform above selected action
		robot.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	// AfterTest - The annotated method will be run after all the Test methods belonging to the classes have run
	@AfterTest
	public void end() {

		// The below method will close the current browser window
		driver.close();
	}

}
