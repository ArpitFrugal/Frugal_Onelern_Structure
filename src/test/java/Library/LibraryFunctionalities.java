package Library;

import executions.LibraryMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
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

public class LibraryFunctionalities extends Base {
    public Library lib;
    public WebDriver driver;
    public LibraryMethods libmethods;
    public String student = "student";
    public String teacher = "teacher";


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
    @Test(dataProvider = "studentdata", priority=1, groups="Library_landing")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.studentLanding(driver, mobNumber,password),true);

    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the library module.")
    @Story("LIBFT_01")
    @Test(dataProvider = "teacherdata", priority=2, groups="Library_landing")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.teacherLanding(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a student in a specific grade has the correct grade book")
    @Story("LIBFS_02")
    @Test(dataProvider = "studentdata", priority=3, groups="Grade_Check")
    public void CheckStudentBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.CheckStudentBookGrade(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a teacher of a specific grade has the correct grade book")
    @Story("LIBFT_02")
    @Test(dataProvider = "teacherdata", priority=4, groups="Grade_Check")
    public void CheckTeacherBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.CheckTeacherBookGrade(driver, mobNumber, password), true);
    }



    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To check if the student workbook name is the same as that mentioned in the library image")
    @Story("LIBFS_03")
    @Test(dataProvider = "studentdata", priority=5, groups="Workbook_Check")
    public void StudentWorkbookCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.StudentWorkbookCheck(driver,mobNumber,password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To check if the teacher workbook name is the same as that mentioned in the library image")
    @Story("LIBFT_03")
    @Test(dataProvider = "teacherdata", priority=6, groups="Workbook_Check")
    public void TeacherWorkbookCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.TeacherWorkbookCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFS_04")
    @Test(dataProvider = "studentdata", priority=7, groups="LessonName")
    public void StudentLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(libmethods.StudentLessonNameCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFT_04")
    @Test(dataProvider = "teacherdata", priority=8, groups="LessonName")
    public void TeacherLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(libmethods.TeacherLessonNameCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFS_05")
    @Test(dataProvider = "studentdata", priority=9, groups="LessonTopic")
    public void StudentLessonTopicCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(libmethods.StudentLessonTopicCheck(driver, mobNumber, password),true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFT_05")
    @Test(dataProvider = "teacherdata", priority=10, groups="LessonTopic")
    public void TeacherLessonTopicCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(libmethods.TeacherLessonTopicCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To check if the audio player is displayed or not.")
    @Story("LIBFS_06")
    @Test(dataProvider = "studentdata", priority=11, groups="AudioCheck")
    public void StudentAudioCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.StudentAudioCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the audio can successfully played properly.")
    @Story("LIBFT_06")
    @Test(dataProvider = "teacherdata", priority=12, groups="AudioCheck")
    public void teacherAudiocheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.teacherAudiocheck(driver, mobNumber, password), true);
    }

    // Video Check

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the video can successfully played properly.")
    @Story("LIBFS_07")
    @Test(dataProvider = "studentdata", priority=13, groups="VideoCheck")
    public void studentVideocheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.studentVideocheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the video can successfully played properly.")
    @Story("LIBFT_07")
    @Test(dataProvider = "teacherdata", priority=14, groups="VideoCheck")
    public void teacherVideocheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.teacherVideocheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Searched content should be displayed on screen.")
    @Story("LIBFS_8")
    @Test(dataProvider = "studentdata", priority=15, groups="SearchCheck")
    public void StudentSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.StudentSearchCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Searched content should be displayed on screen.")
    @Story("LIBFT-8")
    @Test(dataProvider = "teacherdata", priority=16, groups="SearchCheck")
    public void TeacherSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.TeacherSearchCheck(driver, mobNumber, password), true);
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
