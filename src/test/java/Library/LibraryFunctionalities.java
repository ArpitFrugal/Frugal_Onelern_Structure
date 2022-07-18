package Library;

import executions.LibraryMethods;
import executions.LoginMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Library;
import pageObjects.LoginPage;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

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
        libmethods = new LibraryMethods();
    }
    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
    }
    public void ThreadSleep3000() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the library module.")
    @Story("LIBFS_01")
    @Test(dataProvider = "Studentdata")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.studentLanding(driver, mobNumber,password),true);

    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the library module.")
    @Story("LIBFT_01")
    @Test(dataProvider = "teacherdata")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.teacherLanding(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a student in a specific grade has the correct grade book")
    @Story("LIBFS_02")
    @Test(dataProvider = "Studentdata")
    public void CheckStudentBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.CheckStudentBookGrade(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a teacher of a specific grade has the correct grade book")
    @Story("LIBFT_02")
    @Test(dataProvider = "Teachersdata")
    public void CheckTeacherBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
    Assert.assertEquals(libmethods.CheckTeacherBookGrade(driver, mobNumber, password), true);
    }



    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To check if the student workbook name is the same as that mentioned in the library image")
    @Story("LIBFS_03")
    @Test(dataProvider = "Studentdata")
    public void StudentWorkbookCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.StudentWorkbookCheck(driver,mobNumber,password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To check if the teacher workbook name is the same as that mentioned in the library image")
    @Story("LIBFT_03")
    @Test(dataProvider = "Teachersdata")
    public void TeacherWorkbookCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.TeacherWorkbookCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFS_04")
    @Test(dataProvider = "Studentdata")
    public void StudentLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(libmethods.StudentLessonNameCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFT_04")
    @Test(dataProvider = "Teachersdata")
    public void TeacherLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(libmethods.TeacherLessonNameCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFS_05")
    @Test(dataProvider = "Studentdata")
    public void StudentLessonTopicCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(libmethods.StudentLessonTopicCheck(driver, mobNumber, password),true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFT_05")
    @Test(dataProvider = "Teachersdata")
    public void TeacherLessonTopicCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(libmethods.TeacherLessonTopicCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To check if the audio player is displayed or not.")
    @Story("LIBFS_06")
    @Test(dataProvider = "Studentdata")
    public void StudentAudioCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.StudentAudioCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the audio can successfully played properly.")
    @Story("LIBFT_06")
    @Test(dataProvider = "Teacherdata")
    public void teacherAudiocheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.teacherAudiocheck(driver, mobNumber, password), true);
    }

    // Video Check

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the video can successfully played properly.")
    @Story("LIBFS_07")
    @Test(dataProvider = "Studentdata")
    public void studentVideocheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.studentVideocheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Examine whether or not the video can successfully played properly.")
    @Story("LIBFT_07")
    @Test(dataProvider = "teacherdata")
    public void teacherVideocheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.teacherVideocheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Searched content should be displayed on screen.")
    @Story("LIBFS_8")
    @Test(dataProvider = "Studentdata")
    public void StudentSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.StudentSearchCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Searched content should be displayed on screen.")
    @Story("LIBFT-8")
    @Test(dataProvider = "teacherdata")
    public void TeacherSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(libmethods.TeacherSearchCheck(driver, mobNumber, password), true);
    }




        @AfterMethod // Method will work After each method inside this class
    public void tearDown() {
        driver.close();
    }

    @DataProvider(name = "Studentdata")
    public Object[][] getstudentData() throws FileAlreadyExistsException {

        Object loginData[][] = { { "9000000001", "123456" }, { "9000000024", "123456" }, { "9000000046", "123456" },
                { "9000000069", "123456" }, { "9000000081", "123456" } };
//		Object loginData[][] = { { "9000000001", "123456" } };

        return loginData;
    }
    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = { { "9000000101", "123456" }, { "9000000105", "123456" }, { "9000000110", "123456" },
                { "9000000114", "123456" }, { "9000000120", "123456" } };
//		Object loginData[][] = { { "9000000101", "123456" } };

        return loginData;
    }
}
