package TimeTable;

import executions.TimeTableMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.TimeTable;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class TimeTableFunctionalities extends Base {
    public WebDriver driver;
    public TimeTable tim;
    public TimeTableMethods timmethods;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
//        demoLogger.info("Standard logic building");
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        tim = new TimeTable(driver); // Structured page object model function defined
        timmethods = new TimeTableMethods(driver);
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can enter into timetable module successfully.")
    @Story("TIMFA_01")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminLandingPageCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.adminLandingPageCheck(driver, usermail, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the Time table module.")
    @Story("TIMFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.studentLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Time table module.")
    @Story("TIMFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.teacherLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the teacher can navigate to next pages through pagination.")
    @Story("TIMFT_02")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.teacherPaginationCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the student can navigate to next pages through pagination.")
    @Story("TIMFS_02")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void studentPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.studentPaginationCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can create an template successfully.")
    @Story("TIMFA_02")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminCreateTemplateCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.adminCreateTemplateCheck(driver, usermail, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the student can view all the events successfully by clicking on view all button.")
    @Story("TIMFS_03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void studentViewEventsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.studentViewEventsCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the teacher can view all the events successfully by clicking on view all button.")
    @Story("TIMFT_03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherViewEventsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.teacherViewEventsCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can delete the template successfully.")
    @Story("TIMFA_03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminDeleteTemplateCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.adminDeleteTemplateCheck(driver, usermail, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the student can view all the holidays successfully by clicking on view all button.")
    @Story("TIMFS_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void studentViewHolidaysCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.studentViewHolidaysCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the teacher can view all the holidays successfully by clicking on view all button.")
    @Story("TIMFT_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherViewHolidaysCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.teacherViewHolidaysCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can view the calendar successfully.")
    @Story("TIMFA_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminViewCalendarCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.adminViewCalendarCheck(driver, usermail, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can create an event successfully.")
    @Story("TIMFA_05")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminCreateEventCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.adminCreateEventCheck(driver, usermail, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can edit the event successfully.")
    @Story("TIMFA_06")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminEditEventCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.adminEditEventCheck(driver, usermail, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can delete an event successfully.")
    @Story("TIMFA_07")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminDeleteEventCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.adminDeleteEventCheck(driver, usermail, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can create a holiday successfully.")
    @Story("TIMFA_08")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminCreateHolidayCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.adminCreateHolidayCheck(driver, usermail, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can edit the holiday successfully.")
    @Story("TIMFA_09")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminEditHolidayCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.adminEditHolidayCheck(driver, usermail, password));
    }

    @Epic("This story represents the Time table module of the onelern_school project.")
    @Description("Examine whether or not the admin can delete an holiday successfully.")
    @Story("TIMFA_10")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "adminData")
    public void adminDeleteHolidayCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(timmethods.adminDeleteHolidayCheck(driver, usermail, password));
    }

    @DataProvider(name = "adminData")
    public Object[][] getadminData() throws FileAlreadyExistsException {
        return getSchoolAdminData();
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
