package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class UsersPage extends ProjectMethods {

	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="(//input[@class='form-control'])[1]")
	WebElement callerSearch;
	public UsersPage searchCaller(String caller) {
		type(callerSearch, caller);
		return this;		
		}
	
	@FindBy(how=How.XPATH,using="(//a[@class='glide_ref_item_link'])[1]")
	WebElement caller;
	public ServiceHomePage clickCaller() {
		clickWithNoSnap(caller);
		switchToWindow(0);
		return new ServiceHomePage();
	}
	
	
	
	

}
