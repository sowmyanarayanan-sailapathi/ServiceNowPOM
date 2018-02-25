package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class ServiceLoginPage extends ProjectMethods {

	public ServiceLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="gsft_main")
	WebElement iFrameID;
	public ServiceLoginPage switchTolFrame() {
		switchToFrame(iFrameID);
		return this;		
	}

	@FindBy(how=How.ID,using="user_name")
	WebElement userName;
	public ServiceLoginPage enterUserName(String uName) {
		type(userName, uName);
		return this;
	}
	
	@FindBy(how=How.ID,using="user_password")
	WebElement passWord;
	public ServiceLoginPage enterPassword(String pwd) {
		type(passWord,pwd);
		return this;
	}
	
	@FindBy(how=How.ID,using="sysverb_login")
	WebElement loginButton;
	public ServiceHomePage clickLoginButton() throws InterruptedException {
		click(loginButton);
		Thread.sleep(3000);
		return new ServiceHomePage();
	}
	

}
