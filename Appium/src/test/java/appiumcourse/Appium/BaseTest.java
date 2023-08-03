package appiumcourse.Appium;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void configureAppium() throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir"+"//src//main//java//org//appiumcourse//resources//data.properties"));
		prop.load(fis);
		String iPAddress=prop.getProperty("iPAddress");
		String port=prop.getProperty("port");
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("AbhishekPixel");
		options.setChromedriverExecutable("C:\\Users\\Abhishek\\Desktop\\Desktop\\Important\\chromedriver.exe");
		//options.setApp("C://Users//Abhishek//Desktop//Important//Workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
		options.setApp("C://Users//Abhishek//Desktop//Desktop//Important//Workspace//Appium//src//test//java//resources//General-Store.apk");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	//long pressing a button for the duration of 2 seconds.
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
				"duration",2000));
	}
	
	// Scroll to the end method.
	public void scrollToEndAction() throws InterruptedException
	{
		boolean canScrollMore; 
		do
		{
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			    
			));  
		}while(canScrollMore);//------> it will give true or false. true if there is still some scope of scrolling.
			Thread.sleep(2000);
	}
	
	public void swipeAction(WebElement ele, String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				   "elementId",((RemoteWebElement)ele).getId(),
				    "direction", "left",
				    "percent", 0.75
				));
	}
	
	public void dragAndDrop(WebElement ele, int x,int y)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId(),
			    "endX", x,
			    "endY",y
			));
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
