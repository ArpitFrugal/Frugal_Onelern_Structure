package Library;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

import resources.Base;
import testResource.BaseLogin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import pageObjects.Library;
import pageObjects.LoginPage;

public class LibLandingPageCheck extends Base {

	public Library lib;
	public LoginPage log;
	public WebDriver driver;

	@BeforeMethod
	public void standardLogic() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		lib = new Library(driver);
		log = new LoginPage(driver);

	}
	
	public void ThreadSleep5000() throws InterruptedException {
		Thread.sleep(5000);
	}

	@Epic("This story represents the Library module of the onelern_school project.")
	@Description("Examine whether or not the student can successfully get inside the library module.")
	@Story("LIBF_01")
	@Test(dataProvider = "Studentdata")
	public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
		BaseLogin user = new BaseLogin(driver);
		user.userLogin("student", mobNumber, password);
		ThreadSleep5000();
		lib.StudentImageClick().click();
		ThreadSleep5000();
		lib.LibraryToggle().click();
		ThreadSleep5000();
		String Headingtext_actual = lib.WorkbookHeading().getText();
		String Headingtext_expected = "Library";
		if (Headingtext_actual.equals(Headingtext_expected)) {
			System.out.println("Library Module is active");
		} else {
			Assert.fail();
		}

	}

	@Epic("This story represents the Library module of the onelern_school project.")
	@Description("Examine whether or not the teacher can successfully get inside the library module.")
	@Story("LIBF_02")
	@Test(dataProvider = "teacherdata")
	public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
		BaseLogin user = new BaseLogin(driver);
		user.userLogin("teacher", mobNumber, password);
		ThreadSleep5000();
		lib.LibraryToggle().click();
		ThreadSleep5000();
		String Headingtext_actual = lib.WorkbookHeading().getText();
		String Headingtext_expected = "Library";
		if (Headingtext_actual.equals(Headingtext_expected)) {
			System.out.println("Library Module is active");
		} else {
			Assert.fail();
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	// This method provides data inputs to the above mentioned data receiver
	// functions.
	@DataProvider(name = "Studentdata")
	public Object[][] getstudentData() throws FileAlreadyExistsException {

		Object loginData[][] = { { "9000000001", "123456" }, { "9000000024", "123456" }, { "9000000046", "123456" },
				{ "9000000069", "123456" }, { "9000000081", "123456" } };
//		Object loginData[][] = { { "9000000001", "123456" } };

		return loginData;
	}

	@DataProvider(name = "teacherdata")
	public Object[][] getteacherData() throws FileAlreadyExistsException {
		Object loginData[][] = { { "9000000101", "123456" }, { "9000000105", "123456" }, { "9000000110", "123456" },
				{ "9000000114", "123456" }, { "9000000120", "123456" } };
//		Object loginData[][] = { { "9000000101", "123456" } };

		return loginData;
	}

}
