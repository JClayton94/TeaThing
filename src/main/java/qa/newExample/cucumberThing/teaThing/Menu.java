package qa.newExample.cucumberThing.teaThing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Menu {
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[14]/div/p/span/span/strong")
	private WebElement greenTea;
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[16]/div/a/span")
	private WebElement checkoutButton;
	
	public String getGreenTea() {
		
		return greenTea.getText();
	}
	
	public void checkout() {
		
		checkoutButton.click();
		
	}

}
