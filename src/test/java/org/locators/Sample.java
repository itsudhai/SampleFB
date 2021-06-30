package org.locators;

import org.functionallib.Baseclass;
import org.openqa.selenium.WebElement;

public class Sample extends Baseclass {
	
	
	public static void main(String[] args) {
		
		chromeBrower();
		launchUrl("https://en-gb.facebook.com/");
		maxWindow();
		
		FbLoginPOJO login = new FbLoginPOJO();
		WebElement email = login.getTxtEmail();
		email.sendKeys("hello");
		fillTheTextBox(login.getTxtPassword(), "12341");
		
		buttonClick(login.getBtnLogin().get(0));
		
		/*findTheElementToFill("id", "email", "hello");
		findTheElement("id", "pass");
		fillTheTextBox(element, "hello");
		findTheElement("name", "login");
		buttonClick(element);
		*/
	}

}
