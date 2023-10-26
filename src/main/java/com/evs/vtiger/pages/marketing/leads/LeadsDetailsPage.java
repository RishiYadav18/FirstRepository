package com.evs.vtiger.pages.marketing.leads;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.pages.or.leads.OrDetailsPage;
import com.evs.vtiger.utility.WdUtil;


public class LeadsDetailsPage extends OrDetailsPage{

	private WdUtil webUtil;

	public LeadsDetailsPage(WdUtil webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(),this);
	}

	public void verifyLeadsDetailHeader(String expectedHeaderText) {

		webUtil.verifyInnerText(commonDetailsHeader, expectedHeaderText);

	}

	public void verifyLeadsHeader(String expectedHeaderText) {
		webUtil.verifyInnerText(detailHeaderLeads, expectedHeaderText);
	}

	public void verifyLastName(String expectedName) {
		webUtil.verifyInnerText(lastName, expectedName);
	}
	
	public void verifyCompanyName(String expectedName) {
		webUtil.verifyInnerText(companyName,expectedName);
	}


}
