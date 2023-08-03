package appiumcourse.Appium;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollDownAction extends BaseTest {

	@Test
	public void AppiumTest() throws MalformedURLException, InterruptedException 
	{
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//use this when you have idea of till what item you want to scroll.
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		// when you have no idea till what you have to scroll, use this method 
		scrollToEndAction();
}
}
