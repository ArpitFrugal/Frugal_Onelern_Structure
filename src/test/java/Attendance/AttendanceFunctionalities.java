package Attendance;

import com.google.j2objc.annotations.Weak;
import executions.AttendanceMethods;
import executions.DoubtsMethods;
import io.qameta.allure.*;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Attendance;
import pageObjects.Doubts;
import resources.Base;

import java.io.IOException;
import java.util.Arrays;

public class AttendanceFunctionalities extends Base {
    public Attendance att;
    public AttendanceMethods attmethods;
    public WebDriver driver;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        att = new Attendance(driver); // Structured page object model function defined
        attmethods = new AttendanceMethods(driver);
    }

    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the Attendance module.")
    @Story("ATTFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentdata")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(attmethods.studentLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Attendance module.")
    @Story("ATTFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(attmethods.teacherLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the student can view the count of present, absent, leave, and holiday correctly.")
    @Story("ATTFS_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentdata")
    public void studentPALHCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(attmethods.studentPALHCountCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the teacher can view the count of present, absent, and leave correctly.")
    @Story("ATTFT_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void teacherPALCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(attmethods.teacherPALCountCheck(driver, mobNumber, password));
    }


    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the teacher can mark a day as holiday or mark attendance for any particular day.")
    @Story("ATTFT_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void teacherMarkHolidayCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(attmethods.teacherMarkHolidayCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully the attendance percentage calculated monthly.")
    @Story("ATTFS_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentdata")
    public void studentPercentageCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(attmethods.studentPercentageCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the student can navigate to next pages through pagination.")
    @Story("ATTFS_04")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentdata")
    public void studentPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(attmethods.studentPaginationCheck(driver, mobNumber, password));
    }


    @Epic("This story represents the Attendance module of the onelern_school project.")
    @Description("Examine whether or not the teacher can navigate to next pages through pagination.")
    @Story("ATTFT_04")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata")
    public void teacherPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(attmethods.teacherPaginationCheck(driver, mobNumber, password));
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
