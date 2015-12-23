package Main;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import ExcelCommunication.ReadExcel;
 
 
public class InitiateClass {
	 protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	 public WebDriver getDriver()  
	    {   
	      return threadDriver.get(); 
	    }  
	     
	
	@Test
	public static void Smoke() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException
	{
		List<String> listFromExcel= new ArrayList<String>();
		HashMap<String, List<String>> mapFromExcel= new HashMap<String, List<String>>();
		ReadExcel myobj= new ReadExcel(); 
		mapFromExcel=myobj.readExcel();
		ReflectionClassNew rf= new ReflectionClassNew();
		
		 
		for (int i=1; i<=30; i++)     
		{			
			listFromExcel = mapFromExcel.get("STEP_0"+i); 
			
			ReflectionClassNew.callMethods(listFromExcel.get(0), listFromExcel.get(1),listFromExcel.get(2),listFromExcel.get(3));
		}
	} 
 
}   

//ReflectionClass.callMethods("enterText", "name", "userName", "batman"); 
		/*ReflectionClass rfcls= new ReflectionClass();// just to initialize constructor
		ReflectionClass.callMethods("getURL", "NULL", "NULL", "http://newtours.demoaut.com/"); 
		ReflectionClass.callMethods("enterText", "name", "userName", "batman");
		ReflectionClass.callMethods("enterText", "name", "password", "batman");  
		ReflectionClass.callMethods("login", "name", "login", "NULL");*/ 



