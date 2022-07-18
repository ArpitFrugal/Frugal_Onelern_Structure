package resources;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;

import java.io.IOException;

public class BaseLogin extends Base {

	public LoginPage log;
	public WebDriver driver;

	public BaseLogin(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	public void userLogin(String user, String mobNumber, String pass) throws IOException, InterruptedException {
		log = new LoginPage(driver);

		if(user == "teacher") {
			log.getTeacherSignIn().click();
			log.getUserName().sendKeys(mobNumber);
			log.getSubmitButton().click();
			Thread.sleep(5000);
			log.getloginWithPassword().click();
			log.getPassword().sendKeys(pass);
			Thread.sleep(5000);
			log.getPasswordButton().click();
			Thread.sleep(5000);
		}
		else {
			log.getStudentSignIn().click();
			log.getUserName().sendKeys(mobNumber);
			log.getSubmitButton().click();
			Thread.sleep(5000);
			log.getloginWithPassword().click();
			log.getPassword().sendKeys(pass);
			Thread.sleep(5000);
			log.getPasswordButton().click();
			Thread.sleep(5000);
			log.StudentImageClick().click();
			Thread.sleep(5000);
		}

	}

}
