package com.Actitime.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//decleration
	@FindBy(id="")
	private WebElement untbx;
	
	
	@FindBy(name="")
	private WebElement pwtbx;
	
	@FindBy(xpath="")
	private WebElement lgtbx;
	
	//initillization
	public LoginPage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	//utillization
	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getLgtbx() {
		return lgtbx;
	}
	
	
	
}
