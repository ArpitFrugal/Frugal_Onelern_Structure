package loginFunctionality;

import java.io.IOException;
import resources.Base;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import executions.LoginMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pageObjects.LoginPage;

public class LoginLandingPageCheck extends Base {

	public LoginPage log;
	public WebDriver driver;
	public LoginMethods logmethods;

	@BeforeMethod // Method will work before each method inside this class
	public void standardLogic() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		this.log = new LoginPage(driver);
		logmethods = new LoginMethods();
	}

	@Epic("Login functionality of the onelern_school project.")
	@Description("Examin Student Toggel check ")
	@Story("LOGFS_01")
	@Test(priority = 1)
	public void studentLandingPage() {
		Assert.assertEquals(logmethods.studentLandingPage(driver), true);
	}

	@Epic("Login functionality of the onelern_school project.")
	@Description("Examin Teacher toggle check")
	@Story("LOGFT_01")
	@Test(priority = 2)
	public void teacherLandingPage() throws IOException, InterruptedException {
		Assert.assertEquals(logmethods.teacherLandingPage(driver), true);
	}

	@AfterMethod // Method will work After each method inside this class
	public void tearDown() {
		driver.close();
	}

}
