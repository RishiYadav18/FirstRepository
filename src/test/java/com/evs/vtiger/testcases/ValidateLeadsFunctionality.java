package com.evs.vtiger.testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.evs.vtiger.exceldata.ExcelDataUtil;
import com.evs.vtiger.pages.home.HomePage;
import com.evs.vtiger.pages.login.LoginPage;
import com.evs.vtiger.pages.marketing.campaings.CampaingsCreatePage;
import com.evs.vtiger.pages.marketing.leads.LeadsCreatePage;
import com.evs.vtiger.pages.marketing.leads.LeadsDetailsPage;
import com.evs.vtiger.pages.marketing.leads.LeadsLandingPage;
import com.evs.vtiger.pages.marketing.leads.VerifyDeleteNewLeads;
import com.evs.vtiger.utility.WdUtil;

public class ValidateLeadsFunctionality extends Basetest {
	@Test(priority = -1)
	public void vt001validateLogin() {
	String  expMarketingText = data.get("Expected_Market");
	 new HomePage(webUtil).verifyHomePage(expMarketingText);  
	
	}
	
	@Test(priority = 1)
	public void vt002validateCreateLeads() throws IOException {
		datamapList = data.getTestCaseData("src/main/resources/TestCase.xlsx","vt002validateCreateLeads");
		for(int i=0;i<=datamapList.size()-1;i++) {
		Map<String,String>	mapdata = datamapList.get(i);
		HomePage homePg = new HomePage(webUtil);
		homePg.gotoMarketingLeads();
		LeadsLandingPage leadsLandingPg = new LeadsLandingPage(webUtil);
		leadsLandingPg.clickCreateLeadBtn();
		LeadsCreatePage leadsCreatePage = new LeadsCreatePage(webUtil, mapdata);
		leadsCreatePage.enterLeadsTotaleInfo();
		leadsCreatePage.saveLeads();
		
		LeadsDetailsPage leadVerifyDetail = new LeadsDetailsPage(webUtil);
		String expDeatailsHeader=mapdata.get("expDeatailsHeader");
		leadVerifyDetail.verifyLeadsDetailHeader(expDeatailsHeader);
		String expLastName =mapdata.get("expLastName");
		leadVerifyDetail.verifyLastName(expLastName);
		String expCompanyName=mapdata.get("expCompanyName");
		leadVerifyDetail.verifyCompanyName(expCompanyName);
	}
	}
	@Test(priority = 2)
	public void vt003validateDeleteLead() throws IOException {
		datamapList = data.getTestCaseData("src\\main\\resources\\TestCase.xlsx", "vt003validateDeleteLead");
		for (int i = 0; i <= datamapList.size() - 1; i++) {
			Map<String, String> mapdata = datamapList.get(i);
			HomePage hpage=new HomePage(webUtil);
			hpage.gotoMarketingLeads();

			VerifyDeleteNewLeads verifyDelLead=new VerifyDeleteNewLeads(webUtil);
			String expPop = mapdata.get("expPopupText");
			verifyDelLead.verifyDeleteLeads(expPop);
			

		}

	}
}