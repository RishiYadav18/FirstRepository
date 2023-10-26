package com.evs.vtiger.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTest {
   @DataProvider(name="myData")
	public String[][] getData() {
		String[][]dataArr=new String[4][2];
		dataArr[0][0]="Rishu";
		dataArr[0][1]="yadav";
		dataArr[1][0]="Qa"	;	
	    dataArr[1][1]="Tester";	
	    dataArr[2][0]="Virat";
		dataArr[2][1]="Kohli";
		dataArr[3][0]="Indian"	;	
	    dataArr[3][1]="Cricketer";
	   	
	    		
	    return dataArr;		
	    		
	    		
	    		
	}
		
		@Test(dataProvider = "myData")
		public void test1(String name,String profession) {
			System.out.println(name);
			System.out.println(profession);
			
			
			
		}
		
		
		

	}


