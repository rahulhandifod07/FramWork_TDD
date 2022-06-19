package com.qa.pageLayer.TestBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.qa.utility.XLUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Logger logger;
	public static Actions a;
	public static WebDriverWait wait;
	
	
	@Parameters("Browser")
	@BeforeClass
	public void testBase(String browser)
	{
		
		logger=Logger.getLogger("demo");
	    PropertyConfigurator.configure("log4j.properties");
	    
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		logger.info("URL Launch");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		a=new Actions(driver);
	//	wait=new WebDriverWait();
		
	}
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
//		String LoginData[][]= {{"Ram","123","123"},
//							   {"Shyam","12"},
//							   {"Rahul","123"},
//							   {"Amay","12"}
//		};
		String path="D:\\Git Repo New\\FrameWorkTemplate_R00\\TestData\\LoginTestData.xlsx";
	
		XLUtility u=new XLUtility(path);
		int totalrow=u.getRow("USERNAMEPASSWORD");
		int totalcol=u.getCell("USERNAMEPASSWORD", totalrow);
		System.out.println( "count of row : "+totalrow +" and col :"+totalcol);
		logger.info("count recived");
		String LoginData[][]= new String[totalrow][totalcol];
		logger.info("Array created");
		
		for(int i=1;i<totalrow;i++)
		{
			for(int j=0;j<totalcol;j++)
			{
				LoginData[i-1][j]=u.readCellData("USERNAMEPASSWORD", i, j);
				logger.info(i +"ROW count");
			}
		}
////		
		
		return LoginData;
//		
//	}
	
	}
}
