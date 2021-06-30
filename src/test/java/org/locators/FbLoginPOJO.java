package org.locators;

import java.util.List;

import org.functionallib.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPOJO extends Baseclass {
	
	public FbLoginPOJO() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="email")
	private WebElement txtEmail;
	
	@FindBy(id="pass")
	private WebElement txtPassword;
	
	@FindBy(name="login")
	private List <WebElement> btnLogin;
	
	@FindBy(xpath="//a[text()='Create New Account']")
	private WebElement btnNewAccount;

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public List<WebElement> getBtnLogin() {
		return btnLogin;
	}

	public WebElement getBtnNewAccount() {
		return btnNewAccount;
	}


	
	

}
