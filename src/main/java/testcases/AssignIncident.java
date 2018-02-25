package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ServiceLoginPage;
import wdMethods.ProjectMethods;

public class AssignIncident extends ProjectMethods{
	@BeforeTest
	public void setData() {
		testCaseName="TC002_AssignIncident";
		testDescription="Assign State and User to the created incident";
		testNodes="Leads";
		category="Smoke";
		authors="Sowmy";
		browserName="chrome";
		dataSheetName="ServiceNow";
	}



	@Test(dataProvider="fetchData")
	public void CreateLead(String uName,String pwd,String Incident,String callerName) throws InterruptedException, IOException {		
		new ServiceLoginPage()
		.switchTolFrame()
		.enterUserName(uName)
		.enterPassword(pwd)
		.clickLoginButton()
		.filterIncident(Incident)
		.clickOpenUnAssigned()
		.switchTohFrame()
		.searchInc()
		.clickIncident()
		.selectState()
		.clickAssignedTo()
		.clickItilUser();
	}

}
