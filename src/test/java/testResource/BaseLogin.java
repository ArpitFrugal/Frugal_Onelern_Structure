package testResource;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import resources.Base;

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

		if(user.equals("teacher")) {
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
		else if (user.equals("projectadmin")) {
			log.getOthersSignIn().click();
			log.userEmailID().click();
			log.userEmailID().sendKeys(mobNumber);
			Thread.sleep(1000);
			log.PasswordInput().click();
			log.PasswordInput().sendKeys(pass);
			Thread.sleep(1000);
			log.adminLoginBtn().click();
		}
		else if (user.equals("schooladmin")) {
//			log.getOthersSignIn().click();
			log.userEmailID().click();
			log.userEmailID().sendKeys(mobNumber);
			Thread.sleep(1000);
			log.PasswordInput().click();
			log.PasswordInput().sendKeys(pass);
			Thread.sleep(1000);
			log.adminLoginBtn().click();
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
