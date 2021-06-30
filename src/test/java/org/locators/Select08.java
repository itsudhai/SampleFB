package org.locators;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.functionallib.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Select08 extends Baseclass {

	public static void main(String[] args) throws Exception {

		chromeBrower();
		maxWindow();
		driver.navigate().to("http://adactinhotelapp.com/");

		WebElement uName = driver.findElement(By.id("username"));
		uName.sendKeys("daniel001");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("temp001");
		WebElement lo = driver.findElement(By.id("login"));
		lo.click();

		WebElement loc = driver.findElement(By.id("location"));
		Select s = new Select(loc);
		s.selectByIndex(1);
		WebElement hotel = driver.findElement(By.id("hotels"));
		Select s1 = new Select(hotel);
		s1.selectByVisibleText("Hotel Hervey");
		WebElement room = driver.findElement(By.id("room_type"));
		Select s2 = new Select(room);
		s2.selectByIndex(3);

		WebElement sub = driver.findElement(By.id("Submit"));
		sub.click();

		WebElement radio = driver.findElement(By.id("radiobutton_0"));
		radio.click();
		WebElement con = driver.findElement(By.id("continue"));
		con.click();

		// === details fill up===

		WebElement fName = driver.findElement(By.id("first_name"));
		fName.sendKeys("Daniel");
		WebElement lName = driver.findElement(By.id("last_name"));
		lName.sendKeys("Daniel");
		WebElement add = driver.findElement(By.id("address"));
		add.sendKeys("Daniel House");
		add.sendKeys(" Hillton");
		WebElement ccno = driver.findElement(By.id("cc_num"));
		ccno.sendKeys("0007893211258369");
		WebElement cctype = driver.findElement(By.id("cc_type"));
		Select s3 = new Select(cctype);
		s3.selectByVisibleText("Other");
		WebElement mon = driver.findElement(By.id("cc_exp_month"));
		Select s4 = new Select(mon);
		s4.selectByIndex(1);
		WebElement yr = driver.findElement(By.id("cc_exp_year"));
		Select s5 = new Select(yr);
		s5.selectByVisibleText("2022");
		WebElement ccv = driver.findElement(By.id("cc_cvv"));
		ccv.sendKeys("123");
		WebElement book = driver.findElement(By.id("book_now"));
		book.click();

		Thread.sleep(10000);

		WebElement odr = driver.findElement(By.id("order_no"));

		String od = odr.getAttribute("value");
		System.out.println("Booking Order No :" + od);

		// === scroll down ==

		WebElement iti = driver.findElement(By.id("my_itinerary"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", iti);
		// js.executeScript("scrollBy(0,750);");

		// ========= take screenshot========

		TakesScreenshot tk = (TakesScreenshot) driver;

		File temp = tk.getScreenshotAs(OutputType.FILE);
		File perm = new File("./screenshot/screen.png");
		FileUtils.copyFile(temp, perm);

	}

}
