package com.evs.vtiger.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.or.login.OrLogin;
import com.evs.vtiger.utility.WdUtil;

public class LoginPage extends OrLogin {

	@FindBy(name = "user_name")
	private WebElement weUserName;

	@FindBy(name = "user_password")
	private WebElement wePassword;

	@FindBy(xpath = "//select[@name='login_theme']")
	private WebElement weLoginThame;

	@FindBy(name = "Login")
	private WebElement loginBtn;

	private WdUtil webUtil;

	public LoginPage(WdUtil webUtil) {
		this.webUtil = webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}

	public void validLogin() {
		String url = webUtil.getPropObj().getProperty("Url");
		webUtil.getDriver().get(url);
		String userName = webUtil.getPropObj().getProperty("UserName");
		String pwd = webUtil.getPropObj().getProperty("Password");
		String cTheme=webUtil.getPropObj().getProperty("colourTheme");
		webUtil.clean(weUserName);
		webUtil.jsSandkeys(userName, weUserName);
		webUtil.clean(wePassword);
		webUtil.input(pwd, wePassword);
		webUtil.selectByVisibleText(cTheme, weLoginThame);
		webUtil.jsClick(loginBtn);

	}

	public void invalidLogin() {

		String url = webUtil.getPropObj().getProperty("Url");
		webUtil.getDriver().get(url);
		String userName = webUtil.getPropObj().getProperty("UserName");
		String pwd = webUtil.getPropObj().getProperty("Password");
		webUtil.jsSandkeys(userName, weUserName);
		webUtil.selectByVisibleText("bluelagoon", weLoginThame);
		webUtil.jsClick(loginBtn);

	}

}
