package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.Pom.LoginPage;

import graphql.PublicApi;

public class Baseclass{
	
	FileLibrary f=new FileLibrary();
	public WebDriver d;
	@BeforeSuite
	public void dataBaseConnection() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		 d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String URL = f.readDataFromPropertyFile("url");
		d.get(URL);
		Reporter.log("browser launched",true);
	}
		
		
	@BeforeMethod
	public void login() throws IOException {
			LoginPage lp=new LoginPage(d);
			String un = f.readDataFromPropertyFile("username");
			String pw = f.readDataFromPropertyFile("password");
			lp.getUntbx().sendKeys(un);
			lp.getPwtbx().sendKeys(pw);
			lp.getLgtbx().click();
			Reporter.log("logged in successfully",true);
			
		}
	@AfterMethod
	public void logout() {
		d.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out successfully",true);
	}
	
	@AfterClass
	public void closeBrowser() {
		d.close();
		Reporter.log("browser closed",true);
	}
	
	@AfterSuite
	public void dataDissconnection() {
	Reporter.log("database dissconnection",true);
	
	}
	
}
