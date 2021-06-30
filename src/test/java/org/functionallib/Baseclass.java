package org.functionallib;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;
	public static WebElement element;
	public static Select s;

	public static void chromeBrower() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void firefoxBrower() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public static void ieBrower() {

		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	public static void sleep(int msec) throws InterruptedException  {
		Thread.sleep(msec);
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void getTheTitle() {
		driver.getTitle();
	}

	public static String getTheCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public static void closeWindow() {
		driver.close();
	}

	public static void quitBrower() {
		driver.quit();
	}

	public static void findTheElement(String locater, String key) {
		switch (locater) {

		case "id":
			element = driver.findElement(By.id(key));
			break;
		case "name":
			element = driver.findElement(By.name(key));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(key));
			break;
		case "classname":
			element = driver.findElement(By.className(key));
			break;
		case "css":
			element = driver.findElement(By.cssSelector(key));
			break;
		case "tag":
			element = driver.findElement(By.tagName(key));
			break;
		case "partialLink":
			element = driver.findElement(By.partialLinkText(key));
			break;
		case "linkText":
			element = driver.findElement(By.linkText(key));
			break;
		}
	}

	public static void findTheElementToFill(String locater, String key, String value) {
		switch (locater) {

		case "id":
			element = driver.findElement(By.id(key));
			element.sendKeys(value);
			break;
		case "name":
			element = driver.findElement(By.name(key));
			element.sendKeys(value);
			break;
		case "xpath":
			element = driver.findElement(By.xpath(key));
			element.sendKeys(value);
			break;
		case "classname":
			element = driver.findElement(By.className(key));
			element.sendKeys(value);
			break;
		case "css":
			element = driver.findElement(By.cssSelector(key));
			element.sendKeys(value);
			break;
		case "tag":
			element = driver.findElement(By.tagName(key));
			element.sendKeys(value);
			break;
		case "partialLink":
			element = driver.findElement(By.partialLinkText(key));
			element.sendKeys(value);
			break;
		case "linkText":
			element = driver.findElement(By.linkText(key));
			element.sendKeys(value);
			break;
		}
	}

	public static void fillTheTextBox(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void buttonClick(WebElement element) {
		element.click();
	}

	public static void takeScreenShot(String nameOrdateOrcurrentMilliSec) throws IOException {

		TakesScreenshot tk = (TakesScreenshot) driver;
		File temp = tk.getScreenshotAs(OutputType.FILE);

		switch (nameOrdateOrcurrentMilliSec) {
		case "name":
			Scanner s = new Scanner(System.in);
			File perm = new File("./ScreenShots/Screenshot_" + s + ".png");
			FileHandler.copy(temp, perm);
			break;
		case "date":
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyhhmmss");
			String dd = sdf.format(d);

			File perm1 = new File("./ScreenShots/Screenshot_" + dd + ".png");
			FileHandler.copy(temp, perm1);
			break;
		case "currentMilliSec":
			long dd1 = System.currentTimeMillis();

			File perm2 = new File("./ScreenShots/Screenshot_" + dd1 + ".png");
			FileHandler.copy(temp, perm2);
			break;
		}

	}

	// Robot Keyboard

	public static void RobotKey(int keyevent) throws AWTException {
		Robot r = new Robot();
		r.keyPress(keyevent);
		r.keyRelease(keyevent);

	}

	// Action

	public static void axnDoubleClick() {
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}

	public static void axnContextClick() {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}

	public static void axnMove2Element(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();

	}

	public static void axnDragAndDrop(WebElement Drag, WebElement Drop) {
		Actions a = new Actions(driver);
		a.dragAndDrop(Drag, Drop).perform();
	}

	public static void axnClick(WebElement e) {
		Actions a = new Actions(driver);
		a.click(e).perform();
	}

	// Alert

	public static void alertAccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public static void alertDismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	public static void alertTextFill(String Text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(Text);
		al.accept();

	}

	public static void alertGetText() {
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		System.out.println(text);
	}

	// =============java script executor==============

	public static void launchJseUrl(String url) {
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='" + url + "'");
	}

	public static void jseScrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void jseScrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", element);
	}

	public static void jseInsert(String value, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// String st= arguments[0].setAttribute('value',value);
		js.executeScript("arguments[0].setAttribute('value','" + value + "');", element);

	}

	public static void jseScrollBy(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollBy(x,y);");
	}

	// ======Frame switch===============

	public static void switch2Frame(String way) {
		driver.switchTo().frame(way);
		// if(Integer.parseInt(way).)
	}

	public static void switch2FrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public static void switch2FrameByWebElement(WebElement e) {
		driver.switchTo().frame(e);
	}

	// DropDown Selection

	public static void selectBy(String value) {
		s= new Select(element);
		s.selectByValue(value);

	}
	public static void selectByIdx(int index) {
		s = new Select(element);
		s.selectByIndex(index);

	}
	public static void selectByVisTxt(String value) {
		s = new Select(element);
		s.selectByVisibleText(value);

	}

	public static void selByIndex(WebElement element,int value) {
		s= new Select(element);
		s.selectByIndex(value);

	}
	public static void selByValue(WebElement element,String value) {
		s= new Select(element);
		s.selectByValue(value);

	}
	public static void selByVisTxt(WebElement element,String value) {
		s= new Select(element);
		s.selectByVisibleText(value);

	}


}
