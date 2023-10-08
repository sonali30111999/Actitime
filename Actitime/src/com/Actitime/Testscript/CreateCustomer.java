package com.Actitime.Testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.Pom.HomePage;
import com.Actitime.Pom.TaskPage;

public class CreateCustomer extends Baseclass{ 
	

	@Test
	public void create() throws EncryptedDocumentException, IOException {
		
		HomePage hp=new HomePage(d);
		hp.getTasktab().click();
		TaskPage tp=new TaskPage(d);
		tp.getAddnew().click();
		tp.getNewcustomer().click();
		FileLibrary f=new FileLibrary();
		String custname=f.readDataFromExcel("Sheet1",2,1);
		tp.getCustname().sendKeys("custname");
		String Custdesp=f.readDataFromExcel("Sheet1",2,2);
		tp.getCustdesp().sendKeys("custdesp");
		tp.getCreatebtn().click();
}
}