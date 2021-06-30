package org.stepdefinition;

import org.functionallib.Baseclass;
import org.junit.Assert;
import org.locators.FbLoginPOJO;

import io.cucumber.java.en.*;

public class FbLoginStepDefinition extends Baseclass {
	public FbLoginPOJO fb;

	@Given("User is in Facebook Login Page")
	public void user_is_in_Facebook_Login_Page() {
		chromeBrower();
		launchUrl("https://facebook.com");
		maxWindow();
	}

	@When("User to enter {string} and {string}")
	public void user_to_enter_and(String user, String pwd) {
		fb = new FbLoginPOJO();
		fillTheTextBox(fb.getTxtEmail(), user);
		fillTheTextBox(fb.getTxtPassword(), pwd);
	}

	@When("User to Click the Login button")
	public void user_to_Click_the_Login_button() {
		FbLoginPOJO fb1 =new FbLoginPOJO();
		buttonClick(fb1.getBtnLogin().get(0));
	}

	@Then("User should be in invalid credential Page")
	public void user_should_be_in_invalid_credential_Page() {

		String url = getTheCurrentUrl();
		if (url.contains("token")) {
			Assert.assertTrue("Current Url", url.contains("token"));
		} else {
			Assert.assertTrue("Current Url", url.equals("https://www.facebook.com/"));
			
		}

	}

}
