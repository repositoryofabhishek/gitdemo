package appiumcourse.pomframework;

import org.appiumcourse.pageObjects.android.CartPage;
import org.appiumcourse.pageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.Activity;

public class Ecommerce_TC4_Hybrid extends BaseTest {

	
	@Test(dataProvider = "getData")
	public void FillForm(String name, String gender, String country) throws InterruptedException
	{
		//FormPage formPage=new FormPage(driver);
		formPage.setNameField(name);
		formPage.setGender(gender);
		ProductCatalogue prodCat=formPage.setCountryName(country);
		prodCat.addItemToCartByIndex(0);
		prodCat.addItemToCartByIndex(0);
		CartPage cartPage=prodCat.goToCartPage();
		
		double totalSum=cartPage.getProductSum();
		double displayedFormattedSum=cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayedFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}
	@SuppressWarnings("deprecation")
//	@BeforeMethod 
	public void preSetup() throws InterruptedException
	{
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		activity.setAppWaitPackage("com.androidsample.generalstore");
		activity.setAppWaitActivity("com.androidsample.generalstore.MainActivity");
		driver.startActivity(activity);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] { {"Abhishek Kumar","female", "Argentina"}};
	}
	
}
