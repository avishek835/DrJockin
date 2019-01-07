package drJockinUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class UtilFile {
	
	private Properties prop;
	private FileInputStream ip;
	static ExtentTest test;
	private static ExtentReports extent;
	
	public UtilFile()
	{
		 prop= new Properties();
		 try {
			ip =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\drJockinUtil\\DrJockin.properties");
			prop.load(ip);
		 } catch (FileNotFoundException e) 
		 		{
				e.printStackTrace();
		 		} 
		 		catch (IOException e) 
		 			{
		 				e.printStackTrace();
		 			}
			
	 }
	
	public Properties getProp() {
		return prop;
	}
	
	public static ExtentReports getInstance()
	{
		if(extent==null){
			Date d=new Date();
			String fileName=d.toString().replace(":","_").replace(" ","_")+".html";
			extent=new ExtentReports("E:\\Avishek\\Report\\"+fileName, true, DisplayOrder.NEWEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+"//ReportsConfig.xml"));
		}
		return extent;
		
	}

}
