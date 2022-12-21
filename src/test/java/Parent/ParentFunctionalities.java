package Parent;

import executions.NotebookMethods;
import executions.ParentMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import pageObjects.Parent;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class ParentFunctionalities extends Base {

    public Parent par;
    public ParentMethods parmethods;
    public WebDriver driver;


    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        par = new Parent(driver); // Structured page object model function defined
        parmethods = new ParentMethods(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Epic("This story represents the parent module of the onelern_school project.")
    @Description("Parent can view Complete his/her 's student profile.")
    @Story("PAR_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData")
    public void ParentStudentAttendanceCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(parmethods.ParentStudentAttendanceCheck(driver, mobNumber, password));
    }


    @Epic("This story represents the parent module of the onelern_school project.")
    @Description("Parent can view Complete his/her 's student profile.")
    @Story("PAR_01")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData")
    public void ParentStudentViewProfileCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertTrue(parmethods.ParentStudentViewProfileCheck(driver, mobNumber, password));
    }


    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }
}
