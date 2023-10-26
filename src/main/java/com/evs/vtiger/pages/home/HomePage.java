package com.evs.vtiger.pages.home;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.or.home.OrHomePage;
import com.evs.vtiger.utility.WdUtil;


public class HomePage extends OrHomePage{
	
	private WdUtil webUtil;
	public HomePage(WdUtil webUtil) {
		this.webUtil=webUtil;
		PageFactory.initElements(webUtil.getDriver(), this);
	}
	@FindBy(xpath = "//td[@class='tabUnSelected']//a[text()='Marketing']")
	private WebElement weActMouseOver;
	
	@FindBy(xpath = "(//a[text()='Leads'])[3]")
	private WebElement weClickOnLeads;
	
	@FindBy(xpath = "(//a[text()='Accounts'])[3]")
	private WebElement weAccounts;
	
	@FindBy(xpath = "(//a[text()='Campaigns'])[3]")
	private WebElement weCampaigns;
	
	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Contacts']")
	private WebElement weContacts;
	
	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Webmail']")
	private WebElement weWebMail;
	
	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Calendar']")
	private WebElement weCalender;
	
	@FindBy(xpath = "//td[@class='level2UnSelTab']//a[text()='Documents']")
	private WebElement weDocuments;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement weLogOut;
	
	public void mouseOverMarketing() {
		webUtil.jsMouseOver(weActMouseOver);
		
	  }
		public void gotoMarketingLeads() {
			 mouseOverMarketing();
			webUtil.jsClick(weClickOnLeads);

			 
		}
	
		public void gotoMarketingAccounts() {
			 mouseOverMarketing();
			webUtil.click(weAccounts);
		}
	
	public void gotoCampaings() {
		 mouseOverMarketing();
	webUtil.click(weCampaigns);
	}
	public void gotoContacts() {
		 mouseOverMarketing();
		webUtil.click(weContacts);
	}
						
	public void gotoWebmail	() {
		 mouseOverMarketing();
		 webUtil.click(weWebMail);
	}
			
	public void gotoCalendar() {
		 mouseOverMarketing();
		 webUtil.click(weCalender);
	}
	
	public void gotoDocuments() {
		 mouseOverMarketing();
		 webUtil.click(weDocuments);

	
	}
	public void verifyHomePage(String expInnerText) {
		webUtil.verifyInnerText(weActMouseOver, expInnerText);
	}
	
		
	
	public void logOut() {
webUtil.click(weLogOut);
		
	}

		
	
	
					
					
	
}
