package com.Actitime.genericlibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Actitime.pom.HomePage;
import com.Actitime.pom.LoginPage;

public class Baseclass {
	

	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
		
	}
	
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("database disconnected",true);
	}

	
	public static WebDriver driver;
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		readDatafromPropertyFile data=new readDatafromPropertyFile();
		String Url = data.readdatafromProperty("url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(Url);
		Reporter.log("launch Browser",true);
		}
	
	@AfterClass
	public void closebrowser() {
		driver.close();
	}
	
	
	@BeforeMethod
	public void login() throws IOException {
		readDatafromPropertyFile data=new readDatafromPropertyFile();
		String url = data.readdatafromProperty("url");
		String UN = data.readdatafromProperty("username");
		String pw = data.readdatafromProperty("password");
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.logintoActitime(UN, pw);
		}
	
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.logout();
		
	}
	
}
