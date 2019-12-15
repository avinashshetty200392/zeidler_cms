package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.cucumber.listener.Reporter;


public class CommonMethods {
	private static WebDriver driver;
	private static Properties properties;
	private static String projectPath;
	
	public static WebDriver initializeDriver()
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void browseWindowPopUp(String imgName) throws Throwable
	{
		Robot robot = new Robot();
		projectPath = System.getProperty("user.dir");
		String imageFilePath = projectPath+"\\"+imgName;
		
		Thread.sleep(2000);
		
		StringSelection selection = new StringSelection(imageFilePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		
        Thread.sleep(2000);
        
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_V);
 
        robot.keyRelease(KeyEvent.VK_CONTROL);  
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_V);
 
        Thread.sleep(1000);
 
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_ENTER);

	}
	
	public static void getReportConfigPath(){
		 Reporter.loadXMLConfig(new File(projectPath+"\\extent-config.xml"));
		 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("OS", "Windows 10" + "64 Bit");

		}
	
	public static void tearDown(WebDriver driver)
	{
		driver.quit();
	}
}
