package appiumcourse.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MobileBrowserBase {
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException
	{
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("AbhishekPixel");
		options.setChromedriverExecutable("C:\\Users\\Abhishek\\Desktop\\Important\\chromedriver.exe");  //----> this is required only if your app is hybrid
		options.setCapability("browserName","Chrome");
		
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
