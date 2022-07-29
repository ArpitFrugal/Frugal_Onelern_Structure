package Notebook;

import executions.NotebookMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
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

public class NotebookFunctionalities extends Base {
    public Notebook note;
    public WebDriver driver;
    public NotebookMethods notemethods;
    public String student = "student";
    public String teacher = "teacher";
    ReadExcelFile dataresource;

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
    @Test(dataProvider = "studentdata", priority=1, groups="Notebook_landing")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(notemethods.studentLanding(driver, mobNumber, password),true);
    }
    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Notebook module.")
    @Story("NOTFT-01")
    @Test(dataProvider = "teacherdata", priority=2, groups="Notebook_landing")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(notemethods.teacherLanding(driver, mobNumber, password),true);
    }

    // Grade Check
    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a student in a specific grade has the correct grade book")
    @Story("NOTFS_02")
    @Test(dataProvider = "studentdata", priority=3, groups="Notebook_GradeCheck")
    public void CheckStudentBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(notemethods.CheckStudentBookGrade(driver,mobNumber,password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a teacher of a specific grade has the correct grade book")
    @Story("NOTFT_02")
    @Test(dataProvider = "teacherdata", priority=4, groups="Notebook_GradeCheck")
    public void CheckTeacherBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(notemethods.CheckTeacherBookGrade(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("NOTFS_03")
    @Test(dataProvider = "studentdata", priority=5, groups="Notebook_LessonNameCheck")
    public void StudentLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(notemethods.StudentLessonNameCheck(driver, mobNumber, password), true);
    }
    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("NOTFT_03")
    @Test(dataProvider = "teacherdata", priority=6, groups="Notebook_LessonNameCheck")
    public void TeacherLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(notemethods.TeacherLessonNameCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a teacher can view highlights, notes and bookmarks from library in Notebook")
    @Story("NOTFT_04")
    @Test(dataProvider = "teacherdata", priority=7, groups="Notebook_Highlight")
    public void CheckTeacherHighlightsNotesBookmarks(String mobNumber, String password) throws IOException, InterruptedException, UnsupportedFlavorException {
        Assert.assertEquals(notemethods.CheckTeacherHighlightsNotesBookmarks(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a student can view highlights, notes and bookmarks from library in Notebook")
    @Story("NOTFS_04")
    @Test(dataProvider = "studentdata", priority=8, groups="Notebook_Highlight")
    public void CheckStudentHighlightsNotesBookmarks(String mobNumber, String password) throws IOException, InterruptedException, UnsupportedFlavorException {
        Assert.assertEquals(notemethods.CheckStudentHighlightsNotesBookmarks(driver, mobNumber, password), true);
    }



    @AfterMethod // Method will work After each method inside this class
    public void tearDown() {
        driver.close();
    }

    @DataProvider(name = "studentdata")
    public Object[][] getstudentData() {
//		Object[][] loginData = { { "9000000001", "123456" } };
        Object[][] loginData = ReadExcelFile.TestcasesCredentials("student");

        return loginData;
    }
    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() {
//		Object[][] loginData = { { "9000000101", "123456" } };
        Object[][] loginData = ReadExcelFile.TestcasesCredentials("teacher");

        return loginData;
    }


}
