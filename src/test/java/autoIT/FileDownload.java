package autoIT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownload {

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
		 * The method name is : fileDownload 
		 * This method is annotated with Test.
		 * It will act as a test method.This method will launch browser.
		 * Navigate to the URL and enter the inputs and download the file.
		 * 
		 * @throws IOException
		 * @throws InterruptedException
		 * 
		 */
		@Test
		public void fileDownload() throws IOException, InterruptedException {

			// Launching the browser with the below url
			driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/"); 
			
			// Click the Clockchart Link
			driver.findElement(By.xpath(".//a[@href=contains(text(),'clockchart.xls')]")).click();
			
			// Provide the path of the created AutoIT file 
			Runtime.getRuntime().exec("E:\\ECLIPSE ENV\\Selenium_Excercises\\AutoIT_RobotClass\\src\\test\\resources\\testResources\\FileDownload.exe");

			Thread.sleep(10000);
			System.out.println("File download successful");

		}

		// AfterTest - The annotated method will be run after all the Test methods belonging to the classes have run
		@AfterTest
		public void end() {
	
			// The below method will close the current browser window
			driver.close();
		}

}
