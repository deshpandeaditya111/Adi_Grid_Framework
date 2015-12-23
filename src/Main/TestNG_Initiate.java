package Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.List;
import Main.ReflectionClassNew;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Test;

import ExcelCommunication.ReadExcel; 
 
public class TestNG_Initiate { 
	
	 protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	  /*  @BeforeTest
	    public void setUp() throws MalformedURLException {  
	        threadDriver = new ThreadLocal<RemoteWebDriver>();
	        DesiredCapabilities dc = new DesiredCapabilities(); 
	        FirefoxProfile fp = new FirefoxProfile(); 
	        dc.setCapability(FirefoxDriver.PROFILE, fp);
	        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
	        threadDriver.set(new RemoteWebDriver(new URL("http://10.3.14.34:5555/wd/hub"), dc));
	    }*/
	   public WebDriver getDriver()  
	    {   
	      return threadDriver.get(); 
	    }  
	     
	@Test
  public static void Smoke_Test_All_Functionality() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException
	{
		List<String> listFromExcel= new ArrayList<String>();
		HashMap<String, List<String>> mapFromExcel= new HashMap<String, List<String>>();
		ReadExcel myobj= new ReadExcel();  
		mapFromExcel=myobj.readExcel();   
		for (int i=1; i<=30; i++)        
		{			   
			listFromExcel = mapFromExcel.get("STEP_0"+i);     
			System.out.println("List is"+listFromExcel);
			ReflectionClassNew.callMethods(listFromExcel.get(0), listFromExcel.get(1),listFromExcel.get(2),listFromExcel.get(3));   
			 
			}    
	}            
	              
}           
   
             