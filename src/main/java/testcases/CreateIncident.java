package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ServiceLoginPage;
import wdMethods.ProjectMethods;

public class CreateIncident extends ProjectMethods{
	@BeforeTest
	public void setData() {
		testCaseName="TC001_CreateIncident";
		testDescription="Creates new ServiceNow Ticket";
		testNodes="Leads";
		category="Smoke";
		authors="Sowmy";
		browserName="chrome";
		dataSheetName="ServiceNow";
	}


//Test from Nagesh' s Local
	//Introduce conflict
	//This method will create an Incident in Service Now
	@Test(dataProvider="fetchData")
	public void CreateLead(String uName,String pwd,String Incident,String callerName) throws InterruptedException, IOException {		
		new ServiceLoginPage()
		.switchTolFrame()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLoginButton()
		.filterIncident(Incident)
		.clickCreateInc()
		.switchTohFrame()
		.getIncNumber()
		.setIncNum()
		.clickCallerSearch()
		.searchCaller(callerName)
		.clickCaller()
		.switchTohFrame()
		.enterShortText()
		.clickSubmit()
		.searchInc()
		.verifyIncNum()
		.verifyCallerName(callerName);
	}

}
