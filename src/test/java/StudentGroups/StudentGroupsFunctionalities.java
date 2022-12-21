package StudentGroups;

import executions.PublishMethods;
import executions.StudentGroupsMethods;
import io.qameta.allure.*;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Publish;
import pageObjects.StudentGroups;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class StudentGroupsFunctionalities extends Base {
    public WebDriver driver;
    public StudentGroups sg;

    public StudentGroupsMethods sgmethods;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
//        demoLogger.info("Standard logic building");
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        sg = new StudentGroups(driver); // Structured page object model function defined
        sgmethods = new StudentGroupsMethods(driver);
    }

    @Epic("This story represents the Student Groups module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Student Groups module.")
    @Story("SGFT-01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(sgmethods.teacherLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Student Groups module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully click the add group button.")
    @Story("SGFT-02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void TeacherAddGroupBtnCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(sgmethods.TeacherAddGroupBtnCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Student Groups module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully add a group of many students.")
    @Story("SGFT-03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void TeacherAddGroupCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(sgmethods.TeacherAddGroupCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Student Groups module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully edit the added group.")
    @Story("SGFT-04")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void TeacherEditGroupCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(sgmethods.TeacherEditGroupCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Student Groups module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully delete the added group.")
    @Story("SGFT-05")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void TeacherDeleteGroupCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(sgmethods.TeacherDeleteGroupCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Student Groups module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully Search the added group.")
    @Story("SGFT-06")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void TeacherSearchGroupCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(sgmethods.TeacherSearchGroupCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Student Groups module of the onelern_school project.")
    @Description("Examine whether or not after successful getting into student groups module, a student would be able to create a student group and the created group is visible while teacher is publishing the content.")
    @Story("SG-01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void PublishStudentGroupsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(sgmethods.PublishStudentGroupsCheck(driver, mobNumber, password));
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
