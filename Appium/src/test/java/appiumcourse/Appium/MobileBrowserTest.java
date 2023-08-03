package appiumcourse.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTest extends MobileBrowserBase {

	@Test
	public void mobileBrowserTest()
	{
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Youtube");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}
}
