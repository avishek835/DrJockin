package appointmentForm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseFile.Base;

public class Provider extends Base {
	
	
	@Test(dataProvider="getData")
	public void providerForm(String FirstN, String MiddleN, String LastN, String Address, String Phone, String Email, String Hourly_Rate, String Detail) throws InterruptedException
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("scroll(0,2200);");
		driver.findElement(By.xpath(propX.getProperty("ProviderLink"))).click();
		//Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		/*wait = new WebDriverWait(driver, 20);
		 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(propX.getProperty("First_Name"))));*/
		driver.findElement(By.xpath(propX.getProperty("First_Name"))).sendKeys(FirstN);
		driver.findElement(By.xpath(propX.getProperty("Middle_Name"))).sendKeys(MiddleN);
		driver.findElement(By.xpath(propX.getProperty("Last_Name"))).sendKeys(LastN);
		driver.findElement(By.xpath(propX.getProperty("ADDRESS"))).sendKeys(Address);
		driver.findElement(By.xpath(propX.getProperty("PhoneNo"))).sendKeys(Phone);
		driver.findElement(By.xpath(propX.getProperty("Emailid"))).sendKeys(Email);
		driver.findElement(By.xpath(propX.getProperty("Profession"))).click();
		driver.findElement(By.xpath(propX.getProperty("HourlyRate"))).sendKeys(Hourly_Rate);
		driver.findElement(By.xpath(propX.getProperty("Details"))).sendKeys(Detail);
		driver.findElement(By.xpath(propX.getProperty("SEND"))).click();
		
	}
	
	@DataProvider(name="getData")
	 
	 public Object[][] getData() {
			Object[][] arrayObject = getExcelData("E:\\Avishek\\SeleniumProjects\\DrJockin\\src\\test\\java\\appointmentForm\\AppoinmentData.xls","Provider");
			return arrayObject;
}	
	
	 

}
