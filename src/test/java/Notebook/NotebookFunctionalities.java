package Notebook;

import executions.NotebookMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Notebook;
import resources.Base;
import testResource.ReadExcelFile;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class NotebookFunctionalities extends Base {
    public Notebook note;
    public WebDriver driver;
    public NotebookMethods notemethods;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        note = new Notebook(driver); // Structured page object model function defined
        notemethods = new NotebookMethods(driver);
    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the notebook module.")
    @Story("NOTFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData", priority=1, groups="Notebook_landing")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(notemethods.studentLanding(driver, mobNumber, password));
    }
    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Notebook module.")
    @Story("NOTFT-01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData", priority=2, groups="Notebook_landing")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(notemethods.teacherLanding(driver, mobNumber, password));
    }

    // Grade Check
    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a student in a specific grade has the correct grade book")
    @Story("NOTFS_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData", priority=3, groups="Notebook_GradeCheck")
    public void CheckStudentBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(notemethods.CheckStudentBookGrade(driver, mobNumber, password));
    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a teacher of a specific grade has the correct grade book")
    @Story("NOTFT_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData", priority=4, groups="Notebook_GradeCheck")
    public void CheckTeacherBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(notemethods.CheckTeacherBookGrade(driver, mobNumber, password));
    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("NOTFS_03")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData", priority=5, groups="Notebook_LessonNameCheck")
    public void StudentLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertTrue(notemethods.StudentLessonNameCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("NOTFT_03")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData", priority=6, groups="Notebook_LessonNameCheck")
    public void TeacherLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertTrue(notemethods.TeacherLessonNameCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a teacher can view highlights, notes and bookmarks from library in Notebook")
    @Story("NOTFT_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData", priority=7, groups="Notebook_Highlight")
    public void CheckTeacherHighlightsNotesBookmarks(String mobNumber, String password) throws IOException, InterruptedException, UnsupportedFlavorException {
        Assert.assertTrue(notemethods.CheckTeacherHighlightsNotesBookmarks(driver, mobNumber, password));
    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a student can view highlights, notes and bookmarks from library in Notebook")
    @Story("NOTFS_04")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData", priority=8, groups="Notebook_Highlight")
    public void CheckStudentHighlightsNotesBookmarks(String mobNumber, String password) throws IOException, InterruptedException, UnsupportedFlavorException {
        Assert.assertTrue(notemethods.CheckStudentHighlightsNotesBookmarks(driver, mobNumber, password));
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
