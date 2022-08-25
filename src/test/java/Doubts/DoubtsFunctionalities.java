package Doubts;

import executions.DoubtsMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Doubts;
import resources.Base;
import testResource.ReadExcelFile;

import java.io.IOException;
import java.util.Arrays;

public class DoubtsFunctionalities extends Base {
    public Doubts dou;
    public WebDriver driver;
    public DoubtsMethods doumethods;
    public String student = "student";
    public String teacher = "teacher";

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        dou = new Doubts(driver); // Structured page object model function defined
        doumethods = new DoubtsMethods(driver);
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the Doubts module.")
    @Story("DOUFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentdata", priority = 1)
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.studentLanding(driver, mobNumber, password));
    }
    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Doubts module.")
    @Story("DOUFT-01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata", priority = 2)
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.teacherLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully open page for asking doubt.")
    @Story("DOUFS_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentdata", priority = 3)
    public void studentAskADoubt(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.studentAskADoubt(driver, mobNumber, password));
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the increase in view count when viewed.")
    @Story("DOUFS_03")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "studentdata", priority = 4)
    public void studentViewCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.studentViewCountCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the increase in view count when viewed.")
    @Story("DOUFT-02")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "teacherdata", priority = 5)
    public void teacherViewCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.teacherViewCountCheck(driver ,mobNumber, password));
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully ask his/her doubt.")
    @Story("DOUFS_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentdata", priority = 6)
    public void studentAskNewDoubt(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.studentAskNewDoubt(driver, mobNumber, password));
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the doubt asked by the students.")
    @Story("DOUFT-03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherdata", priority = 7)
    public void teacherViewNewDoubt(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.teacherViewNewDoubt(driver, mobNumber, password));
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully upload multimedia content in his/her doubt.")
    @Story("DOUFS_05")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentdata", priority = 8)
    public void studentUploadMultimedia(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.studentUploadMultimedia(driver, mobNumber, password));
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully filter the content by applying specific filters.")
    @Story("DOUFS_06")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentdata", priority = 9)
    public void studentFilterFunctionalityCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.studentFilterFunctionalityCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully filter the content by applying specific filters.")
    @Story("DOUFT-04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherdata", priority = 10)
    public void teacherFilterFunctionalityCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.teacherFilterFunctionalityCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Doubts module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully reply to the doubt posted by the student. And also to check whether student can view reply to the doubt")
    @Story("DOU-01")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void DoubtreplyCheck() throws IOException, InterruptedException {
        Assert.assertTrue(doumethods.DoubtreplyCheck(driver));
    }



    @AfterMethod // Method will work After each method inside this class
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "studentdata")
    public Object[][] getstudentData() {
//        Object loginData[][] = { { "9000000001", "123456" }, { "9000000021", "123456" }, { "9000000041", "123456" },
//                { "9000000061", "123456" }, { "9000000081", "123456" } };
        Object loginData[][] = { { "9000000001", "123456" }};
//        Object[][] loginData = ReadExcelFile.TestcasesCredentials("student");
        for(Object[] i:loginData){
            System.out.println(Arrays.toString(i));
        }
        return loginData;
    }
    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() {
//        Object loginData[][] = { { "9000000101", "123456" }, { "9000000105", "123456" }, { "9000000110", "123456" },
//                { "9000000114", "123456" }, { "9000000120", "123456" } };
        Object loginData[][] = { { "9000000101", "123456" }};
//        Object[][] loginData = ReadExcelFile.TestcasesCredentials("teacher");

        return loginData;
    }


}
