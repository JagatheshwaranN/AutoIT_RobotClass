/**
 * @author Jagatheshwaran
 * 
 */
// Package is created as xsltReport
package autoIT;

// Importing the predefined class libraries
import java.io.IOException;

// The class is created with name : CustomerLogin
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Declaring global variable
public class FileUpload {

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

	/**
	 * The method name is : fileUpload 
	 * This method is annotated with Test.
	 * It will act as a test method.This method will launch browser.
	 * Navigate to the URL and enter the inputs and upload file.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * 
	 */
	@Test
	public void fileUpload() throws IOException, InterruptedException {

		// Launching the browser with the below url
		driver.get("file:///E:/ECLIPSE%20ENV/Selenium_Excercises/AutoIT_RobotClass/src/test/resources/testResources/upload.html");

		driver.findElement(By.name("name")).sendKeys("Jagatheshwaran");
		driver.findElement(By.name("email")).sendKeys("testjaga001@gmail.com");
		driver.findElement(By.name("textline")).sendKeys("Automation Tester");
		driver.findElement(By.name("datafile")).click();

		// Provide the path of the created AutoIT file 
		Runtime.getRuntime().exec("E:\\ECLIPSE ENV\\Selenium_Excercises\\AutoIT_RobotClass\\src\\test\\resources\\testResources\\FileUpload.exe");

		System.out.println("File upload successful");

		driver.findElement(By.name("submit")).click();

		System.out.println("File submit successful");

		String ExpectedUrl = "http://www.cs.tut.fi/cgi-bin/run/~jkorpela/echo.cgi";
		String ActualUrl = driver.getCurrentUrl();

		// Verifies the Expected url and Actual url are Correct
		Assert.assertEquals(ExpectedUrl, ActualUrl);

	}

	// AfterTest - The annotated method will be run after all the Test methods belonging to the classes have run
	@AfterTest
	public void end() {

		// The below method will close the current browser window
		driver.close();
	}

}
