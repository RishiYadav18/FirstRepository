package com.evs.vtiger.pages.marketing.leads;

import java.util.Map;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.or.leads.OrDeleteLeads;
import com.evs.vtiger.utility.WdUtil;


public class VerifyDeleteNewLeads extends OrDeleteLeads{
	private WdUtil webUtil;
	
public	VerifyDeleteNewLeads(WdUtil webUtil){
		this.webUtil= webUtil;
	}
	public void verifyDeleteLeads(String PopUpInnerText) {
		webUtil.jsClick(selAll);
		webUtil.jsClick(commonDeletBtn);
		webUtil.popUpAccept(PopUpInnerText);
		System.out.println("Leads Element is deleted : ");
		
	}
}
