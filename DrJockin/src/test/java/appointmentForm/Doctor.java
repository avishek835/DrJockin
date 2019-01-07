package appointmentForm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseFile.Base;

public class Doctor extends Base{
	
	
	Doctor() {
		super();
		
	}

	@Test(dataProvider="getData")
	public void doctor(String FirstName, String MiddleName, String LastName, String Address, 
			String Phone, String Email, String MedicalSchool, String DateOfGraduation, String Internship,
			String ResidencyTraining, String FellowshipTraining, String DefaultFacility, String JobDescription
, String WebsiteURL, String MedicalLicense, String DEA, String UPIN ) throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 2200);");
		driver.findElement(By.xpath(propX.getProperty("FirstName"))).sendKeys(FirstName);
		driver.findElement(By.xpath(propX.getProperty("MiddleName"))).sendKeys(MiddleName);
		driver.findElement(By.xpath(propX.getProperty("LastName"))).sendKeys(LastName);
		driver.findElement(By.xpath(propX.getProperty("Address"))).sendKeys(Address);
		driver.findElement(By.xpath(propX.getProperty("Phone"))).sendKeys(Phone);
		driver.findElement(By.xpath(propX.getProperty("Email"))).sendKeys(Email);
		driver.findElement(By.xpath(propX.getProperty("MedicalSchool"))).sendKeys(MedicalSchool);
		
		driver.findElement(By.xpath(propX.getProperty("DateOfGraduation"))).clear();
		driver.findElement(By.xpath(propX.getProperty("DateOfGraduation"))).sendKeys(DateOfGraduation);
		
		
		driver.findElement(By.xpath(propX.getProperty("Internship"))).sendKeys(Internship);
		driver.findElement(By.xpath(propX.getProperty("ResidencyTraining"))).sendKeys(ResidencyTraining);
		driver.findElement(By.xpath(propX.getProperty("FellowshipTraining"))).sendKeys(FellowshipTraining);
		driver.findElement(By.xpath(propX.getProperty("DefaultFacility"))).sendKeys(DefaultFacility);
		driver.findElement(By.xpath(propX.getProperty("JobDescription"))).sendKeys(JobDescription);
		 drpDown= new Select(driver.findElement(By.id(propX.getProperty("ProviderType"))));
		drpDown.selectByIndex(3);
		
		
		 drpDown=new Select(driver.findElement(By.xpath(propX.getProperty("IntegratedMedicine"))));
		drpDown.selectByIndex(2);
		
		driver.findElement(By.xpath(propX.getProperty("WebsiteURL"))).sendKeys(WebsiteURL);
		driver.findElement(By.xpath(propX.getProperty("MedicalLicense"))).sendKeys(MedicalLicense);
		driver.findElement(By.xpath(propX.getProperty("DEA"))).sendKeys(DEA);
		 e=driver.findElement(By.xpath(propX.getProperty("CAGH")));
		e.click();
		
		driver.findElement(By.xpath(propX.getProperty("UPIN"))).sendKeys(UPIN);
		 e=driver.findElement(By.xpath(propX.getProperty("T&C")));
		 e.click();
		 e=driver.findElement(By.xpath(propX.getProperty("T&CBox")));
		 e.getText();
		 if(e!=null)
		 {
			 System.out.println(e);
		 }
		 
		 Thread.sleep(1000);
		 e=driver.findElement(By.xpath(propX.getProperty("Signature")));
		
		 Actions builder = new Actions(driver);
		    Action drawAction = builder.moveToElement(e,135,15) //start points x axis and y axis. 
		              .click()
		              .moveByOffset(200, 60) // 2nd points (x1,y1)
		              .click()
		              .moveByOffset(100, 70)// 3rd points (x2,y2)
		              .doubleClick()
		              .build();
		    drawAction.perform();
		    Thread.sleep(1000);
		    
		    e=driver.findElement(By.xpath(propX.getProperty("Send")));
		    e.click();
		    wait = new WebDriverWait(driver, 20);
			 element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(propX.getProperty("TYM"))));
			 s=driver.findElement(By.xpath(propX.getProperty("TYM"))).getText();
			   if(s!=null)
			    {
			    	System.out.println(s);
			    }
		
	}
	
	@DataProvider(name="getData")
	 
	 public Object[][] getData() {
			Object[][] arrayObject = getExcelData("E:\\Avishek\\SeleniumProjects\\DrJockin\\src\\test\\java\\appointmentForm\\AppoinmentData.xls","Doctor");
			return arrayObject;
}	

}
