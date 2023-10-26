package com.evs.vtiger.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WdUtil {

	private static final List<WebElement> randopt = null;
	private WebDriver driver;
	private Properties propObj;

	public WdUtil() {
		try {
			InputStream fs = new FileInputStream("src\\test\\resources\\config.properties");
			propObj = new Properties();
			propObj.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getPropObj() {
		return propObj;
	}

	public void clean(WebElement element) {
		element.clear();
	}

	public WebDriver launchBrowser(String Browser) {
		if (Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else
			System.out.println(Browser + " Browser name is wrong . Please chacke it - ");
		return driver;
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public WebDriver getDriver() {

		return driver;

	}

	public void close() {
		driver.close();
	}

	public void closeAllWindow() {
		driver.quit();
	}

	////////////////// WebElement ////////////////////////

	public void click(WebElement we) {
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				we.click();
				System.out.println(" Element is clicked by WebElement ");
			} else
				System.out.println(" Element is not Visible");
		} else
			System.out.println(" Element is not clicked ");
	}

	public void input(String inputvalue, WebElement we) {
		we.clear();
		if (we.isEnabled()) {
			if (we.isDisplayed()) {
				we.sendKeys(inputvalue);
				System.out.println("value input successfully by WebElement ");
			} else
				System.out.println("Element is not Displayed ");
		} else
			System.out.println("Element is not input ");
	}

	public int getHight(String elementname, WebElement we) {
		int hig = 0;
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				hig = we.getSize().getHeight();
				System.out.println(elementname + " Element hight is : " + hig);
			} else
				System.out.println(elementname + " Element is not visible");
		} else
			System.out.println(elementname + " Element is not displayed");

		return hig;
	}

	public int getWidth(String elementname, WebElement we) {
		int wid = 0;
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				wid = we.getSize().getWidth();
				System.out.println(elementname + " Element Width is : " + wid);
			} else
				System.out.println(elementname + " Element is  not visible");
		} else
			System.out.println(elementname + " Element is not displayed");

		return wid;
	}

	public int getXlocation(String elementname, WebElement we) {
		int x = 0;
		if (we.isEnabled()) {
			if (we.isDisplayed()) {
				x = we.getLocation().getX();
				System.out.println(elementname + " Element location of X : " + x);
			} else
				System.out.println(elementname + " Element is not display");
		} else
			System.out.println(elementname + " Element is not Enable");
		return x;
	}

	public int getYlocation(String elementname, WebElement we) {
		int y = 0;
		if (we.isEnabled()) {
			if (we.isDisplayed()) {
				y = we.getLocation().getY();
				System.out.println(elementname + " Element location of Y :  " + y);
			} else
				System.out.println(elementname + " Element is  not display");
		} else
			System.out.println(elementname + " Element is not showing on Enable");
		return y;
	}

	public String getInerText(WebElement we) {
		String text = null;
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				text = we.getText();
				System.out.println("InerText of Element : " + text);
			} else
				System.out.println("Element is not Enable");
		} else
			System.out.println("Element is not displayed");
		return text;
	}

	public String getAtrbtText(WebElement we, String attributeName) {
		String attributeValue = null;
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				attributeValue = we.getAttribute(attributeName);
				System.out.println("InerText of Element : " + attributeValue);
			} else
				System.out.println("Element is not Enable");
		} else
			System.out.println("Element is not displayed");
		return attributeValue;
	}

	public String getTagName(String elementname, WebElement we) {
		String tgn = null;
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				tgn = we.getTagName();
				System.out.println("TagName of " + elementname + " : " + tgn);
			} else
				System.out.println("Element is not Enable");
		} else
			System.out.println("Element of tagname is not Displayed ");
		return tgn;
	}

	///////////////////// DropDown ////////////////////

	public void selectByVisibleText(String Text, WebElement we) {
		Select se = new Select(we);

		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.selectByVisibleText(Text);
				System.out.println(Text + " is selected by visibleText ");
			} else
				System.out.println("DropDown Element is not enable : ");
		} else {
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void selectByIndex(int Number, WebElement we) {
		Select se = new Select(we);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.selectByIndex(Number);
				System.out.println(Number + "Element is selected by index ");
			} else {
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void selectByvalue(String value, WebElement we) {
		Select se = new Select(we);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.selectByValue(value);
				System.out.println(value + "Element is selected by value ");
			} else {
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void deselectByvalue(String deselectbyvalue, WebElement we) {
		Select se = new Select(we);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.deselectByValue(deselectbyvalue);
				System.out.println(deselectbyvalue + "Element is deselected by value ");
			} else {
				System.out.println("DropDown Element is not enable : ");
			}
		} else {
			System.out.println("DropDown Element is not Displayed : ");
		}
	}

	public void deselectByIndex(int deselectbyindex, WebElement we) {
		Select se = new Select(we);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.deselectByIndex(deselectbyindex);
				System.out.println(deselectbyindex + "Element is deselected by index ");
			} else
				System.out.println("DropDown Element is not enable : ");
		} else
			System.out.println("DropDown Element is not Displayed : ");
	}

	public void deselectAll(WebElement we) {
		Select se = new Select(we);
		if (we.isDisplayed()) {
			if (we.isEnabled()) {
				se.deselectAll();
				System.out.println(" All Element is deselected  ");
			} else
				System.out.println("DropDown Element is not enable : ");
		} else
			System.out.println("DropDown Element is not Displayed : ");
	}

	public boolean selected(WebElement we) {
		boolean slc = we.isSelected();
		System.out.println(we + "Element is selected ");
		return slc;
	}

	public boolean displayed(WebElement we) {
		boolean displ = we.isDisplayed();
		System.out.println(we + "Element is displayed ");
		return displ;
	}

	public boolean enabled(WebElement we) {
		boolean enalb = we.isEnabled();
		System.out.println(we + "Element is Enabled ");
		return enalb;
	}

	//////////////////// Actions /////////////////

	public void actionMouseOver(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.moveToElement(we).build().perform();
					System.out.println("Element is clicked by Actions : ");
				}

			} else
				System.out.println("Element is not Enable :");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	public void actionClickAndHoldd(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			act.clickAndHold(we).build().perform();
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.moveToElement(we).build().perform();
					System.out.println("Element is clicked and hold by actions");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not Display ");
		} else
			System.out.println("Element is not find on HTML Page");

	}

	public void actionInput(String xyz, WebElement we) {
		Actions act = new Actions(driver);
		we.clear();
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.sendKeys(we, xyz).build().perform();
					System.out.println("Value input successfully by action");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not display : ");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	public void actionClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.click().build().perform();
					System.out.println("Element is clicked by Actions ");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not displayed : ");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	public void actionDoudleClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.doubleClick(we).build().perform();
					System.out.println("Double click on element is successfully ");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not displayed : ");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	public void actionRightClick(WebElement we) {
		Actions act = new Actions(driver);
		if (we.getSize().getHeight() > 0 && we.getSize().getWidth() > 0) {
			if (we.isDisplayed()) {
				if (we.isEnabled()) {
					act.contextClick(we).build().perform();
					System.out.println("Right click on element is successfully");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not displayed : ");
		} else
			System.out.println("Element is not find on HTML Page");

	}

	public void actiondragAndDrop1(WebElement we1, WebElement ww2) {
		Actions act = new Actions(driver);
		if (we1.getSize().getHeight() > 0 && we1.getSize().getWidth() > 0) {
			if (we1.isDisplayed()) {
				if (we1.isEnabled()) {
					act.dragAndDrop(we1, ww2).build().perform();
					System.out.println("Element is drag and drop successfully by drag and drop ");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not displayed : ");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	public void actiondragAndDrop2(WebElement we1, WebElement ww2) {
		Actions act = new Actions(driver);
		if (we1.getSize().getHeight() > 0 && we1.getSize().getWidth() > 0) {
			if (we1.isDisplayed()) {
				if (we1.isEnabled()) {
					act.clickAndHold(we1).moveToElement(ww2).release().build().perform();
					System.out.println("Element drag and drop and drop by move to element");
				} else
					System.out.println("Element is not Enable :");
			} else
				System.out.println("Element is not displayed : ");
		} else
			System.out.println("Element is not find on HTML Page");
	}

	//////////////////////// Javascript /////////////////////////

	public void jsClick(WebElement we) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", we);
		System.out.println("Element is clicked by javascript ");
	}

	public void jsSandkeys(String inputvalue, WebElement we) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value=" + "'" + inputvalue + "'", we);
		System.out.println("Value is inputed by javascript ");
	}

	public void jsMouseOver(WebElement we) {

		String strJs = "var element = argument[0];" + "var mouseEventObj=document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );" + "element.dispatchEvent(mouseEventObj);";
		try {
			String mouseOverScript = "if(document.createEvent){var evObj =document.createEvent('MouseEvents');"
					+ "evObj.initEvent('mouseOver' ,true, false);arguments[0].dispatchEvent(evObj);}"
					+ "else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(strJs, we);
		} catch (Exception e) {
			System.out.println("javaScript MouseOver is not click ");
		}
	}

	//////////////////////////// Wait /////////////////////////

	public void implicitWait(int timeInSecound) {

		driver.manage().timeouts().implicitlyWait(timeInSecound, TimeUnit.SECONDS);

	}

	public void staticWait(int timeInSecound) {
		int secound = timeInSecound * 1000;
		try {
			Thread.sleep(secound);
			System.out.println("Static wait is puted ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void enabledElementwait(WebElement we, Duration timeInSecound) {
		if (we.equals(we.isEnabled())) {
			WebDriverWait expli = new WebDriverWait(driver, timeInSecound);
			expli.until(ExpectedConditions.elementToBeClickable(we));
		} else
			System.out.println("Element is not Enabled");
	}

	public void selectedElementWait(WebElement we, Duration timeInSecound) {
		WebDriverWait expli = new WebDriverWait(driver, timeInSecound);
		if (we.equals(we.isSelected())) {
			expli.until(ExpectedConditions.elementToBeSelected(we));
		} else {
			System.out.println("Element is not selected");
		}
	}

	public void visibleElementWait(WebElement we, Duration timeInSecound) {
		WebDriverWait expli = new WebDriverWait(driver, timeInSecound);
		if (we.equals(we.isDisplayed())) {
			expli.until(ExpectedConditions.visibilityOfAllElements(we));
		} else {
			System.out.println("Element is not visible");
		}
	}

	/////////////////////// Alert //////////////////////

	public void popUpAccept(String popInerText) {
		String text = driver.switchTo().alert().getText();
		if (text.equalsIgnoreCase(popInerText)) {
			System.out.println(text);
			driver.switchTo().alert().accept();
		}

	}

	public void popUpdismiss(String popInerText) {
		String text = driver.switchTo().alert().getText();
		if (text.equalsIgnoreCase(popInerText)) {
			System.out.println(text);
			driver.switchTo().alert().dismiss();
		}
	}

	public String popUpGetText() {

		String text = driver.switchTo().alert().getText();
		return text;
	}

	public void popUpSendKeys(String inputvale) {

		driver.switchTo().alert().sendKeys(inputvale);
	}

	/////////////////////// iFrame /////////////////////////

	public WebDriver switchToFrameByIdOrName(String IdorNameValue) {
		WebDriver as = driver.switchTo().frame(IdorNameValue);
		return as;
	}

	public WebDriver switchToFrameByWebElement(WebElement we) {
		WebDriver ss = driver.switchTo().frame(we);
		return ss;
	}

	public WebDriver switchToFrameByIndex(int frameNumber) {
		WebDriver cd = driver.switchTo().frame(frameNumber);
		return cd;
	}

	public WebDriver switchToParentFrame() {
		WebDriver we = driver.switchTo().parentFrame();
		return we;
	}

	public WebDriver switchToMainFrame() {
		WebDriver we = driver.switchTo().defaultContent();
		return we;
	}

	///////////////////// Window Handle ////////////////

	public void switchToWindowsByTitle(String title) {
		Set<String> window = driver.getWindowHandles();
		for (String multipleWindow : window) {
			driver.switchTo().window(multipleWindow);
			String tit = driver.getTitle();
			System.out.println(tit);
			if (tit.equalsIgnoreCase(title)) {

			}
		}
	}

	public void switchToWindowsByURL() {
		Set<String> window = driver.getWindowHandles();
		System.out.println(window);
		for (String multipleWindow : window) {
			driver.switchTo().window(multipleWindow);
			String url = driver.getCurrentUrl();
			System.out.println(url);
		}
	}

	public String switchToWindowByTitle() {
		String window = driver.getWindowHandle();
		driver.switchTo().window(window);
		String title = driver.getTitle();
		System.out.println(title);
		return window;

	}

	public String switchToWindowByURL() {
		String window = driver.getWindowHandle();
		driver.switchTo().window(window);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		return window;

	}

	public WebElement keys(String keysname, WebElement we) {
		if (keysname.equalsIgnoreCase("F5")) {
			we.sendKeys(Keys.F5);
		} else if (keysname.equalsIgnoreCase("Enter")) {
			we.sendKeys(Keys.ENTER);
		} else if (keysname.equalsIgnoreCase("Arrow Down")) {
			we.sendKeys(Keys.ARROW_DOWN);
		} else if (keysname.equalsIgnoreCase("Arrow Up")) {
			we.sendKeys(Keys.ARROW_UP);
		} else if (keysname.equalsIgnoreCase("Arrow Left")) {
			we.sendKeys(Keys.ARROW_LEFT);
		} else if (keysname.equalsIgnoreCase("Arrow Right")) {
			we.sendKeys(Keys.ARROW_RIGHT);
		}

		return we;

	}

	/////////////// Verifycation Code //////////////

	public void verifyInnerText(WebElement we, String exptInnertext) {
		String actualText = getInerText(we);
		if (actualText.equalsIgnoreCase(exptInnertext)) {
			Reporter.log("Validation Passed. Where actual -" + actualText + " & Expected -" + exptInnertext);
		} else {
			System.out.println("Validation Failed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualText, exptInnertext);
		}
	}

	public void verifyInnerTextContains(WebElement we, String exptInnertext) {
		String actualText = getInerText(we);
		if (actualText.contains(exptInnertext)) {
			Reporter.log("Validation Passed. Where actual -" + actualText + " & Expected -" + exptInnertext);
		} else {
			System.out.println("Validation Failed. Where actual -" + actualText + " & Expected -" + exptInnertext);
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualText, exptInnertext);
		}
	}

	public void verifyAttribute(WebElement we, String exptAttributeValue, String attributeName) {
		String actualAttributeValue = getAtrbtText(we, attributeName);
		if (actualAttributeValue.contains(exptAttributeValue)) {
			System.out.println(
					"Validation Passed. Where actual -" + actualAttributeValue + " & Expected -" + exptAttributeValue);
		} else {
			System.out.println(
					"Validation Failed. Where actual -" + actualAttributeValue + " & Expected -" + exptAttributeValue);
		}
	}

	public void verifyEnabled(WebElement we) {
		boolean actualEnabled = enabled(we);
		if (actualEnabled) {
			System.out.println("Validation Passed. Element is Enabled ");
		} else {
			System.out.println("Validation Passed. Element is Disabled ");
		}
	}

	public void verifyChecked(WebElement we) {
		boolean actualChecked = selected(we);
		if (actualChecked) {
			System.out.println("Validation Passed. Check box checked ");
		} else {
			System.out.println("Validation Passed. Check box unchecked ");
		}
	}

	public void verifyUnChecked(WebElement we) {
		boolean actualChecked = selected(we);
		if (actualChecked == false) {
			System.out.println("Validation Passed. Check box unchecked ");
		} else {
			System.out.println("Validation Passed. Check box checked ");
		}
	}

	public String verifyTitle(String expTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expTitle)) {
			System.out.println(
					"Validation passed .Where actual Title is : " + actualTitle + " & Expected title is : " + expTitle);
		} else
			System.out.println(
					"Validation passed .Where actual Title is : " + actualTitle + " & Expected title is : " + expTitle);
		return actualTitle;
	}

	public void verifyElementVisible(WebElement we) {

		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			System.out.println("Validation passed .Element is visible : ");
		} else {
			System.out.println("Validation passed .Element is invisible : ");
		}

	}

	public void verifyElementInVisible(WebElement we) {

		if (!we.isDisplayed() & we.getSize().getHeight() == 0 & we.getSize().getWidth() == 0) {
			System.out.println("Validation passed .Element is invisible : ");
		} else {
			System.out.println("Validation passed .Element is visible : ");

		}
	}

	/////////////////////// Random Number////////////////////////////////////////

	public int selectRandomNumber(int minNum, int maxNum) {

		int random = (int) (Math.random() * (maxNum - minNum + 1) + minNum);
		System.out.println(random);

		return random;

		////////////////////// Random options//////////////
	}

	public List<WebElement> selectRandomOptions(WebElement we) {
		Select sel = new Select(we);
		List<WebElement> randopt = sel.getOptions();
		randopt.size();
		return randopt;
	}
	///////////// screenshort///////////////

	public void getScreenShort(String tcname) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File to = tss.getScreenshotAs(OutputType.FILE);
		File from = new File("ScreenShort/" + tcname + getCurrentTime() + ".png");
		try {
			Files.copy(from, to);
		} catch (IOException e) {

		}

	}

	public String getCurrentTime() {
		SimpleDateFormat samDattime = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
		Date dtobj = new Date(0);
		String date = samDattime.format(dtobj);

		return date;

	}

	////////////////// validation///////////////////

	public void ValidateInnerTextContains(WebElement we, String expInnertext) {
		String actualText = getInerText(we);
		if (actualText.contains(expInnertext)) {
			Reporter.log("Validation Passed.Where actual -" + actualText + "& Expected -" + expInnertext);
		} else {
			System.out.println("Validation Failed.Where actual -" + actualText + "& Expected -" + expInnertext);
			Assert.assertEquals(actualText, expInnertext);
		}

	}

	public void ValidateInnerText(WebElement we, String expInnerTxt) {
		String actual = getInerText(we);
		if (actual.contains(expInnerTxt)) {
			Reporter.log("Validation Passed.Where actual -" + actual + "& Expected -" + expInnerTxt);
		} else {
			System.out.println("Validation Failed.Where actual -" + actual + "& Expected -" + expInnerTxt);
			Assert.assertEquals(actual, expInnerTxt);
		}

	}

	public void validateAttribute(WebElement we, String exptAttributeValue, String attributeName) {
		String actualAttributeValue = getAtrbtText(we, attributeName);
		if (actualAttributeValue.contains(exptAttributeValue)) {
			Reporter.log(
					"Validation Passed.Where actual-" + actualAttributeValue + "& Expected -" + exptAttributeValue);
		} else {
			System.out.println(
					"Validation Failed.Where actual-" + actualAttributeValue + "& Expected -" + exptAttributeValue);
			Assert.assertEquals(actualAttributeValue, exptAttributeValue);
		}
	}

	public void validateElementIsEnabled(WebElement we) {
		boolean actualEnabled = enabled(we);
		if (actualEnabled == true)
			;
		Reporter.log("Validation passed.Element is Enabled");
		System.out.println("Validation passed.Element is Enabled");
		Assert.fail();
	}

	public void validateElementIsSelected(WebElement we) {
		boolean actualChacked = selected(we);
		if (actualChacked == true) {
			Reporter.log("Validation passed.Chack box checked");
		} else {
			getScreenShort("");
			System.out.println("Validation passed.Chack box unchecked");
			Assert.fail();
		}
	}

	public void validateUnchacked(WebElement we) {
		boolean actualChacked = selected(we);
		if (actualChacked == false) {
			Reporter.log("Validation passed.Chack box unchecked");
		} else {
			getScreenShort("");
			System.out.println("Validation passed.Chack box checked");
			Assert.fail();
		}
	}

	public String validateTitel(String expTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expTitle)) {
			System.out.println(
					"Validation Passed.Where actual Title is :" + actualTitle + "& Expected Title is :" + expTitle);
			Reporter.log("Validation Passed.Where actual Title -" + actualTitle + "& Expected Title -" + expTitle);
		} else {
			System.out
					.println("Validation Failed.Where actual Title -\"+ actualTitle+\"& Expected Title -\"+expTitle)");
			Assert.assertEquals(actualTitle, expTitle);
		}
		return actualTitle;
	}

	public void validateElementVisible(WebElement we) {
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			System.out.println("Validation passed.Element is Visible :");
			Reporter.log("Validation passed.Element is Visible :");
		} else {
			getScreenShort("");

			System.out.println("Validation failed.Element is inVisible :");
			Assert.fail();
		}
	}

	public void validateElementInVisible(WebElement we) {
		if (we.isDisplayed() & we.getSize().getHeight() > 0 & we.getSize().getWidth() > 0) {
			System.out.println("Validation passed.Element is InVisible :");
			Reporter.log("Validation passed.Element is InVisible :");
		} else {
			getScreenShort("");

			System.out.println("Validation failed.Element is Visible :");
			Assert.fail();
		}
	}

	public void validateCurrentUrl(String expUrl) {
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expUrl)) {
			Reporter.log("Validation Passed.Where actual -" + actualUrl + "& Expected-" + expUrl);

		} else {
			System.out.println("Verification failed.Where actual url is :" + actualUrl + "& Expected urlis :" + expUrl);
			Assert.assertEquals(actualUrl, expUrl);

		}

	}

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i = i * 2) {
			System.out.println(i);
		}
	}

}
