package Assignments;

import executions.AssignmentMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Assignments;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AssignmentsFunctionalities extends Base {
    public Assignments asg;
    public AssignmentMethods asgMethods;
    public WebDriver driver;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        asg = new Assignments(driver); // Structured page object model function defined
        asgMethods = new AssignmentMethods(driver);
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Assignments module.")
    @Story("ASGFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.teacherLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the assignments module.")
    @Story("ASGFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.studentLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully create a assignment for student.")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherCreateAssignmentForStudentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.teacherCreateAssignmentForStudentCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully create a assignment.")
    @Story("ASGFT_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherCreateAssignmentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.teacherCreateAssignmentCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully start an assignment.")
    @Story("ASGFS_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentStartAssignment(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.studentStartAssignment(driver, mobNumber, password));
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully schedule an assignment.")
    @Story("ASGFT_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherScheduledPageCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.teacherScheduledPageCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully navigate to next pages from pagination.")
    @Story("ASGFS_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.studentPaginationCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the assignments in Ongoing page.")
    @Story("ASGFT_04")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherOngoingPageCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.teacherOngoingPageCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the assignments in drafts page.")
    @Story("ASGFT_05")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherDraftsPageCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.teacherDraftsPageCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the assignments in completed page.")
    @Story("ASGFT_06")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherCompletedPageCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.teacherCompletedPageCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Assignments module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the assignments in cancelled page.")
    @Story("ASGFT_07")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherCancelledPageCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(asgMethods.teacherCancelledPageCheck(driver, mobNumber, password));
    }



    @AfterMethod // Method will work After each method inside this class
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
