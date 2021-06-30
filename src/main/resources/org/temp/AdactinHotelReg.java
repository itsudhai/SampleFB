package org.adactinstepdef;

import java.io.IOException;
import org.functionallib.Baseclass;
import org.junit.Assert;
import io.cucumber.java.en.*;

public class AdactinHotelReg extends Baseclass {
	@Given("User is in enter Adactin login page")
	public void user_is_in_enter_Adactin_login_page() {
		chromeBrower();
		maxWindow();
		driver.navigate().to("http://adactinhotelapp.com/");

	}

	@When("User enter Valid username and valid password")
	public void user_enter_Valid_username_and_valid_password() {
		findTheElementToFill("id", "username", "daniel001");
		findTheElementToFill("id", "password", "temp001");

	}

	@When("User to click login button")
	public void user_to_click_login_button() {
		findTheElement("id", "login");
		buttonClick(element);

	}

	@When("User navigate to Search hotel page")
	public void user_navigate_to_Search_hotel_page() {

		String title = driver.getTitle();
		Assert.assertTrue("Current Page Title", title.contains("Search"));
		System.out.println(title + "\n");

	}

	@When("User to select Location from Drop down")
	public void user_to_select_Location_from_Drop_down() {
		findTheElement("id", "location");
		selectByIdx(1);

	}

	@When("User to select Hotel from Drop down")
	public void user_to_select_Hotel_from_Drop_down() {
		findTheElement("id", "hotels");
		selectByVisTxt("Hotel Hervey");

	}

	@When("User to select Room type from Drop down")
	public void user_to_select_Room_type_from_Drop_down() {
		findTheElement("id", "room_type");
		selectBy("Super Deluxe");

	}

	@When("User to select Number of Rooms from Drop down")
	public void user_to_select_Number_of_Rooms_from_Drop_down() {
		findTheElement("id", "room_nos");
		selectByIdx(1);

	}

	@When("User to select Check In Date")
	public void user_to_select_Check_In_Date() {
		findTheElement("id", "datepick_in");
		jseInsert("26/06/2021", element);
	}

	@When("User to select Check Out Date")
	public void user_to_select_Check_Out_Date() {
		findTheElement("id", "datepick_out");
		jseInsert("27/06/2021", element);

	}

	@When("User to select Adults per Room from Drop down")
	public void user_to_select_Adults_per_Room_from_Drop_down() {
		findTheElement("id", "adult_room");
		selectByIdx(1);

	}

	@When("User to select Children per Room from Drop down")
	public void user_to_select_Children_per_Room_from_Drop_down() {
		findTheElement("id", "child_room");
		selectByIdx(0);
	}

	@When("User to click Search button")
	public void user_to_click_Search_button() {
		findTheElement("id", "Submit");
		buttonClick(element);

	}

	@When("User navigate to Select Hotel page")
	public void user_navigate_to_Select_Hotel_page() {
		String title = driver.getTitle();
		Assert.assertTrue("Current Page Title", title.contains("Select"));
		System.out.println(title + "\n");

	}

	@When("User to select the searched hotel radio button")
	public void user_to_select_the_searched_hotel_radio_button() {
		findTheElement("id", "radiobutton_0");
		buttonClick(element);
	}

	@When("User to click Continue button")
	public void user_to_click_Continue_button() {
		findTheElement("id", "continue");
		buttonClick(element);

	}

	@When("User navigate to Book A Hotel page")
	public void user_navigate_to_Book_A_Hotel_page() {
		String title = driver.getTitle();
		Assert.assertTrue("Current Page Title", title.contains("Book"));
		System.out.println(title + "\n");

	}

	@When("User to enter First Name and Last Name")
	public void user_to_enter_First_Name_and_Last_Name() {
		findTheElementToFill("id", "first_name", "Daniel");
		findTheElement("id", "last_name");
		jseInsert("UK", element);
	}

	@When("User to enter Billing Address")
	public void user_to_enter_Billing_Address() {
		findTheElementToFill("id", "address", "Daniel House\n" + "Hilton");

	}

	@When("User to enter Credit Card No and Should be16 digit")
	public void user_to_enter_Credit_Card_No_and_Should_be16_digit() {
		findTheElementToFill("id", "cc_num", "1234567891234567");

	}

	@When("User to select Credit Card Type")
	
	public void user_to_select_Credit_Card_Type() {
		findTheElement("id", "cc_type");
		selectByIdx(2);
	}

	@When("User to select Expiry Date by Month and Year")
	public void user_to_select_Expiry_Date_by_Month_and_Year() {
		findTheElement("id", "cc_exp_month");
		selectByIdx(5);
		findTheElement("id", "cc_exp_year");
		selectByVisTxt("2022");

	}

	@When("User to enter CVV Number")
	public void user_to_enter_CVV_Number() {
		findTheElementToFill("id", "cc_cvv","123");
		
	}

	@When("User click Book Now button")
	public void user_click_Book_Now_button() throws Throwable {
		findTheElement("id", "book_now");
		buttonClick(element);
		sleep(10000);

	}

	@Then("User navigate to Booking Confirmation page")
	public void user_navigate_to_Booking_Confirmation_page() {
		String title = driver.getTitle();
		Assert.assertTrue("Current Page Title", title.contains("Booking"));
		System.out.println(title + "\n");

	}

	@Then("User get the Order No")
	public void user_get_the_Order_No() throws IOException {
		findTheElement("id", "order_no");
		String order_no = element.getAttribute("value");
		System.out.println("Booking Order No: "+order_no);
		jseScrollUp(element);
		takeScreenShot("date");

	}

}
