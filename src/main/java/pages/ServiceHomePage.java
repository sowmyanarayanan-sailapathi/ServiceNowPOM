package pages;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class ServiceHomePage extends ProjectMethods {

	public ServiceHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID,using="filter")
	WebElement Filter;
	public ServiceHomePage filterIncident(String Incident) {
		type(Filter, Incident);
		return this;
	}

	@FindBy(how=How.XPATH,using="(//div[text()='Create New'])[1]")
	WebElement createInc;
	public ServiceHomePage clickCreateInc() {
		click(createInc);
		return this;
	}

	@FindBy(how=How.ID,using="gsft_main")
	WebElement iFrameID;
	public ServiceHomePage switchTohFrame() {
		switchToFrame(iFrameID);
		return this;		
	}

	@FindBy(how=How.ID,using="incident.number")
	WebElement incID;
	public static String ticketID;
	public ServiceHomePage getIncNumber() {
		ticketID = getAttribute(incID, "value");
		return this;
	}
	
	public ServiceHomePage setIncNum() throws IOException {
		//Properties prop = new Properties();
		FileOutputStream output = new FileOutputStream("./src/main/resources/config.properties");
		System.out.println(ticketID);
		prop.setProperty("IncidentNumber", ticketID);
		prop.store(output, null);	
		output.close();
		return this;
	}
	

	@FindBy(how=How.XPATH,using="(//span[@class='icon icon-search'])[1]")
	WebElement iconSearch;
	public UsersPage clickCallerSearch() throws InterruptedException {
		clickWithNoSnap(iconSearch);
		Thread.sleep(3000);
		switchToWindow(1);
		return new UsersPage();
	}

	@FindBy(how=How.ID,using="incident.short_description")
	WebElement shrtDesc;
	public ServiceHomePage enterShortText() {
		type(shrtDesc, "Test Data");
		return this;
	}

	@FindBy(how=How.XPATH,using="(//button[@id='sysverb_insert'])[1]")
	WebElement submitButton;
	public ServiceHomePage clickSubmit() throws InterruptedException {
		clickWithNoSnap(submitButton);
		Thread.sleep(3000);
		return this;
	}

	@FindBy(how=How.XPATH,using="(//input[@class='form-control'])[1]")
	WebElement incSrch;
	public ServiceHomePage searchInc() {
		type(incSrch, prop.getProperty("IncidentNumber"));
		incSrch.sendKeys(Keys.ENTER);
		return this;
	}

	@FindBy(how=How.XPATH,using="(//a[@class='linked formlink'])[1]")
	WebElement resultingInc;
	public ServiceHomePage verifyIncNum(){
		verifyExactText(resultingInc, prop.getProperty("IncidentNumber"));	
		return this;		
	}
	@FindBy(how=How.XPATH,using="(//a[@class='linked'])[1]")
	WebElement verifyCaller;
	public ServiceHomePage verifyCallerName(String caller) {
		verifyExactText(verifyCaller, caller);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//div[text()='Open - Unassigned']")
	WebElement openUnAssigned;
	public ServiceHomePage clickOpenUnAssigned() {
		click(openUnAssigned);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="(//a[@class='linked formlink'])[1]")
	WebElement resultInc;
	public ServiceHomePage clickIncident() {
		click(resultInc);
		return this;
	}
	
	@FindBy(how=How.ID,using="incident.state")
	WebElement state;
	public ServiceHomePage selectState() {
		selectDropDownUsingText(state, "In Progress");
		return this;		
	}	
	
	@FindBy(how=How.ID,using="lookup.incident.assigned_to")
	WebElement asIcon;
	public AssignedToPage clickAssignedTo() throws InterruptedException {
		clickWithNoSnap(asIcon);
		Thread.sleep(3000);
		switchToWindow(1);
		return new AssignedToPage();
	}

}
