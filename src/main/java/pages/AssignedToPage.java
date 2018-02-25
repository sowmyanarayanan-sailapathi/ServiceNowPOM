package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import wdMethods.ProjectMethods;

public class AssignedToPage extends ProjectMethods {

	public AssignedToPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.LINK_TEXT,using="ITIL User")
	WebElement itilUser;
	public ServiceHomePage clickItilUser() throws InterruptedException {
		clickWithNoSnap(itilUser);
		Thread.sleep(3000);
		switchToWindow(0);
		return new ServiceHomePage();

	}

}
