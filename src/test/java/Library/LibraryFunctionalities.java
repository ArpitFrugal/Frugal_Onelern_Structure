package Library;

import executions.LibraryMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Library;
import resources.Base;
import testResource.ReadExcelFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class LibraryFunctionalities extends Base {
    public Library lib;
    public WebDriver driver;
    public LibraryMethods libmethods;


    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        lib = new Library(driver); // Structured page object model function defined
        libmethods = new LibraryMethods(driver);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the library module.")
    @Story("LIBFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData", priority=1, groups="Library_landing")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.studentLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the library module.")
    @Story("LIBFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData", priority=2, groups="Library_landing")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.teacherLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a student in a specific grade has the correct grade book")
    @Story("LIBFS_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData", priority=3, groups="Grade_Check")
    public void CheckStudentBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.CheckStudentBookGrade(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a teacher of a specific grade has the correct grade book")
    @Story("LIBFT_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData", priority=4, groups="Grade_Check")
    public void CheckTeacherBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.CheckTeacherBookGrade(driver, mobNumber, password));
    }



    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To check if the student workbook name is the same as that mentioned in the library image")
    @Story("LIBFS_03")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData", priority=5, groups="Workbook_Check")
    public void StudentWorkbookCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.StudentWorkbookCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To check if the teacher workbook name is the same as that mentioned in the library image")
    @Story("LIBFT_03")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData", priority=6, groups="Workbook_Check")
    public void TeacherWorkbookCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.TeacherWorkbookCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFS_04")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData", priority=7, groups="LessonName")
    public void StudentLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertTrue(libmethods.StudentLessonNameCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFT_04")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData", priority=8, groups="LessonName")
    public void TeacherLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertTrue(libmethods.TeacherLessonNameCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFS_05")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData", priority=9, groups="LessonTopic")
    public void StudentLessonTopicCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertTrue(libmethods.StudentLessonTopicCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFT_05")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData", priority=10, groups="LessonTopic")
    public void TeacherLessonTopicCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertTrue(libmethods.TeacherLessonTopicCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To check if the audio player is displayed or not.")
    @Story("LIBFS_06")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData", priority=11, groups="AudioCheck")
    public void StudentAudioCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.StudentAudioCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the audio can successfully played properly.")
    @Story("LIBFT_06")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData", priority=12, groups="AudioCheck")
    public void teacherAudiocheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.teacherAudiocheck(driver, mobNumber, password));
    }

    // Video Check

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the video can successfully played properly.")
    @Story("LIBFS_07")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData", priority=13, groups="VideoCheck")
    public void studentVideocheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.studentVideocheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the video can successfully played properly.")
    @Story("LIBFT_07")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData", priority=14, groups="VideoCheck")
    public void teacherVideocheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.teacherVideocheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Searched content should be displayed on screen.")
    @Story("LIBFS_08")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData", priority=15, groups="SearchCheck")
    public void StudentSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.StudentSearchCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Searched content should be displayed on screen.")
    @Story("LIBFT_08")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData", priority=16, groups="SearchCheck")
    public void TeacherSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(libmethods.TeacherSearchCheck(driver, mobNumber, password));
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
