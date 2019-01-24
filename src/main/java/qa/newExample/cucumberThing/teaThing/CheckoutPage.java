package qa.newExample.cucumberThing.teaThing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[15]/div/p/span/strong")
	private WebElement checkoutIdentifier;
	
	public String identifier() {
		
		return checkoutIdentifier.getText();
		
	}
}
