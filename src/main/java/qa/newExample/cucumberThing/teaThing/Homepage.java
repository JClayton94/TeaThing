package qa.newExample.cucumberThing.teaThing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	
	@FindBy(xpath = "/html/body/div/div/div[1]/div/div[13]/div/ul/li[3]/a")
	private WebElement menu;
	
	public void menuButton() {
		
		menu.click();
		
	}

}
