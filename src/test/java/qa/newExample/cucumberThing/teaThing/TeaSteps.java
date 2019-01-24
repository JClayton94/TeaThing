package qa.newExample.cucumberThing.teaThing;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaSteps {

	private WebDriver driver;
	private ExtentReports report;
	private ExtentTest test;

	@Before
	public void setup() {

		System.setProperty("webdriver.gecko.driver", Constant.WEBDRIVER_LOCATION);
		driver = new FirefoxDriver();
		report = new ExtentReports(Constant.TEST_LOG_LOCATION);
		// Test Report
		test = report.startTest("Starting Test");

	}
	
	@After
	public void teardown() {
		
		driver.close();
		report.flush();
		
	}

	@Given("^the correct web address$")
	public void the_correct_web_address() {

		driver.manage().window().maximize();
		driver.get("http://www.practiceselenium.com/welcome.html");

//		assertEquals("http://www.practiceselenium.com/welcome.html", driver.getCurrentUrl());

	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {

		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		test.log(LogStatus.INFO, "Navigated to homepage");
		homepage.menuButton();

	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		Menu menu = PageFactory.initElements(driver, Menu.class);

		test.log(LogStatus.INFO, "Checked if we are on the correct page");
		assertEquals("Green Tea", menu.getGreenTea());

	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {

		Menu menu = PageFactory.initElements(driver, Menu.class);
 
		test.log(LogStatus.INFO, "Clicking the checkout button");

		menu.checkout();

	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {

		CheckoutPage page = PageFactory.initElements(driver, CheckoutPage.class);

		assertEquals("Pay with Credit Card or Log In", page.identifier());

	}

}
