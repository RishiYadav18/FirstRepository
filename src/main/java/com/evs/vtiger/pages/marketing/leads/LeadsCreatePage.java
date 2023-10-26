package com.evs.vtiger.pages.marketing.leads;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.or.leads.OrCreateLeads;
import com.evs.vtiger.utility.WdUtil;




public class LeadsCreatePage extends OrCreateLeads{
	
	private WdUtil webUtil;
	private  Map<String,String> mapdata;
	
	public LeadsCreatePage( WdUtil webUtil,Map<String,String> dataMap) {
		this.webUtil=webUtil;
		this.mapdata=dataMap;
		PageFactory.initElements(webUtil.getDriver(),this);
	}
	
	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement weDropDown;
	
	@FindBy(name ="firstname")
	private WebElement weFirstName;
	
	@FindBy(name = "lastname")
	private WebElement weLastName;
	
	@FindBy(name = "company")
	private WebElement weCompanyName;
	
	@FindBy(id = "phone")
	private WebElement wePhoneNo;
	
	@FindBy(id ="mobile" )
	private WebElement weMobileNo;
	
	@FindBy(id  = "fax")
	private WebElement weFax;
	
	@FindBy(id = "email")
	private WebElement weEmail;
	
	@FindBy(xpath ="//select[@name='leadsource']")
	private WebElement weleadsource;
	
	@FindBy(xpath = "//select[@name=\"leadstatus\"]")
	private WebElement weleadStatus;
	
	@FindBy(id ="code")
	private WebElement weCode;
	
	@FindBy(xpath ="//input[@id='country']")
	private WebElement weCountry;
	
	@FindBy(name = "pobox")
	private WebElement wePoBox;
	
	@FindBy(name ="city")
	private WebElement weCity;
	
	@FindBy(name ="state")
	private WebElement weState;
	
	@FindBy(name ="description")
	private WebElement weDescription;
	
	@FindBy(xpath="(//input[@name=\"assigntype\"])[1]")
	private WebElement weradioBtn;
	
	public void enterLeadsTotaleInfo() {
	String surName=	mapdata.get("SurName_DD");
		webUtil.selectByvalue(surName,weDropDown);
		String LastName=	mapdata.get("LastName_ED");
		webUtil.input(LastName,weLastName);
		String firstname=	mapdata.get("FirstName_ED");
		webUtil.input(firstname,weFirstName);
		String CompanyName=	mapdata.get("CompanyName_ED");
		webUtil.input(CompanyName,weCompanyName);
		String PhoneNo=	mapdata.get("Phone_ED");
		webUtil.input(PhoneNo,wePhoneNo);
		String MobileNo=	mapdata.get("Mobile_ED");
		webUtil.input(MobileNo,weMobileNo);
		String radioBTN=	mapdata.get("radio_BTN");
		webUtil.click( weradioBtn);
		String Email=	mapdata.get("Email_ED");
		webUtil.input(Email,weEmail);
		String leadsource=	mapdata.get("Lead_Source_DD");
		webUtil.selectByvalue(leadsource,weleadsource);
		String leadStatus=	mapdata.get("leadStatus_DD");
		webUtil.selectByvalue(leadStatus,weleadStatus);
		String Code=	mapdata.get("Code_ED");
		webUtil.input(Code,weCode);
		String Country=	mapdata.get("Country_ED");
		webUtil.input(Country,weCountry);
		String PoBox=	mapdata.get("PoBox_ED");
		webUtil.input(PoBox,wePoBox);
		String City=	mapdata.get("City_ED");
		webUtil.input(City,weCity);
		String State=	mapdata.get("State_ED");
		webUtil.input(State,weState);
		String Description=	mapdata.get("Description_TB");
		webUtil.input(Description,weDescription);

	}
//	public void leadsFormFilup() {
//		HomePage homePg = new HomePage(webUtil);
//		homePg.gotoMarketingLeads();
//		LeadsLandingPage leadsLandingPg = new LeadsLandingPage(webUtil);
//		leadsLandingPg.clickCreateLeadBtn();
//		LeadsCreatePage leadsCreatePage = new LeadsCreatePage(webUtil, mapdata);
//		//leadsCreatePage.enterLeadsTotaleInfo();
//		LeadsDetailsPage leadVerifyDetail = new LeadsDetailsPage(webUtil);
//		String expDeatailsHeader=mapdata.get("expDeatailsHeader");
//		leadVerifyDetail.verifyLeadsDetailHeader(expDeatailsHeader);
//		String expLastName =mapdata.get("expLastName");
//		leadVerifyDetail.verifyLastName(expLastName);
//		String expCompanyName=mapdata.get("expCompanyName");
//		leadVerifyDetail.verifyCompanyName(expCompanyName);
//		leadsCreatePage.saveLeads();
//	}
	
	
	
	
	
	
	
	
public void saveLeads() {
		
		webUtil.click(commonSaveBtn);
		 
	}
	public void cancelLeads() {
		
		webUtil.click(commonCanvelBtn);
		
	}



public void verifyvisibleElement(String expDetailHeader) {
	
	webUtil.click(commonDetailsHeader);
}








public void deleteLeads() {
	webUtil.jsClick(commonDeletBtn);	
}

}


	
	

