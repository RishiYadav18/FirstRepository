package com.evs.vtiger.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.evs.vtiger.exceldata.ExcelDataUtil;
import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.login.LoginPage;
import com.evs.vtiger.utility.WdUtil;

public class Basetest {

	protected WdUtil webUtil;
	protected List<Map<String, String>> datamapList;
	protected ExcelDataUtil data;

	@BeforeClass(alwaysRun = true)
	@Parameters({ "Browser" })
	public void beforeTestCaseClass(String Browser) throws IOException {
		data = new ExcelDataUtil();
		webUtil = new WdUtil();
		// String brname = webUtil.getPropObj().getProperty("BrowserName");
		webUtil.launchBrowser(Browser);
	}

	@AfterClass
	public void afterTestCaseClass() {
		webUtil.close();
		webUtil.closeAllWindow();

	}

	@BeforeMethod(alwaysRun = true)
	public void beforTestcase(Method tm) throws IOException {
		String tmName = tm.getName();
		LoginPage loginPage = new LoginPage(webUtil);
		loginPage.validLogin();
		datamapList = data.getTestCaseData("src\\main\\resources\\TestCase.xlsx", tmName);

	}

	@AfterMethod
	public void afterTestCase(ITestResult tr, Method tm) {
		String tmName = tm.getName();
		if (tr.getStatus() == ITestResult.FAILURE) {
			webUtil.getScreenShort(tmName);
		}
		new HomePage(webUtil).logOut();
	}

}
