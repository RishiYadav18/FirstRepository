package com.evs.vtiger.pages.marketing.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.utility.WdUtil;

public class LeadsLandingPage {
	
private WdUtil webUtil;

public LeadsLandingPage(WdUtil webUtil) {
	this.webUtil=webUtil;
	PageFactory.initElements(webUtil.getDriver(),this);
}
	@FindBy(xpath = "//img[contains(@title,'Create Lead')]")
	private WebElement weCreateLeads;

	
	public void clickCreateLeadBtn() {
	webUtil.jsClick(weCreateLeads);
	 

		
	}
}
