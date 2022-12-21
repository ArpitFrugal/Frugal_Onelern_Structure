package Notifications;

import executions.NotebookMethods;
import executions.NotificationMethods;
import executions.ParentMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Notebook;
import pageObjects.Notifications;
import pageObjects.Parent;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.time.Duration;

public class NotificationsFunctionalities extends Base {
    public Notifications noti;
    public NotificationMethods notimethods;
    public WebDriver driver;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        noti = new Notifications(driver); // Structured page object model function defined
        notimethods = new NotificationMethods(driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the notification for new assessment.")
    @Story("NOTIFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void StudentNewAssessmentNotificationCheck() throws IOException, InterruptedException {
        Assert.assertTrue(notimethods.StudentNewAssessmentNotificationCheck(driver));
    }
    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the notification for new assignment.")
    @Story("NOTIFS_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void StudentNewAssignmentNotificationCheck() throws IOException, InterruptedException {
        Assert.assertTrue(notimethods.StudentNewAssignmentNotificationCheck(driver));
    }
    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the notification for making attendance as absent or leave.")
    @Story("NOTIFS_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void StudentAttendanceMarkedAbsentNotificationCheck() throws IOException, InterruptedException {
        Assert.assertTrue(notimethods.StudentAttendanceMarkedAbsentNotificationCheck(driver));
    }

    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the notification for making attendance as absent or leave.")
    @Story("NOTIFS_04")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void StudentAttendanceMarkedLeaveNotificationCheck() throws IOException, InterruptedException {
        Assert.assertTrue(notimethods.StudentAttendanceMarkedLeaveNotificationCheck(driver));
    }
    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the notification for new Holiday created.")
    @Story("NOTIFS_05")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void StudentNewHolidayNotificationCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(notimethods.StudentNewHolidayNotificationCheck(driver, usermail, password));
    }
    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the notification for new Holiday created.")
    @Story("NOTIFT_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void TeacherNewHolidayNotificationCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(notimethods.TeacherNewHolidayNotificationCheck(driver, usermail, password));
    }
    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the notification for new Event created.")
    @Story("NOTIFS_06")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void StudentNewEventNotificationCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(notimethods.StudentNewEventNotificationCheck(driver, usermail, password));
    }
    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully view the notification for new Event created.")
    @Story("NOTIFT_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void TeacherNewEventNotificationCheck(String usermail, String password) throws IOException, InterruptedException {
        Assert.assertTrue(notimethods.TeacherNewEventNotificationCheck(driver, usermail, password));
    }
    @Epic("This story represents the Notifications module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the notification for new published content.")
    @Story("NOTIFS_07")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void StudentPublishNewContentNotificationCheck() throws IOException, InterruptedException {
        Assert.assertTrue(notimethods.StudentPublishNewContentNotificationCheck(driver));
    }





    @DataProvider(name = "adminData")
    public Object[][] getadminData() throws FileAlreadyExistsException {
        return getSchoolAdminData();
    }
}
